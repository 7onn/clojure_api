(ns clojure_api.cheat_sheet-test
  (:use midje.sweet)
  (:use [clojure_api.cheat_sheet]))

(facts "about main"
  (fact "it returns true"
    (-main) => true))