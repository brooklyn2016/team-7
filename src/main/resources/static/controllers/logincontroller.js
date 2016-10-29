angular.module('ftssurvey').controller('logincontroller', ['$scope','$rootScope', function ($scope, $rootScope) {
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
                                  