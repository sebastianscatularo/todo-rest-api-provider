'use strict';
// For any third party dependencies, like jQuery, place them in the vendor folder.
requirejs.config({
    baseUrl: 'vendor',
    paths: {
        'app': '../app',
        'jquery': 'jquery/dist/jquery',
        'handlebars': 'handlebars/handlebars.amd',
    }
});

// Start loading the main app file.
requirejs(['app/main']);