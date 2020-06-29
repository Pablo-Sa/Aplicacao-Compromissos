angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function($scope, $http, contatosAPI, operadorasAPI) {
    $scope.mgs = "Contatos";
    $scope.contatos = [];
    $scope.operadoras = [];
    const carregarContatos = () => {
        contatosAPI.getContato().then(data => {
            $scope.contatos = data.data.content;
            console.log(data.data);
        });
    };
    const carregaOperadora = () => {
        operadorasAPI.getOperadoras().then(data => {
            $scope.operadoras = data.data.content;
            console.log(data.data.content);
        });
    };
    carregaOperadora();
    carregarContatos();
    $scope.adicionarContato = contato => {
        contato.datainclusao = new Date();
        contatosAPI.postContato(contato).then(data => {
            delete $scope.contato;
            carregarContatos();
        });

    };
    $scope.removerContato = contatos => {
        const idsCurrent = [];

        contatos.filter(contato =>{
            if (contato.selecionado){
                let { id } = contato;    
                idsCurrent.push(id);
                }
        });

        const idsForExcluseds = idsCurrent.join(',');

        contatosAPI.deleteContatos(idsForExcluseds).then(response => {
            console.log(response)
        }, error => {
          alert("Ocorreu um Erro, Tente Novamente  ", error);
        });

        $scope.contatos = contatos.filter(contato => {
            if (!contato.selecionado) return contato;
        });
    };

    $scope.selecionado = "selecionado";
    $scope.isContato = contatos => {
        return contatos.some(contato => {
            return contato.selecionado;
        });
    };
    $scope.ordenarPor = campo => {
        $scope.ordenacao = campo;
        $scope.direcaoOrdenacao = !$scope.direcaoOrdenacao;
    };
});