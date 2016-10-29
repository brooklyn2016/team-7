// Module
var ftsapp = angular.module('ftssurvey', ['ngRoute']);

// routes
ftsapp.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {

	//Manually appends header to avoid authentication pop up
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

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
    })// route for the charts page
    .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'logincontroller',
    });
}
]);
