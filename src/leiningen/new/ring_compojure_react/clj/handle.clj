(ns {{name}}.handle
  (:require [compojure.core :as c]
            [compojure.route :as cr]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.format :refer [wrap-restful-format]]
            [{{name}}.middleware :as middleware]
            [clojure.java.io :as io]))

(def app-routes
  (c/routes
    (c/GET "/" [] (slurp (io/resource "public/index.html")))
    (c/POST "/" {:keys [params]} {:body params})
    (cr/not-found "404")))

(def handles
  (-> #'app-routes
      middleware/wrap-xsrf-cookie
      (wrap-defaults site-defaults)
      (wrap-restful-format :formats [:json :json-kw :html])
      wrap-reload))
