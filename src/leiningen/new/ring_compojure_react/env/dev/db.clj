(ns {{name}}.db)

(def database
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname (str "//localhost:3306/watch_dev")
   :user "watch"
   :password "watch"})