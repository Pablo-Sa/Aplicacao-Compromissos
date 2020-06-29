angular.module("listaTelefonica").factory("operadorasAPI", function($http) {
    const _getOperadoras = () => $http.get("https://back-end-app-compromissos.herokuapp.com/operadora");

    return {
        getOperadoras: _getOperadoras
    };
});