(ns clojure_api.car_dealership)

(defn calc
  [carPrice couponRatio]
  (* carPrice couponRatio)
)

(defstruct coupon :discount :ratio :active)
(def availableCoupons [
    (struct coupon "20%" 0.8 true) 
    (struct coupon "30%" 0.7 true)
    (struct coupon "50%" 0.5 true)
    (struct coupon "70%" 0.3 true)
  ]
)

(defstruct car :model :price :active)
(def availableCars [
  (struct car "bmw" 50000.0 true)
  (struct car "fiat" 10000.0 true)
  (struct car "landrover" 100000.0 true)
  (struct car "fusca" 1000.0 false)
])

(defn getCouponRatio
  [code]
  (def coupon (filter #(and (= (:active %) true) (= (compare (:discount %) code) 0)) availableCoupons))
  (:ratio (first coupon))
)

(defn getCarPrice
  [model]
  (def car (filter #(and (= (:active %) true) (= (compare (:model %) model) 0)) availableCars))
  (:price (first car))
)

(defstruct priceTable :model :price)
(defn getPricesByCoupon
  [code]
  (def cars (filter #(= (:active %) true) availableCars))
  (def couponRatio (getCouponRatio code))
  (def offers 
    (vec
      (for [car availableCars ]
        (struct priceTable (:model car) (calc (:price car) (or couponRatio 1)))
      )
    )
  )

  offers
)

(defn -main 
  []
  (println "\n wrong coupon \"XXX\" \n" (getPricesByCoupon "XXX"))
  (println "\nright coupon \"70%\" \n" (getPricesByCoupon "70%") "\n")
)
