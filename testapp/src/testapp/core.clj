(ns testapp.core
  (:gen-class)
  (:use org.httpkit.server)
  )




(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(defn read-file
  [file-path]
  (slurp file-path))

(defn is-url?
  [any-str]
  (.startsWith any-str "http://"))


(defn split-text
  [some-text]
  )


(defonce a 10)
(defonce a 20)


(defn map-fn[value]
  (println (str "this value is exectued" value))
  1)

(def checking-laziness (map map-fn (range 10)))

(defn app [args req]
  (println req)
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (str (first args) "- argument" )})



(defn -main [& args]
  (run-server (partial app args) {:port 8080}))




(defn new-fun[ a-func a-map]
  (a-func 1)
  )
