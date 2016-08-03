(ns {{name}}.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [{{name}}.migrate :as migrate]
            [{{name}}.help :as help]
            [{{name}}.handle :refer [handles]])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (cond
    (help/is-help? args) (help/print-help)
    (migrate/is-migrate? args) (migrate/migrate-with-args args)
    :else (run-jetty handles {:port 3000})))
