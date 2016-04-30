(ns testapp.core
  (:gen-class)
  (:require [ring.adapter.jetty :as ring]
            [compojure.core :refer [defroutes GET POST]]))






(defn app [req]
  (println req)
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "No args changed"})



(defroutes routes
  (GET "/" request (app request))
  (GET "/about" [] "<h2>About us</h2>")
  )

(defn -main [& args]
  (ring/run-jetty #'routes {:port 8080})
  )


