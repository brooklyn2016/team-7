angular.module('ftssurvey').controller('dashboardcontroller', ['$scope','$rootScope','$http', function ($scope, $rootScope, $http) {

   var commname; 
    var commcountry; 
    var commregion, optionvalue; 
  $scope.showContents = false; 
  var headers = {name: commname, region: commregion, country: commcountry};
    
 
  $scope.addcomm = function() {
    
     commname = document.getElementById("commname").value;
     commcountry = document.getElementById("commcountry").value;
     commregion = document.getElementById("commregion").value;
    
    console.log(commcountry + "" + commname);
    
    if((commcountry != "") && (commname!= ""))
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
        
         Materialize.toast('Data received!', 4000); 
        
         
    $('#addcomm').closeModal();
   
      }
    else {
      document.getElementById("countrycheck").innerHTML = "This field cannot be empty!"
      document.getElementById("namecheck").innerHTML = "This field cannot be empty!"
    }
       

  }
  
  $scope.showcomponents = function() {
    
    $scope.showContents=true;  
  }
  
  //need to hide radials
  $scope.showpie = function() {
    
    console.log("it's here");
    var piesettings = {
         "async": true,
         "crossDomain": true,
         "url": "/statistics/all",
         "method": "GET",
         };

      
        $.ajax(piesettings).done(function (response) {
          console.log(response);
        });
    
//    document.getElementById("orgs").style.display = "none";
//    document.getElementById("orgs").style.display = "none";
    
  }

}]);

