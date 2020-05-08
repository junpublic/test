$(function() {
	var topDiv=$('.tabSet');
	var anchors = topDiv.find('.tabs a');//탭들
	var panelDivs = topDiv.find('div .panel');//내용들
	
	anchors.show();//텝들 보이게함
	panelDivs.hide();//내용들 숨김
	
	var lastAnchors = anchors.filter('.on');//탭들중에 on클래스가있는 것을 찾음 // find와  filter의 차이점
	var lastPanel = $(lastAnchors.attr('href'));
	lastPanel.show();
	
	anchors.click(function() {
		//눌려진 요소에 클래스명 on 지정
		/*
		 * 1)현재 이벤트가 발새한 a태그와 그 href(패널)을 얻어와서 변수에 지정
		 * 2)기존 a태그(lastAnchors)에서 on 클라스 제거
		 * 3)현재 a태그에 on클래스를 추가
		 * 
		 * 4)기존패널(lastPanel) 감추기
		 * 5)현재패널	보이기
		 * 
		 * 6)현재 a태그와 현재 패널을  lastAnchors,lastPanel지정하기
		 */
		//1 현재 이벤트가 발새한 a태그와 그 href(패널)을 얻어와서 변수에 지정
		var currentAnchor = $(this);//현재테그
		var currentPanel = $(currentAnchor.attr('href'));//아이디와 똑같은 기능을 함 href안의 값을 가져와서 그것을 찾으니까 아이디랑 같은기능임
		//2 기존 a태그(lastAnchors)에서 on 클라스 제거
		lastAnchors.removeClass('on');
		//3 현재 a태그에 on클래스를 추가
		$(this).addClass('on');
		//4기존패널(lastPanel) 감추기
		lastPanel.hide();
		//5 현재패널	보이기
		currentPanel.show();
		//6 현재 a태그와 현재 패널을  lastAnchors,lastPanel지정하기
		lastAnchors = currentAnchor;
		lastPanel = currentPanel;
	})
})