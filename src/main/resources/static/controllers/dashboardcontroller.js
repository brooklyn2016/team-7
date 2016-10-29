angular.module('ftssurvey').controller('dashboardcontroller', ['$scope','$rootScope','$http', function ($scope, $rootScope, $http) {
  console.log("hi");
   var commname; 
    var commcountry; 
    var commregion; 
  
  
  $scope.addcomm = function() {
    
    console.log("in the controller");
    
     commname = document.getElementById("commname").value;
     commcountry = document.getElementById("commcountry").value;
     commregion = document.getElementById("commregion").value;


		var headers = {name : commname, region: commregion, country: commcountry};

		$http
			.post('/community', {headers: headers})
			.then(function success(response) {
				//If promise is successful checks if login was successful
				if (response.data) {
                    console.log("It's working!");
                    console.log(response);
//					$rootScope.principal = response.data;
                  //redirect at this point
//                  $window.location.href = '/#/dashboard';
                  
				} else {
//					$rootScope.principal = {};
				}
			}, function failure(response) {
//				principal = {}; 
                console.log("It failed!")
			});
  }
}]);