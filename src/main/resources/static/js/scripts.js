// Module
var ftsapp = angular.module('ftssurvey', ['ngRoute']);

// routes
ftsapp.config(['$routeProvider', function($routeProvider) {
    $routeProvider // route for the home page
//    .when('/', {
//        templateUrl: 'views/home.html',
//        controller: 'mainController'
//    })// route for the survey page
    .when('/', {
        templateUrl: 'views/home.html',
        controller: 'homecontroller'
    })// route for the issues page
    .when('/survey', {
        templateUrl: 'views/survey.html',
        controller: 'surveycontroller'
    });// route for the charts page
//    .when('/login', {
//        templateUrl: 'views/login.html',
//        controller: 'lineController',
//    
//    });
}
]);