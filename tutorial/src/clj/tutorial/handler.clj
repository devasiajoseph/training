(ns tutorial.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [tutorial.layout :refer [error-page]]
            [tutorial.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [tutorial.middleware :as middleware]))

(def app-routes
  (routes
    (wrap-routes #'home-routes middleware/wrap-csrf)
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))

(defn app [] (middleware/wrap-base #'app-routes))
