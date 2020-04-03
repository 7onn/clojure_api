(ns clojure_api.http_server
  (:gen-class)
  (:require 
    [org.httpkit.server :refer [run-server]]
    [clj-time.core :as t]
    [compojure.core :refer :all]
    [compojure.route :as route]
  )
)

(defn get-time
  []
  (let 
    [response { :status  200
                :headers {"Content-Type" "text/html"}
                :body    (str (t/time-now))
              }
    ]
    response
  )
)

(defn get-date
  []
  (let 
    [response {:status  200
                :headers {"Content-Type" "text/html"}
                :body    (str (.getTime (java.util.Date.)))}]
    response
  )
)

(defroutes app
  (GET "/" [] "<h1>Welcome</h1>")
  (GET "/get-time" [] (get-time))
  (GET "/get-date" [] (get-date))
  (route/not-found "<h1>Page not found</h1>")
)

(defn -main [& args]
  (println args)
  (run-server app {:port 8080})
  (println "Server started on port 8080")
)