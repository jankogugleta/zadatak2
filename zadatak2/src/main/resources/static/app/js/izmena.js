var myApp = angular.module("myApp");

myApp.controller(
  "IzmenaCtrl",
  function ($scope, $http, $routeParams, $location) {
    $scope.dokument = {};
    $scope.novaStavka = {};
    $scope.roba = [];
    var url = "/api/dokumenti/" + $routeParams.id;
    var urlStavke = "/api/stavke";
    var urlRoba = "/api/roba";

    var getStari = function () {
      $http.get(url).then(
        function success(res) {
          $scope.dokument = res.data;
        },
        function error() {
          alert("Couldn't fetch");
        }
      );
    };

    $scope.uradiIzmenu = function () {
      console.log($scope.dokument);
      $http.put(url, $scope.dokument).then(
        function success() {
          $location.path("/prikaz");
        },
        function error() {
          alert("Something went wrong!!!!!");
        }
      );
    };

    var dodaj = function () {
      $scope.novaStavka.dokumentId = $routeParams.id;
      $http.post(urlStavke, $scope.novaStavka).then(
        function sucess(res) {
          getStari();
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
        function success(res) {
          $scope.roba = res.data;
          getStari();
        },
        function error() {
          alert("Couldn't fetch");
        }
      );
    };

    $scope.potvrdiBrisanje = function (id) {
      if (confirm("Da li ste sigurni da zelite da obrisete ovaj entitet?")) {
        brisi(id);
      }
    };
    var brisi = function (id) {
      var urlb = urlStavke + "/" + id;

      $http.delete(urlb).then(
        function success() {
          alert("Uspesno ste obrisali entitet");
          getStari();
        },
        function error() {}
      );
    };

    getRoba();
  }
);
