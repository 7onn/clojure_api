(ns clojure_api.car_dealership-test
  (:use midje.sweet)
  (:use [clojure_api.car_dealership]))

  (facts "about calc"
    (fact "must run (* price ratio) and return updated sale price"
      (calc 10.0 0.5) => 5.0))
    
  (facts "about getCouponRation"
    (fact "must return nil when input a non-sense coupon"
      (getCouponRatio "xxx") => nil)
    (fact "must return ratio discount when input a valid code"
      (= (getCouponRatio "20%") 0.8)))

  (facts "about getCarPrice"
    (fact "must return nil when input a non-sense car"
      (getCarPrice "xxx") => nil)
    (fact "must return price when input a valid model"
      (getCarPrice "bmw") => 50000.0))
  
  (facts "about getPricesByCoupon"
    (fact "must return regular car prices when input invalid coupon"
      (count(getPricesByCoupon "xxx")) => 4)
    (fact "must return promotional prices when input valid coupon"
      (count(getPricesByCoupon "50%")) => 4))
  