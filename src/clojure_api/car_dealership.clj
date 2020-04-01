(ns clojure_api.car_dealership)

(defstruct coupon :discount :ratio)
(def availableCoupons (seq [(struct coupon "20%" 0.8) (struct coupon "20%" 0.8) (struct coupon "20%" 0.8)]))

(println availableCoupons)

; (defn isCodeValid
;   [code]
;   (if (= (:discount availableCoupons) code)
;     ;;availableCoupon
;     true
;     false
;     )
;   )



(defn getCoupon
  [code]
  true)
