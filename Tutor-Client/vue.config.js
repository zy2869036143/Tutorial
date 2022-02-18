const webpack = require("webpack");
module.exports = {
    configureWebpack: {
        //支持jquery
        plugins: [
            new webpack.ProvidePlugin({
                $ : "jquery",
                jQuery : "jquery",
                "windows.jQuery" : "jquery"
            })
        ]
    },
    devServer: {
        hot: true,
        disableHostCheck: true,
        https: false,
        proxy: { 
          '^/api': 
            {
                target: 'http://localhost:9091',
                changeOrigin: true
            },      
        },
    }
};