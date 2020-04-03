(ns clojure_api.pets)

(defn petToHumanAge
  "This function returns the age of a pet in human years"
  [petType petAge]
  
  (def petStore {"dog" 7, "cat" 5, "goldfish" 10})
  (* (get petStore petType) petAge))