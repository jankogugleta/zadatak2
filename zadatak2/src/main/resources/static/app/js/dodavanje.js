var myApp = angular.module("myApp");

myApp.controller("DodavanjeCtrl", function ($scope, $http, $location) {
  var urlRoba = "/api/roba";
  $scope.novaRoba = {};
  $scope.roba = [];

  var dodaj = function () {
    $http.post(urlRoba, $scope.novaRoba).then(
      function sucess(res) {
        getRoba();
      },
      function error() {
        alert("Greska");
      }
    );
  };
  $scope.dodaj = function () {
    dodaj();
  };

  var getRoba = function () {
    $http.get(urlRoba).then(
      function sucess(res) {
        $scope.roba = res.data;
      },
      function error() {
        alert("Greska");
      }
    );
  };

  var brisi = function (id) {
    var urlb = urlRoba + "/" + id;

    $http.delete(urlb).then(
      function success() {
        alert("Uspesno ste obrisali entitet");
        getRoba();
      },
      function error() {}
    );
  };

  $scope.potvrdiBrisanje = function (id) {
    if (confirm("Da li ste sigurni da zelite da obrisete ovaj entitet?")) {
      brisi(id);
    }
  };
  getRoba();
});
