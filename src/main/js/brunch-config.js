exports.config = {
    "paths": {
        "public": "../webapp/resources/js"
    },
    "files": {
        "stylesheets": {
            "joinTo": "app.css"
        },
        "javascripts": {
            "joinTo": {
				"libraries.js" : /^(?!app\/)/,
				"app.js" : /^app\//
			}
        }
    }
}
