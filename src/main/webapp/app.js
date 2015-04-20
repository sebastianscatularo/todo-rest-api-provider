define([], function() {
  'use strict';

  // Configure require.js paths and shims
  require.config({
    baseUrl: 'vendor',
    paths: {
      'rv': 'requirejs-ractive/rv',
      'router': 'requirejs-router/router',
      'amd-loader': 'requirejs-ractive/amd-loader',
      'ractive': 'ractive/ractive',
      'app': '../app'
    }
  });

  // Load the router
  require(['router'], function(router) {

    // Keep track of the currently loaded view so we can run teardown before loading the new view
    var view;

    router
      .registerRoutes({
        dashboard: { 
            path: '/', 
            moduleId: 'app/pages/dashboard/Dashboard'
        },
        demo: { path: '/demo/:pathArg1', moduleId: 'pages/demo/demoPage' },
        sidebar1: { path: '/sidebar1', moduleId: 'pages/sidebar1/sidebar1Page' },
        sidebar2: { path: '/sidebar2', moduleId: 'pages/sidebar2/sidebar2Page' },
        notFound: { path: '*', moduleId: 'pages/notFound/notFoundPage' }
      }).on('routeload', function onRouteLoad(View) {
        // When a route loads, render the view and attach it to the document
        var render = function() {
          view = new View({ el: 'body' });
        };

        if (view) {
          view.teardown(render);
        } else {
          render();
        }
      }).init(); // Set up event handlers and trigger the initial page load
  });
});