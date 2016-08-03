# ring-compojure-react

A Leiningen template to start web app with ring, compojure, react, webpack.

## Usage

    $ lein new ring-compojure-react your-project-name
    $ cd your-project-name
    $ npm -g install webpack webpack-dev-server
    $ npm install

if you wnat use webpack hot module replace, you should use nginx to
proxy js/app.js to http://localhost:8080/js/app.js

## License

Copyright © 2016 Kevin Jiang <kittymiky@gmail.com>

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
