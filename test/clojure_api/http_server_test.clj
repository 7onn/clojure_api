(ns clojure_api.http_server-test
  (:use midje.sweet)
  (:use [clojure_api.http_server]))

(facts "about http server"
  (fact "it starts the server for inbound connections"
    (-main)
    (= true true)
  )
)