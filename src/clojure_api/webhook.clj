(ns clojure_api.webhook
  (:require 
    [org.httpkit.server :as server]
    [clj-time.core :as t]
    [compojure.core :refer :all]
    [compojure.route :as route]
    [clojure.pprint :as pp]
    [clojure.string :as str]
    [clojure.data.json :as json]
    [ring.middleware.defaults :refer :all]
    [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
    [ring.util.response :refer [response]]
  )
)

(defn webhook
  [req]
  (def body (json/read-str (slurp (:body req))))
  ; (println body)
  (println (get body "ref"))
  (println (get (get body "sender") "login"))

  {
    :status 200
    :body body      
    :headers
      { 
        "Content-Type" "application/json" 
        "when" (str (java.util.Date.)) 
      }
  }
)

(defroutes app-routes
  (POST "/webhook" [] webhook)
  (route/not-found "Error, page not found!"))

(def app
  (wrap-defaults app-routes api-defaults)
)

(defn -main
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
    (server/run-server app {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))
  )
)
