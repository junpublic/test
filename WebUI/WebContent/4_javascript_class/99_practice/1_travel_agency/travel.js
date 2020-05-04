window.onload= function() {
	//
	var saint=document.getElementById('sainttf');
	var child=document.getElementById('childtf');
	var baby=document.getElementById('babytf');
	
	saint.onchange = calc;//이벤트를 연결만해주는 것이지 호출하는 것이 아니다. calc()안됨!!!!!
	child.onchange = calc;
	baby.onchange = calc;
	
	function calc() {
		total.value = sainttf.value*39000+childtf.value*29000+babytf.value*19000;
	}
}