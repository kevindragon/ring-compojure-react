(ns {{name}}.config
  (:require [ragtime.jdbc :as jdbc]
            [{{name}}.db :as db]))

(def database db/database)

(def migrate-config
  {:datastore  (jdbc/sql-database database)
   :migrations (jdbc/load-resources "migrations")})
