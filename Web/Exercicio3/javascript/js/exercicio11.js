function bisexto(ano){
    if(new Date(ano,02,0).getDate() == 29){
        document.getElementById("resultado").textContent = 1;
        return 1;
    }
    document.getElementById("resultado").textContent = 0;
    return 0;
}