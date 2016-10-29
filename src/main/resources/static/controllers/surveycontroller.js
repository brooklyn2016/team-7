angular.module('ftssurvey').controller('surveycontroller', ['$scope','$rootScope', function ($scope, $rootScope) {
  var formdata;
  $scope.submitsurvey = function() {
    var data=$scope.form; 
    console.log(data);
  }
}]);
                                  