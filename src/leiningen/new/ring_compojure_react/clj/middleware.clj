(ns {{name}}.middleware
  (:require [ring.middleware.anti-forgery :as anti-forgery]
            [ring.util.response :as response]))


(defn wrap-xsrf-cookie [handle]
  (fn [request]
    (let [resp (handle request)]
      (response/set-cookie
        resp
        "xsrf-token"
        anti-forgery/*anti-forgery-token*))))
