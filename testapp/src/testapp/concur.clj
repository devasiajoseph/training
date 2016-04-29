(ns testapp.concur)


(defn slow-function
  [time-delay]
  (do
    (Thread/sleep time-delay)
    (println "Delayed execution")))
