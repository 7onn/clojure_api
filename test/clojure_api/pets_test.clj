(ns clojure_api.pets-test
  (:use midje.sweet)
  (:use [clojure_api.pets]))


(facts "about `petToHumanAge ` function"
  (fact "one human year counts as 7 for dogs"
    (petToHumanAge "dog" 2) => 14
    
  (fact "one human year counts as 5 for cats"
    (petToHumanAge "cat" 2) => 10)

  (fact "one human year counts as 10 for goldfishes"
    (petToHumanAge "goldfish" 2) => 20)))

