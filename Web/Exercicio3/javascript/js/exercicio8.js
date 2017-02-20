function verificar(){
    numeros = document.getElementsByTagName("input");
    n1 = numeros[0].value;
    n2 = numeros[1].value;
    if(n1 > n2){
        aux = n2;
        n2 = n1;
        n1 = aux;
    }

    texto = "";

    for(var i = n1,j = n2; i < j; i++){
       if((i+1)%2 == 0){
           texto = texto+i+",";
       }
    }

    document.getElementById("resultado").textContent = texto;
}