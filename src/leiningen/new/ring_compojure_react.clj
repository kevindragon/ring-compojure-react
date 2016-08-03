(ns leiningen.new.ring-compojure-react
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "ring-compojure-react"))

(defn ring-compojure-react
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' ring-compojure-react project.")
    (->files data
             [".babelrc" (render ".babelrc" data)]
             [".gitignore" (render ".gitignore" data)]
             [".hgignore" (render ".hgignore" data)]
             ["package.json" (render "package.json" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["webpack.config.js" (render "webpack.config.js" data)]
             ["webpack.prod.config.js" (render "webpack.prod.config.js" data)]

             ["env/dev/{{sanitized}}/db.clj" (render "env/dev/db.clj" data)]
             ["env/test/{{sanitized}}/db.clj" (render "env/test/db.clj" data)]
             ["env/prod/{{sanitized}}/db.clj" (render "env/prod/db.clj" data)]

             ["resources/public/index.html" (render "resources/public/index.html" data)]
             ["resources/help.txt" (render "resources/help.txt" data)]

             ["src/clj/{{sanitized}}/config.clj" (render "clj/config.clj" data)]
             ["src/clj/{{sanitized}}/core.clj" (render "clj/core.clj" data)]
             ["src/clj/{{sanitized}}/handle.clj" (render "clj/handle.clj" data)]
             ["src/clj/{{sanitized}}/help.clj" (render "clj/help.clj" data)]
             ["src/clj/{{sanitized}}/middleware.clj" (render "clj/middleware.clj" data)]
             ["src/clj/{{sanitized}}/migrate.clj" (render "clj/migrate.clj" data)]

             ["src/js/component/Nav.jsx" (render "js/component/Nav.jsx" data)]
             ["src/js/page/Home.jsx" (render "js/page/Home.jsx" data)]
             ["src/js/app.jsx" (render "js/app.jsx" data)]
             ["src/js/Layout.jsx" (render "js/Layout.jsx" data)]

             ["src/sass/style.scss" (render "sass/style.scss" data)]
             )))
