(ns testapp.concur)


(defn delay-function [time-delay]
  (do
      (Thread/sleep time-delay)
      (println (str "Delayed execution - " time-delay))))

(defn slow-function
  [time-delay]
  (future
    (do
      (Thread/sleep time-delay)
      (println (str "Delayed execution - " time-delay)))))


(def ms [3000 2000 9000 1000 2300])

(defn test-concur
  []
  (map slow-function )
  )
