function desenhar(caractere,linhas){

    texto  = "";

    for(var i = 0; i < linhas; i++ ){
        for(var j = 0; j < 10; j++){
            texto += caractere; 
        }
        texto += "<br/>";
    }

    document.getElementById("resultado").innerHTML = texto;

}