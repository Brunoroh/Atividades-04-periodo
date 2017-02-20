function qtdDias(){
    mes = document.getElementById("mes").value;
    mes = mes.split("-");
    mes = new Date(mes[0],mes[1],0);
    
    document.getElementById("resultado").textContent = "A Quantidade de dias é "+mes.getDate();
}