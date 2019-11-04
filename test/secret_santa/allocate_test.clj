(ns secret-santa.allocate-test
  (:require [clojure.test :refer :all]
            [secret-santa.allocate :refer [allocate]]))

(deftest it-does-not-allocate-self
  (let [participants [{:name "Bob"}
                      {:name "Jim"}]
        expected [[{:name "Bob"} {:name "Jim"}]
                  [{:name "Jim"} {:name "Bob"}]]]
    (is (= expected (allocate participants)))))

(deftest it-allocates-satisfying-exclusions
  (let [participants [{:name "Bob" :exclude "Jim"}
                      {:name "Jim" :exclude "Sally"}
                      {:name "Sally" :exclude "Bob"}]
        expected [[{:name "Bob" :exclude "Jim"} {:name "Sally" :exclude "Bob"}]
                  [{:name "Jim" :exclude "Sally"} {:name "Bob" :exclude "Jim"}]
                  [{:name "Sally" :exclude "Bob"} {:name "Jim" :exclude "Sally"}]]]
    (is (= expected (allocate participants)))))

(deftest it-allocates-by-gender
  (let [participants [{:name "Bob" :gender "m"}
                      {:name "Jim" :gender "m"}
                      {:name "Sally" :gender "f"}
                      {:name "Jane" :gender "f"}]
        expected [[{:name "Bob" :gender "m"} {:name "Jim" :gender "m"}]
                  [{:name "Jim" :gender "m"} {:name "Bob" :gender "m"}]
                  [{:name "Sally" :gender "f"} {:name "Jane" :gender "f"}]
                  [{:name "Jane" :gender "f"} {:name "Sally" :gender "f"}]]]
    (is (= expected (allocate participants)))))
