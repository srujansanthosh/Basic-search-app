var App = Ember.Application.create();

App.Router.map(function() {
  // index route is created by default
});

App.IndexController = Em.Controller.extend({
    actions: {
        doSearch: function() {
            var self = this;
            self.set('results', null);
            Em.$.get('/patients/search?query='+this.get('searchText')).then(function(data) {
                for (var i=0;i<data.length;i++) {
                    var docs = data[i].documents;
                    var newDocs = [];
                    for (var j=0;j<docs.length;j++) {
                        parts = docs[j].split(":::");
                        newDocs.push({
                            title: parts[0],
                            date: parts[1],
                            contents: parts[2]
                        });
                    }
                    data[i].documents = newDocs;
                }
                self.set('results', data);
            });     
        }
    }
});


// ******************************************************************************************************************************************************************* //

        //   ------- HIGHLIGHT SEARCH TERM FUNCTION - PARTIAL -------  //


// ******************************************************************************************************************************************************************* //

//    var queryTerm = this.get('searchText');
//    Ember.Handlebars.helper('highlightSearchTerm', function (text, queryTerm) {
//     var highlightedText = text.replace(new RegExp(queryTerm, 'gi'), function (str) {
//        return '<mark>' + str + '</mark>';
//    });
//    return new Ember.Handlebars.SafeString(highlightedText);
//});


//      -- Code to be included in index.html to highlight --

// {{highlightSearchTerm document.title query}} -> The helper function "highlightSearchTerm" will highlight the (query term) in the (title).
// {{highlightSearchTerm document.contents query}} -> The helper function "highlightSearchTerm" will highlight the (query term) in the (contents).
 
 
 // 1. The "highlightSearchTerm" function will take text to be updated and the query term as arguments.
 // 2. It creates a RegExp with the query term and replaces if any query terms in the contents/title with the highlighted query term 
 //            (either using <mark> tags or "backgroud-color:yellow".)
 
 // ******************************************************************************************************************************************************************* //
