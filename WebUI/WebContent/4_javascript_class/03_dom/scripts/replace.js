
// window.onload = function(){	
//document.addEventListener('DOMContentLoaded', function() {
		
  var list = document.getElementById('list');
  var pic = document.getElementById('pic');
  var del = document.getElementById('del');

  // 리스트에서 선택(클릭했을 때)
  list.onclick= function(e){//넘겨주는 값을 저장하고싶으면 변수를 주면 된다.
	  var isbn = e.target.getAttribute('data-isbn');//data-isbn="java" <-값을 가져온다 
	  
	  
	  //<img src = 'images/xxx.jpg' width='100' height = '80'/>
	 
	  var img = document.createElement('img');//동적으로 속성들을 붙여주는 기능
	  img.src = 'images/' + isbn + '.jpg';
	  img.height = 150;
	  img.width = 100;
	  
	  if(pic.getElementsByTagName('img').length>0){//이미 그림이 있다면? 그림을 바꿔버림
		  pic.replaceChild(img,pic.lastChild);//lastChild는 노드의 마지막 자식을 반환합니다.
		 
	  }else{//아무것도 없으니까 일단 먼저 붙임 그다음부터 누르면 바꿔버림
		  pic.appendChild(img);//속성들을 만들어서 자식으로 붙여준다
		  del.disabled=false;//리스트값이 눌리는 순간 삭제 버튼 활성화시킴
	  }
	  
  }
  
  // 삭제 버튼 누르면 pic 아래 자식(img 태그)를 지운다
  del.onclick = function() {
	pic.removeChild(pic.lastChild);
}
  
  
  
  
//};
//});