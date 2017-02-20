function eDivisivel(){
    numero = parseInt(document.getElementById("numero").value);

    if(numero % 3 == 0 && numero % 5 == 0){
        text = 'É divisil';
    }else{
        text = 'Não é divisil';
    }
    document.getElementById("resultado").textContent = text;
}