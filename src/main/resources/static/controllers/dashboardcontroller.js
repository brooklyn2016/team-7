angular.module('ftssurvey').controller('dashboardcontroller', ['$scope','$rootScope','$http', function ($scope, $rootScope, $http) {

   var commname; 
    var commcountry; 
    var commregion, optionvalue; 
  
  var headers = {name: commname, region: commregion, country: commcountry};
    

    
//    var settingsget = {
//     "async": true,
//     "crossDomain": true,
//     "url": "/community",
//     "method": "GET",
//     "headers": {
//       "region": commregion,
//       "country": commcountry,
//       "name": commname
//      }
//     };
//      
//      
//
//     $.ajax(settingsget).done(function (response) {
//      console.log(optionvalue);
//    });
 
  $scope.addcomm = function() {
    
     commname = document.getElementById("commname").value;
     commcountry = document.getElementById("commcountry").value;
     commregion = document.getElementById("commregion").value;
    
//    optionvalue = document.getElementById("getoption").value;


//		var headers = {name : commname, region: commregion, country: commcountry};
    		var headers = {name: commname, region: commregion, country: commcountry};
    
    
    
    var settings = {
     "async": true,
     "crossDomain": true,
     "url": "/community",
     "method": "POST",
     "headers": {
       "region": commregion,
       "country": commcountry,
       "name": commname
      }
     };
    
    var settingsget = {
     "async": true,
     "crossDomain": true,
     "url": "/community",
     "method": "GET",
     "headers": {
       "region": commregion,
       "country": commcountry,
       "name": commname
      }
     };
      
      
    $.ajax(settings).done(function (response) {
      console.log(response);
    });
    
     $.ajax(settingsget).done(function (response) {
      console.log(optionvalue);
    });
    
    
      
  
  
}
//
//$.ajax(settings).done(function (response) {
// console.log(response);
//});
//
//
//		$http
//			.post('/community', headers)
//			.then(function success(response) {
//				//If promise is successful checks if login was successful
//				if (response.data) {
//                    console.log("It's working!");
//                    console.log(response);
////					$rootScope.principal = response.data;
//                  //redirect at this point
////                  $window.location.href = '/#/dashboard';
//                  
//				} else {
////					$rootScope.principal = {};
//				}
//			}, function failure(response) {
////				principal = {}; 
//                console.log("It failed!")
//			});
//  }

}]);