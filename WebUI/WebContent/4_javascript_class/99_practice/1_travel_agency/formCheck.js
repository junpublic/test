window.onload = function(){
	var saint=document.getElementById('sainttf');
	var child=document.getElementById('childtf');
	var baby=document.getElementById('babytf');
	
	saint.onchange = calc;//이벤트를 연결만해주는 것이지 호출하는 것이 아니다. calc()안됨!!!!!
	child.onchange = calc;
	baby.onchange = calc;
	
	function calc() {
		total.value = sainttf.value*39000+childtf.value*29000+babytf.value*19000;
	}
		
		frm.onsubmit = function(e){//끌어와서 막고 다시전송!!!하는 기능임 

			e.preventDefault();//자기자신의 이벤트를 막는 것//기존기능막기
			
			//추가된 사항을 검사
//			alert(frm.agree.checked);//체크하면 트루 안하면 false
			if(!frm.checkbox1.checked){//체크하면 트루 안하면 false
				alert('여행약관에 동의하세요');
				return;
			}
			if(!frm.checkbox2.checked){//체크하면 트루 안하면 false
				alert('개인정보보호정책에 동의하세요');
				return;
			}
			
			//전송
			
			frm.submit();
		}


	}