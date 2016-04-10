(function(angular, _) {
	angular.module("testManager.controllers").controller("testController", function($http, $scope, updateService, $rootScope, $log, $location) {
		
		$scope.formatted="<b>@Rupkumar</b>";
		
		$scope.$on( "receivedFormatted", function(event, args) {
            console.log( 'new page content received after DB call' );
            $scope.formatted = args.htmlStrFromDB;
        });
		
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
		
		$scope.format = function() {
			var tagSelect = document.getElementById("tag").value;
			var handleSelect = document.getElementById("handle").value;
			var output = tagSelect.replace("[xxx]", handleSelect);
			console.log("output = " + output);
			$scope.formatted=output;
			console.log($scope.formatted);
			
			var div = document.getElementById("display");
			var para = document.createElement("p");
	        div.appendChild(para);
		}
		
		
	});
	
	
	angular.module("testManager.controllers").controller("headerController", function($scope, updateService, $rootScope, $log, $location) {

		  $scope.isActive = function (viewLocation) { 
			  return $location.path().includes(viewLocation);
		  };
	});
})(angular, _);