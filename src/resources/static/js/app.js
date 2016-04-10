(function(angular) {

	angular.module('testManager',["testManager.controllers","testManager.services", "ngRoute", "ngHandsontable", "ngFileUpload"]);
	angular.module("testManager.controllers", []);
	angular.module("testManager.services", []);

	angular.module("testManager").config(function($routeProvider) {
		$routeProvider.when('/', {     
			redirectTo: function () {
				return "/showvideos";
			}
		}).when('/test', {
            templateUrl : 'partials/test.html',
            controller  : 'testController'            	
		});
	});
})(angular);
