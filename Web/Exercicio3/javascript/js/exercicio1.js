function calculaMedia(){
    var n1 = parseInt(document.getElementById("nota1").value);
    var n2 = parseInt(document.getElementById("nota2").value);
    var n3 = parseInt(document.getElementById("nota3").value);
    var media = (n1+n2+n3)/3;
    var text = media > 6 ? "aprovado" : "reprovado";
    document.getElementById("resultado").textContent = "A Media é : "+media+" e o Aluno foi "+text;
}