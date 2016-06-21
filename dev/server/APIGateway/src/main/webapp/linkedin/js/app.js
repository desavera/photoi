var example = angular.module("example", ['ui.router']);
 
example.config(function($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('login', {
            url: '/login',
            templateUrl: 'templates/login.html',
            controller: 'LoginController'
        })
        .state('secure', {
            url: '/secure',
            templateUrl: 'templates/secure.html',
            controller: 'SecureController'
        });
    $urlRouterProvider.otherwise('/login');
});
 
example.controller("LoginController", function($scope) {
 
    $scope.login = function() {
        window.location.href = "https://www.linkedin.com/uas/oauth2/authorization?response_type=code&client_id=78x8iyk4c9ix2b&redirect_uri=http://localhost:8080/linkedin/oauth_callback.html&scope=r_basicprofile&state=Y65yHHGt655gtt"
    }

});
 
example.controller("SecureController", function($scope) {
 
    $scope.accessToken = JSON.parse(window.localStorage.getItem("accessToken")).oauth.access_token;
 
});

$scope.login = function() {

        window.location.href = "https://www.linkedin.com/uas/oauth2/authorization?response_type=code&client_id=78x8iyk4c9ix2b&redirect_uri=http://localhost:8080/linkedin/oauth_callback.html&scope=r_basicprofile&state=Y65yHHGt655gtt"
}
