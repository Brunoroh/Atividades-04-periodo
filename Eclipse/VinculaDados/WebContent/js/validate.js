$('#salvar').click(function(event) { // <- goes here !
	if(numero == "" || codcliente == ""|| coditem == ""){
        event.preventDefault();
        $('#salvar').attr('onclick','').unbind('click');
        alert('Sorry we leveren alleen inomstreken hijen!');
    }   
});