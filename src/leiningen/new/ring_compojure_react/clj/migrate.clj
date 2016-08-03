(ns {{name}}.migrate
  (:require [ragtime.repl :as repl]
            [{{name}}.config :as config]
            [clojure.java.io :as io]))


(defn is-migrate? [args]
  (->> args
       first
       vector
       (some #{"migrate:make" "migrate" "rollback"})))

(defn- file-names [name]
  (let [ts (System/currentTimeMillis)
        dir (io/resource "migrations")
        up (str dir "/" ts "-" name ".up.sql")
        down (str dir "/" ts "-" name ".down.sql")]
    [up down]))

(defn- create-migrate-file [params]
  (let [name (first params)]
    (doseq [f (file-names name)]
      (io/make-parents f)
      (with-open [r (io/writer f)]
        (println f "created")))))

(defn migrate-with-args [args]
  (let [cmd (first args)
        params (rest args)]
    (cond
      (= cmd "migrate:make") (create-migrate-file params)
      (= cmd "migrate") (repl/migrate config/migrate-config)
      (= cmd "rollback") (repl/rollback config/migrate-config))))
