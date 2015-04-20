define(['ractive', 'rv!app/pages/dashboard/dashboard'], function(Ractive, template) {
    var app = {
        init: function() {
           this.mainView = new Ractive(
                {
                    el: '#application',
                    template: template,
                    data: {
                        'title': 'world'
                    }
                }
            ); 
        } 
    }

    return app;
})