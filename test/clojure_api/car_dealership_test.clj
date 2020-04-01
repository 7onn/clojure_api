(ns clojure_api.car_dealership-test
  (:use midje.sweet)
  (:use [clojure_api.car_dealership]))

  (facts "about available cupons"
    (fact "20% discount must exists"
    ; (getCoupon "20%") => 0.8))
    (getCoupon "20%") => true))