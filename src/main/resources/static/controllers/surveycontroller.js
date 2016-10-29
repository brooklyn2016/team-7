angular.module('ftssurvey').controller('surveycontroller', ['$scope','$rootScope', function ($scope, $rootScope) {
  var formdata;
  $scope.submitsurvey = function() {
    var data=$scope.form;
    console.log(data);
  }

  $scope.survey = {
    "Section A" : {
      "1" : {
        "name": "Traffickers, whether from the village or from outside the village, cannot operate any more.",
        "answer": "",
        "answer-type" : {"1": "Completely true", "2": "Partially true", "3": "Completely Untrue"},
        "grade": ""
      },
      "2" : {
        "name": "No one residing in this village is in any form of slavery.",
        "answer": "",
        "answer-type" : {"1": "Completely true", "2": "Partially true", "3": "Completely Untrue"},
        "grade": ""
      },
      "3" : {
        "name": "People who migrate from this community for work are NOT being trafficked.",
        "answer": "",
        "answer-type" : {"1": "Completely true", "2": "Partially true", "3": "Completely Untrue"},
        "grade": ""
      },
      "4" : {
        "name": "None of the children in this village are being exploited for commercial sex.",
        "answer": "",
        "answer-type" : {"1": "Completely true", "2": "Partially true", "3": "Completely Untrue"},
        "grade": ""
      },
      "5" : {
        "name": "None of the children in this village are performing hazardous labor.",
        "answer": "",
        "answer-type" : {"1": "Completely true", "2": "Partially true", "3": "Completely Untrue"},
        "grade": ""
      }
    },
    "Section B" : {
      "answer-type" : ["All residents", "Some residents", "No residents"],
      "6" : {
        "name": "Residents in this village know how to protect themselves from trafficking during migration for work.",
        "answer": "",
        "grade": ""
      },
      "7" : {
        "name": "Residents understand the risks of sending children to distant jobs, e.g. domestic work, mining or stone quarries, and circuses.",
        "answer": "",
        "grade": ""
      },
      "8" : {
        "name": "Residents are able to identify and pressure known traffickers to leave when they appear in the community.",
        "answer": "",
        "grade": ""
      },
      "9" : {
        "name": "Residents in this village know how to avoid debt bondage.",
        "answer": "",
        "grade": ""
      },
      "10" : {
        "name": "Residents understand the risks of early or forced marriage and false offers of marriage.",
        "answer": "",
        "grade": ""
      },
      "11" : {
        "name": "Residents understand the risks of early or forced marriage and false offers of marriage.",
        "answer": "",
        "grade": ""
      },
      "12" : {
        "name": "Residents are able to confront domestic violence.",
        "answer": "",
        "grade": ""
      }
    }
  }
}]);
