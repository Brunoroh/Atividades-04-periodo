function tabuada(){
    n = document.getElementById("numero").value;
    texto = '';
    for(i = 1; i <= 10; i++){
      texto = texto+n+" x "+i+" = "+(n*i)+"<br/>";
    }
    console.log(texto);
    document.getElementById("resultado").innerHTML = texto;
}