(ns clojure_api.fibonacci-test
  (:use midje.sweet)
  (:use [clojure_api.fibonacci]))

(facts "about fibonacci"
  (fact "it returns the fibonacci sequence until the desired amount"
    (fibonacci 2) => [0 1])
  (fact "it returns the fibonacci sequence until the desired amount"
    (fibonacci 3) => [0 1 1])
  (fact "it returns the fibonacci sequence until the desired amount"
    (fibonacci 4) => [0 1 1 2])
  (fact "it returns the fibonacci sequence until the desired amount"
    (fibonacci 5) => [0 1 1 2 3]))
