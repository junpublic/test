window.onload = function(){

		var frm = document.getElementById('frm');//밑줄이랑 윗줄이랑 같다
//		var frm = document.qurrySelector('#frm');
		var inputs = document.querySelectorAll("input");
		
		frm.onsubmit = function(e){//끌어와서 막고 다시전송!!!하는 기능임 

			e.preventDefault();//자기자신의 이벤트를 막는 것//기존기능막기
			
			//추가된 사항을 검사
//			alert(frm.agree.checked);//체크하면 트루 안하면 false
			if(!frm.agree.checked){//체크하면 트루 안하면 false
				alert('반드시 약관에 동의하세요');
				return;
			}
			
			//전송
			
			frm.submit();
		}


	}