function validaData(data){
    dia  = data.substr(0,2);
    mes  = data.substr(3,2);
    ano = data.substr(6,4);

    maxDias = qtdDias(mes,ano);
    if(dia <= maxDias){
        document.getElementById("resultado").textContent = "Data valida";
        return null;
    }

    document.getElementById("resultado").textContent = "Data invalida";


}

function qtdDias(mes,ano){
    mes = new Date(ano,mes,0);
    
    return mes.getDate();
}

