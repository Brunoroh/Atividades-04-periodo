lista = document.getElementsByClassName("selectIMG");
var i;
$(".resultado").addClass('hide');

for(i = 1; i < 6; i++){

	$(lista[i]).addClass('hide');

}

i = 0;

$( ".image_picker_image" ).click(function() {
	if(i < 6){
		$(lista[i]).addClass('hide');
		i += 1;
		$(lista[i]).removeClass('hide');
	}else if(i == 6){
		$(".resultado").removeClass('hide');
	}
	
});

