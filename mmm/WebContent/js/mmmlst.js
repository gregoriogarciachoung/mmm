ellanomehacecaso.controller('ella', function($scope, $http) {
	
	$scope.listaSexo = function(){
		$scope.sexos = [
		                {
		                	id : 1,
		                	nom : 'Hombre'
		                },
		                {
		                	id: 2,
		                	nom : 'Mujer'
		                }
		                ]
	},
	
	$scope.listaOtroUsuario = function() {
		$http({
		method: 'POST',
		url: 'cargaOtroUsuario'
		}).then(function(response) {
		$scope.datos = response.data.lstOtroUsuario;
		});
	},
	$scope.listaMisDatos = function() {
		$http({
		method: 'POST',
		url: 'cargaMisDatos'
		}).then(function(response) {
		$scope.datos = response.data.lstMisDatos;
		});
	},
	$scope.listaMisFiltros = function() {
		$http({
		method: 'POST',
		url: 'cargaMisFiltros'
		}).then(function(response) {
		$scope.datos = response.data.lstMisFiltros;
		});
	},
	$scope.listaMisOtrosIntereses = function() {
		$http({
		method: 'POST',
		url: 'cargaMisOtrosIntereses'
		}).then(function(response) {
		$scope.datos = response.data.lstMisOtrosIntereses;
		});
	},
	$scope.listaRelacionInteres = function() {
		$http({
		method: 'POST',
		url: 'listaRelacionInteres'
		}).then(function(response) {
		$scope.adatos = response.data.lstRelacionInteres;
		});
	}
});