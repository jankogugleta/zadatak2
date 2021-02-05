var myApp = angular.module("myApp");

myApp.controller("HomeCtrl", function ($scope) {
  $scope.message = "Zadatak2";
});

myApp.config([
  "$routeProvider",
  function ($routeProvider) {
    $routeProvider
      .when("/", {
        templateUrl: "/app/html/home.html",
      })
      .when("/prikaz", {
        templateUrl: "/app/html/prikaz.html",
      })
      .when("/dodavanje", {
        templateUrl: "/app/html/dodavanje.html",
      })
      .when("/izmena/:id", {
        templateUrl: "/app/html/izmena.html",
      })
      .otherwise({
        redirectTo: "/",
      });
  },
]);
