(ns user
  (:require [mount.core :as mount]
            tutorial.core))

(defn start []
  (mount/start-without #'tutorial.core/repl-server))

(defn stop []
  (mount/stop-except #'tutorial.core/repl-server))

(defn restart []
  (stop)
  (start))


