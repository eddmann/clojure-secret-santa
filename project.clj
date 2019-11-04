(defproject secret-santa "1.0.0"
  :description "Allocates and emails secret santas"
  :url "https://github.com/eddmann/secret-santa"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [com.draines/postal "2.0.3"]
                 [environ "1.1.0"]
                 [org.clojure/data.csv "0.1.4"]]
  :plugins [[lein-cljfmt "0.6.4"]]
  :main ^:skip-aot secret-santa.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
