'use strict';

define([
'jquery',
'handlebars'
], function ($, handlebars) {
    console.log(handlebars);
    var template = handlebars.compile('<div class="entry"><h1>{{title}}</h1><div class="body">{{body}}</div></div>');
    $('#application').append(template({title: "hola", body: "mundo"}));
    //dashboard.render();
});