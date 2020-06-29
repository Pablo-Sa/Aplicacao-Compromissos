angular.module("listaTelefonica").factory("contatosAPI", function($http) {
    const _getContato = () => $http.get("https://back-end-app-compromissos.herokuapp.com/contatos");
    
    const _postContato = contato =>  $http.post("https://back-end-app-compromissos.herokuapp.com/contatos", contato);

    const _deleteContatos = idsForExcluseds => $http.delete(`https://back-end-app-compromissos.herokuapp.com/contatos/${idsForExcluseds}`);
    
    return {
        getContato: _getContato,
        postContato: _postContato,
        deleteContatos: _deleteContatos
    };
});