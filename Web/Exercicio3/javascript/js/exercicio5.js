function numerosImpares(){
    n = document.getElementById("numero").value;
    text = n%2 == 0 ? n-1 : n;
    for(i = (text-2); i > 0; i = i-2){
        text = i+","+text;
    }

    document.getElementById("resultado").textContent = "Os Numeros são :"+text;
}