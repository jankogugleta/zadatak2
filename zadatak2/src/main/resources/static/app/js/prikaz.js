var myApp = angular.module("myApp");

myApp.controller("PrikazCtrl", function ($scope, $http, $location) {
  var url = "/api/dokumenti";
  $scope.dokumenti = [];
  $scope.novi = {};

  var getDokumenti = function () {
    $http.get(url).then(
      function sucess(res) {
        $scope.dokumenti = res.data;
      },
      function error() {
        alert("Greska");
      }
    );
  };
  getDokumenti();

  $scope.potvrdiBrisanje = function (id) {
    if (confirm("Da li ste sigurni da zelite da obrisete ovaj entitet?")) {
      brisi(id);
    }
  };
  var brisi = function (id) {
    var urlb = url + "/" + id;

    $http.delete(urlb).then(
      function success() {
        alert("Uspesno ste obrisali entitet");
        getDokumenti();
      },
      function error() {}
    );
  };

  $scope.goToIzmena = function (id) {
    $location.path("/izmena/" + id);
  };

  var dodaj = function () {
    $http.post(url, $scope.novi).then(
      function sucess(res) {
        getDokumenti();
      },
      function error() {
        alert("Greska");
      }
    );
  };
  $scope.dodaj = function () {
    dodaj();
  };
});
