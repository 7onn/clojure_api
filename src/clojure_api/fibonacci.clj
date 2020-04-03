(ns clojure_api.fibonacci
  (:gen-class)
)

(defn fibonacci
  [amount] 
  (def result (loop [res [0 1]]
    (if (>= (count res) amount)
      res
      (recur (conj 
        res 
        (+ 
          (inc (last res)) 
          (dec (last (butlast res)))
        )
      ))
    )
  ))
  result
)

(defn -main 
  [] 
  (println "fibonacci's first 21" (fibonacci 21))
)
