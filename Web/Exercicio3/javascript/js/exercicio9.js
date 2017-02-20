function verificar(){
    numero = document.getElementById("numero").value;
    document.getElementById("resultado").textContent = "Retornou "+parOuImpar(numero);
}

function parOuImpar(numero){
    if(numero%2 == 0 ){
        return 0;
    }
    return 1;
}