(ns clojure_api.http_server
  (:require 
    [org.httpkit.server :as server]
    [compojure.core :refer :all]
    [compojure.route :as route]
    [clojure.pprint :as pp]
    [clojure.string :as str]
    [clojure.data.json :as json]
    [ring.middleware.defaults :refer :all]
    [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
    [ring.util.response :refer [response]]
  )
  (:gen-class)
)

(def people-collection (atom []))
(defn addperson 
  [firstname surname]
  (swap! people-collection conj 
    {
      :firstname (str firstname) 
      :surname (str surname)
    }
  )
)

(defn default-headers
  []
  { 
    "Content-Type" "application/json" 
    "when" (str (java.util.Date.))
  }
)

(defn people-handler 
  [req]
  {
    :status 200
    :headers (default-headers)
    :body (str (json/write-str @people-collection))
  }
)

(defn addperson-handler 
  [req]
  {
    :status 200
    :headers (default-headers)
    :body (str (json/write-str (addperson "tom" "pshh")))
  }
)

(defn webhook
  [req]
  {
    :status 200
    :headers (default-headers)
    :body (->>
            (str (slurp (:body req)))
          )
  }
)

(defroutes app-routes
  (POST "/webhook" [] webhook)
  (GET "/people" [] people-handler)
  (POST "/people/add" [] addperson-handler)
  (route/not-found "Error, page not found!"))

(def app
  (wrap-defaults app-routes api-defaults)
)

(defn -main
  "This is our main entry point"
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
    (server/run-server app {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))
  )
)
