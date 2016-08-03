(ns {{name}}.help
  (:require [clojure.java.io :as io]))

(defn is-help? [args]
  (= (first args) "help"))

(defn print-help []
  (println (slurp (io/resource "help.txt"))))