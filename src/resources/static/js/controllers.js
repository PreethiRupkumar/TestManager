(function(angular, _) {
	angular.module("testManager.controllers").controller("testController", function($http, $scope, updateService, $rootScope, $log, $location) {
		
		$scope.user = "rupkumar";
		$scope.count = "";
		$scope.responseTime = "";
		$scope.model = {
				videos: [],
		}

		$scope.submit = function() {
			console.log("user =" + $scope.user);
			$http.get("/api/getTagList").then(function(response) {
				console.log(respone);
				$scope.model.tags = response.data.tagList;
				var count = response.data.tagList.length;
			});
		}
	});
	
	
	
	angular.module("testManager.controllers").controller("headerController", function($scope, updateService, $rootScope, $log, $location) {

		  $scope.isActive = function (viewLocation) { 
			  return $location.path().includes(viewLocation);
		  };
	});
})(angular, _);