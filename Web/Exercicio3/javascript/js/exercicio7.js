function verificar(){
    numero = document.getElementById("numero").value;
    divisores = 0;
    for(var i = 1; i < numero; i++){
        if(numero%i == 0){
            divisores += i;
        }
    }
    document.getElementById("resultado").textContent = numero == divisores ? "O Numero é Perfeito" : "O Numero não é perfeito";
}