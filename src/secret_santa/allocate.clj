(ns secret-santa.allocate)

(defn- group [participants]
  (map last (group-by :gender participants)))

(defn- valid? [[buyer receiver]]
  (and (not= (:name buyer) (:name receiver))
       (not= (:exclude buyer) (:name receiver))))

(defn- random [buyers]
  (let [allocations (map vector buyers (shuffle buyers))]
    (if (every? valid? allocations)
      allocations
      (recur buyers))))

(defn allocate [participants]
  (mapcat random (group participants)))
