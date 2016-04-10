(function(angular, _) {
	angular.module("testManager.controllers").controller("testController", function($http, $scope, updateService, $rootScope, $log, $location) {
		
		$scope.submit = function() {
			$http.get("/api/getTagList").then(function(response) {
				console.log(response.data.tagList);
				var tagList = response.data.tagList;
				var count = tagList.length;
				var tagSelect = document.getElementById("tag");
				for(i=0; i<count; i++) {
					tagSelect.options[i] = new Option(tagList[i], tagList[i]);
				}
				
				var handleList = response.data.handleList;
				var handleCount = handleList.length;
				var handleSelect = document.getElementById("handle");
				for(i=0; i<handleCount; i++) {
					handleSelect.options[i] = new Option(handleList[i], handleList[i]);
				}
			});
		}
		
		$scope.apply = function() {
			var show = document.getElementById("show").value;
			var tagSelect = document.getElementById("tag").value;
			var handleSelect = document.getElementById("handle").value;
			var output = tagSelect.replace("[xxx]", handleSelect);
			show.innerHTML=output;
		}
	});
	
	
	
	angular.module("testManager.controllers").controller("headerController", function($scope, updateService, $rootScope, $log, $location) {

		  $scope.isActive = function (viewLocation) { 
			  return $location.path().includes(viewLocation);
		  };
	});
})(angular, _);