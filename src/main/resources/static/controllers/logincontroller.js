angular.module('ftssurvey').controller('logincontroller', ['$scope','$rootScope', '$http','$window', function ($scope, $rootScope, $http, $window) {


	$rootScope.principal = {};
	$scope.credentials = {};


	$scope.login = function() {
		//Headers for Basic Auth
        
      $scope.checkpassword();
      
      
		var headers = $scope.credentials ? {authorization : 'Basic ' + btoa($scope.credentials.username + ':' + $scope.credentials.password)} : {};

		$http
			.get('./user', {headers: headers})
			.then(function success(response) {
				//If promise is successful checks if login was successful
				if (response.data.username) {
                    console.log("It's working!");
					$rootScope.principal = response.data;
                  //redirect at this point
                  $window.location.href = '/#/dashboard';
                  
				} else {
					$rootScope.principal = {};
				}
			}, function failure(response) {
				principal = {}; 
                console.log("It failed!")
			});
	};


  $scope.checkpassword = function() {

      var pswdval = document.getElementById("password");

      if(!pswdval.value.match(/[A-z]/))
          {
              document.getElementById("pcheck").innerHTML = "The input should contain 1 lowercase character.";
              pswdval.setCustomValidity("The input should contain 1 lowercase character.");
          }
      else if(!pswdval.value.match(/[A-Z]/))
          {
              document.getElementById("pcheck").innerHTML = "The input should contain 1 uppercase character.";
              pswdval.setCustomValidity("The input should contain 1 uppercase character.");
          }
      else if(!pswdval.value.match(/\d/))
          {
              document.getElementById("pcheck").innerHTML = "The input should contain 1 number.";
              pswdval.setCustomValidity("The input should contain 1 number.");
          }
      else if(pswdval.value.length < 8)
          {
             document.getElementById("pcheck").innerHTML = "The input should be more than 8 characters.";
             pswdval.setCustomValidity("The input should contain 8 characters.");
          }
      else{
          document.getElementById("pcheck").innerHTML = " ";
      }
  }

}]);
