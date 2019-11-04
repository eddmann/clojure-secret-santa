(ns secret-santa.core
  (:use [postal.core :only [send-message]]
        [environ.core :refer [env]]
        [clojure.data.csv :as csv]
        [secret-santa.allocate :only [allocate]])
  (:gen-class))

(defn- csv->participants [file]
  (letfn [(csv-data->maps [csv-data]
            (map zipmap
                 (->> (first csv-data) (map keyword) repeat)
                 (rest csv-data)))]
    (->> (slurp file)
         csv/read-csv
         csv-data->maps)))

(defn- send-mail [buyer-email receiver-name]
  (send-message {:host "smtp.gmail.com"
                 :user (env :gmail-username)
                 :pass (env :gmail-password)
                 :ssl true}
                {:from (env :gmail-username)
                 :to buyer-email
                 :subject "Secret santa! 🎅"
                 :body (str "You're secret santa for " receiver-name)}))

(defn -main [file & args]
  (let [participants (csv->participants file)]
    (doseq [[buyer receiver] (allocate participants)]
      (println (str "Sent " (:name buyer)))
      (send-mail (:email buyer) (:name receiver)))))
