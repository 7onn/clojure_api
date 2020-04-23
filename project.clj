(defproject clojure_api "0.0.1"
  :main clojure_api.http_server
  :description "Cool new project to do things and stuff"
  :dependencies [
    [org.clojure/clojure "1.7.0"] 
    [clj-time "0.14.0"]
    [compojure "1.6.1"]
    [http-kit "2.3.0"]
    [ring/ring-defaults "0.3.2"]
    [org.clojure/data.json "0.2.6"]  
    [ring/ring-json "0.5.0"]
  ]
  :profiles {:dev {:dependencies [[midje "1.5.1"]]}})