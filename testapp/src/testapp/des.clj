(ns testapp.des)


(defn test-des [a]
  (let [[x y] a]
    (println y)
    ))

(defn test-map
  [mp]
  (let [{a :name b :age} mp]
    (println a)
    (println b)))


;;{:name "asas" :address [{:type "residential" :city "baangalore"} {:type "office" :city "chennai"}]}
(defn test-map2 [mp]
  (let [{name :name {city :city} :address} mp]
    (println city)
    )
  )

(defn filter-fn [mp]
  (= (:type mp) "office")
  
  )

(defn kp-return [mp]
  {:city (:city mp)}
  )

(defn test-map-3 [mp]
  (let [city (:city (:address mp))]
    (println city)
    (get-in mp [:address :city])
    )
    (map  (fn [mp] {:city (:city mp)}) (filter-fn (:address mp)))
  )

(defn test-except []
  (try
  (/ 1 0)
  (catch ArithmeticException e (println "Some exception"))
  (finally (prn "final exception."))))


(defn check-zero
  [previous next]
  (if (= next 0)
    0
    true
    ))


(defn check-zero1
  [some-list]
  )

(defn pos-neg-or-zero
  "Determines whether or not n is positive, negative, or zero"
  [n]
  (cond
    (< n 0) "negative"
    (> n 0) "positive"
    :else "zero"))

;;(pos-neg-or-zero 1)
;;=> positive


(defn test-condp []
  (condp some [1 2 3 4]
    #{0 6 7} :>> inc
    #{4 5 9} :>> dec
    #{1 2 3} :>> #(+ % 3)))


(defn switch-test [n]
  (case n
    "abc" (println "first")
    "bcd" (println "second")
    "efg" (println "third")
    "default"
    )
  
  )
;;switch-test "abc"
;;=> first



(defn recur-sum
  [sum array]
  
  (if (empty? array)
    sum
    (do
      (+ sum (first array))
      (recur (+ sum (first array)) (rest array))
      )) )


(defn fact [x]
    (loop [n x f 1]
        (if (= n 1)
            f
            (recur (dec n) (* f n)))))
