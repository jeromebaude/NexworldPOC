"use strict";

var $ = require('jquery');

var App = {
  init: function init() {
	
	$.ajax({
        url: "http://localhost:8080/Elis_POC/sites/"
    }).then(function(data) {
    	for(var pos in data)
    	{
    		$('body').append("Site : "+data[pos].nom+
    				", nombre de salariés : "+data[pos].nombreSalaries+"<br>");
    	}
    	
       $('.sites').append(data);
    });
  }
};

module.exports = App;
