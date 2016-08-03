(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.5.0"]
                 [ring-middleware-format "0.7.0"]
                 [ring/ring-defaults "0.2.1"]
                 [ring/ring-anti-forgery "1.0.1"]
                 [compojure "1.5.1"]
                 [ragtime "0.6.1"]
                 [org.clojure/java.jdbc "0.6.1"]
                 [mysql/mysql-connector-java "5.1.35"]]

  :plugins [[lein-pprint "1.1.1"]]

  :main ^:skip-aot {{name}}.core
  :source-paths ["src/clj"]
  :target-path "target/%s"

  :profiles
  {:uberjar {:aot          :all
             :uberjar-name "{{name}}.jar"}

   :dev     {:source-paths ["env/dev"]
             :uberjar-name "{{name}}_dev.jar"}

   :test    {:source-paths ["env/test"]
             :uberjar-name "{{name}}_test.jar"}

   :prod    {:source-paths ["env/prod"]}})
