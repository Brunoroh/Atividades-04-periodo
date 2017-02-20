function calcularMaior(){
    numeros = document.getElementsByTagName("input");
    console.log(numeros);
    numero = 0;
    for(var i = 0; i < numeros.length;i++){
        if(numero < numeros[i].value){
            numero = numeros[i].value;
        }
    }

    document.getElementById('resultado').textContent = "O Maior numero é "+numero;
}