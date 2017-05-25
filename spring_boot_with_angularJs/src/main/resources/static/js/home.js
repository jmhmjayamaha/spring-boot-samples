var app = angular.module("myApp", []);
app.controller("myController", function($scope, $http) {
	$http.get("http://localhost:8080/greeting").then(
			function(response) {
				$scope.greetings = response.data;
			}
	);
});