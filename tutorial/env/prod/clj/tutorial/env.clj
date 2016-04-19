(ns tutorial.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[tutorial started successfully]=-"))
   :middleware identity})
