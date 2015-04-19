define(['handlebars', 'jquery'], function(handlebars, $) {
    return {
        show: function() {
            console.log("Hola");
            $('body').append("<h1> hello </h1>");
        }
    }
});