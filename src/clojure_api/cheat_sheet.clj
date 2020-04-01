(ns clojure_api.cheat_sheet)

(defn -main [] true)
(-main)


;;
;;  CONDITIONALS
;;
; (defn condIf
;   [x y]
;   (if (= x y) true false))

; (defn condIfDo
;   []
;   (println "\ncondIfDo:")
;   (if (= 5 5)
;     (do (println "Equal first statement")
;         (println "Second statement"))
;     (do (println "Not equal first statement")
;         (println "Second statement"))
;     ))
; ; (condIfDo)

; (defn condNestedIf
;   []
;   (println "\ncondNestedIf:")
;   (if (and (= 5 5) (or (= 2 2) (not true)))
;     (println true)
;     (println false)
;     ))
; ; (condNestedIf)

; (defn condCase
;   []
;   (println "\ncondCase:")
;   (def pet "dog")
;   (case pet
;     "cat" (println "I have a cat")
;     "dog" (println "I have a dog")
;     "fish" (println "I have a fish")
;     ))
; ; (condCase)

; (defn condcond
;   []
;   (println "\ncondCond:")
;   (def amount 5)
;   (cond
;     (<= amount 2) (println "Few")
;     (<= amount 10) (println "Several")
;     (<= amount 100) (println "Many")
;     :else (println "Loads")
;     ))
; ; (condcond)

; ;;
; ;;Atoms
; ;;
; (defn Atoms
;   []
;   (def amount (atom 100))
;   (println @amount)
;   (swap! amount inc)
;   (println @amount)
;   (reset! amount 110)
;   (println @amount)
;   (compare_and_set! amount 110 120)
;   (println @amount)
;   (compare_and_set! amount 110 150)
;   (println @amount)
;   )
; ; (Atoms)

; ;;
; ;;Sequences
; ;;
; (defn Seq
;   []
;   (def colors (seq ["red" "green" "blue"]))
;   (println colors)

;   (println (cons "yellow" colors) )
;   (println (cons colors "yellow"))

;   (println (conj colors "yellow"))
;   (println (conj ["red" "green" "blue"] "yellow"))

;   (println (concat colors (seq ["black", "white"])))

;   (println (distinct (seq [1 2 3 5 3 5 2 4])))

;   (println (reverse colors))

;   (println (first colors))
;   (println (rest colors))
;   (println (last colors))

;   (println (sort (seq [1 2 3 5 3 5 2 4])))
;   )
; ; (Seq)

; ;;
; ;;Destructuring
; ;;
; (defn Destruct
;   []
;   (def myVect [1 2 3 4])
;   (let [[a b c] myVect] (println a b c) )

;   (let [[a b & rest] myVect] (println a b rest))

;   (def myMap {'name "John" 'lastname "Smith"})
;   (let [{a 'name b 'lastname} myMap] (println a b))
;   (let [{a 'name b 'lastname c 'noname} myMap] (println a b c))
;   )
; ; (Destruct)

; ;;
; ;;Struct maps
; ;;
; (defn Pets
;   []
;   (defstruct pets :PetType :PetName)
;   (def myPet (struct pets "dog" "Fido"))
;   (println myPet)

;   (def myOtherPet (struct_map pets :PetName "Fifi" :PetType "cat"))
;   (println myOtherPet)
;   (println (:PetName myOtherPet))
;   (println (:PetType myOtherPet))

;   (def myNewPet (assoc myPet :PetName "Max"))
;   (println myNewPet)

;   (def myNewOtherPet (assoc myOtherPet :PetAge 10))
;   (println myNewOtherPet)
;   )
; ; (Pets)

; ;;
; ;;Loops
; ;;
; (defn Loop
;   []
;   (println "\nLoop:")
;   (loop [x 0]
;     (when (< x 10)
;       (println x)
;       (recur (inc x)))
;     ))
; ; (Loop)

; (defn DoTimes
;   []
;   (println "\nDoTimes:")
;   (dotimes [x 10]
;     (println x)
;     ))
; ; (DoTimes)

; (defn WhileDo
;   [count]
;   (println "\nWhileDo:")
;   (def x (atom 0))
;   (while (< @x count)
;     (do
;       (println @x)
;       (swap! x inc)))
;   )
; ; (WhileDo 10)

; (defn DoSeq
;   [seq]
;   (println "\nDoSeq:")
;   (doseq [x seq]
;     (println (inc x))
;     ))
; ; (DoSeq [1 2 3 4 5])

; ;;
; ;;Exceptions
; ;;
; (defn ExHandling
;   [x]
;   (try
;     (inc x)
;     (catch ClassCastException e (println "Caught exception:" (.getMessage e)))
;     (catch Exception e (println "Caught generic exception"))
;     (finally (println "cleanup and move on"))
;     )
;   )
; ; (ExHandling "hello")