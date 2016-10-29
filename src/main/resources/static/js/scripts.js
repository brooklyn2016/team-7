// Module
var ftsapp = angular.module('ftssurvey', ['ngRoute']);

// routes
ftsapp.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {

	//Manually appends header to avoid authentication pop up
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    $routeProvider // route for the home page

    .when('/', {
        templateUrl: 'views/login.html',
        controller: 'logincontroller'
    })// route for the survey page
    .when('/survey', {
        templateUrl: 'views/survey.html',
        controller: 'surveycontroller'
    })// route for the login page
    .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'logincontroller',
    
    })// route for the dashboard page
    .when('/dashboard', {
        templateUrl: 'views/dashboard.html',
        controller: 'dashboardcontroller',
    });
}
]);
