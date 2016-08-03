var webpack = require('webpack');
var path = require('path');

var SRC_DIR = path.resolve(__dirname, 'src/js');
var DIST_DIR = path.resolve(__dirname, 'resources/public/js');

var config = {
  context: path.join(__dirname, "/"),
  entry: [
    'webpack-dev-server/client?http://0.0.0.0:8080',
    'webpack/hot/only-dev-server',
    SRC_DIR + '/app.jsx'
  ],
  output: {
    publicPath: "/js/",
    path: DIST_DIR,
    filename: 'app.js'
  },
  devtool: 'source-map',
  devServer: {
    contentBase: DIST_DIR,
    inline: true,
    hot: true,
    port: 8080
  },
  module: {
    loaders: [
      {
        test: /\.jsx?/,
        include: SRC_DIR,
        exclude: /node_modules/,
        loaders: ['react-hot', 'babel']
      },
      {
        test: /\.css$/,
        loader: "style-loader!css-loader"
      },
      {
        test: /\.scss$/,
        loaders: ['style', 'css', 'sass']
      },
      {
        test: /\.(png|woff|woff2|eot|ttf|svg)$/,
        loader: 'url-loader?limit=100000'
      }

    ]
  },
  plugins: [
    new webpack.HotModuleReplacementPlugin()
  ]
};

module.exports = config;