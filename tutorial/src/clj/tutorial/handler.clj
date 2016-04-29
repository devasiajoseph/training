(ns tutorial.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [tutorial.layout :refer [error-page]]
            [tutorial.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [tutorial.middleware :as middleware]))

(def app-routes
  (routes
    (-> #'home-routes
        (wrap-routes middleware/wrap-csrf)
        (wrap-routes middleware/wrap-formats))
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))

(defn app [] (middleware/wrap-base #'app-routes))
