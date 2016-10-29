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
    
    if(commcountry != null && commname!= null)
      {
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

      
        $.ajax(settings).done(function (response) {
          console.log(response);
        });
      }
    else {
      document.getElementById("countrycheck").innerHTML = "This field cannot be empty!"
      
      document.getElementById("namecheck").innerHTML = "This field cannot be empty!"
    }
       

  }

}]);

