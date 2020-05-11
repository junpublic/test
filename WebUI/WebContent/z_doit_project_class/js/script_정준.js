$(function() {
	//날짜를 세팅해준다.
	var date = new Date();
	$('.year').text(date.getFullYear());//년 세팅
	$('.month').text(date.getMonth()+1); //달 세팅
	$('.date').text(date.getDate());//일 세팅
	
	//검색창에 마우스를 올리면 이미지가 사라지고  마우스를 내리면 다시 이미지가 나온다.
	$('#keyword').focus(function() {
		$('#keyword').hover(
				function() {
					$(this).css("background-position","0 -500px");
				},function() {
					$(this).css("background-position","0 0");
				});
	});
	// 탭 변경 설정
	   $('.tab_btn1').click(function() {
	      // "공지사항"탭 누를시 나머지 탭 이미지 변경
	      $('.tab_btn1 img').attr('src','images/tab_btn_1_out.gif');
	      $('.tab_btn2 img').attr('src','images/tab_btn_2_out.gif');
	      $('.tab_btn3 img').attr('src','images/tab_btn_3_out.gif');
	      // "공지사항"탭 누를시 클릭 이미지 변경   
	      $('.tab_btn1 img').attr('src','images/tab_btn_1_over.gif');
	      // 나머지 탭 내용 안보이기
	      $('#tabmenu dd').hide('dd');
	      // 해당 탭 내용 보이기
	      $('#tabmenu dd').eq(0).show('dd');
	   })
	   $('.tab_btn2').click(function() {
	      // "질문과답변"탭 누를시 나머지 탭 이미지 변경
	      $('.tab_btn1 img').attr('src','images/tab_btn_1_out.gif');
	      $('.tab_btn2 img').attr('src','images/tab_btn_2_out.gif');
	      $('.tab_btn3 img').attr('src','images/tab_btn_3_out.gif');
	      // "질문과답변"탭 누를시 클릭 이미지 변경
	      $('.tab_btn2 img').attr('src','images/tab_btn_2_over.gif');
	      // 나머지 탭 내용 안보이기
	      $('#tabmenu dd').hide('dd');
	      // 해당 탭 내용 보이기
	      $('#tabmenu dd').eq(1).show('dd');
	   })
	   $('.tab_btn3').click(function() {
	      // "저자문의"탭 누를시 나머지 탭 이미지 변경
	      $('.tab_btn1 img').attr('src','images/tab_btn_1_out.gif');
	      $('.tab_btn2 img').attr('src','images/tab_btn_2_out.gif');
	      $('.tab_btn3 img').attr('src','images/tab_btn_3_out.gif');
	      // "저자문의"탭 누를시 클릭 이미지 변경
	      $('.tab_btn3 img').attr('src','images/tab_btn_3_over.gif');
	      // 나머지 탭 내용 안보이기
	      $('#tabmenu dd').hide('dd');
	      // 해당 탭 내용 보이기
	      $('#tabmenu dd').eq(2).show('dd');
	   })
	
	 
	 
		/*var topDiv=$('#tabmenu');
		var anchors = topDiv.find('dt');//탭들
		var panelDivs = topDiv.find('dd');//내용들
		
		anchors.show();//텝들 보이게함
//		panelDivs.hide();//내용들 숨김
		
		var lastAnchors = anchors.children().filter('.on');//탭들중에 on클래스가있는 것을 찾음 // find와  filter의 차이점
		var lastPanel = $(lastAnchors.attr('class'));
		lastPanel.show();
		
		anchors.click(function() {
			
			//눌려진 요소에 클래스명 on 지정
			//1 현재 이벤트가 발새한 a태그와 그 href(패널)을 얻어와서 변수에 지정
			var currentAnchor = $(this);//현재테그
			var currentPanel = $(currentAnchor.attr('class'));//아이디와 똑같은 기능을 함 href안의 값을 가져와서 그것을 찾으니까 아이디랑 같은기능임
			//2 기존 a태그(lastAnchors)에서 on 클라스 제거
			lastAnchors.removeClass('on');
			//3 현재 a태그에 on클래스를 추가
			$(this).children().addClass('on');
			//4기존패널(lastPanel) 감추기
			lastPanel.hide();		
			//5 현재패널	보이기
			currentPanel.show();			
			//6 현재 a태그와 현재 패널을  lastAnchors,lastPanel지정하기
			lastAnchors = currentAnchor;
			lastPanel = currentPanel;
		})*/

		

		$(document).ready(function(){
		      $('#best_bg ul').bxSlider({
		    	  minSlides :5,
		    	  maxSlides:5,
		    	  slideMargin:125,
		    	  slideWidth: 90,
		    	  auto:true,
		    	  touchEnabled:true,
		    	  background: "none",
		    	  speed:200	  
		      });
		    });

		$('.login_wrap a img').click(function() {
			$('#login_f').css({top:0});
		})
		
		$('.login_close_btn a img').click(function() {
			$('#login_f').css({top:-500});
		})
		
		$('#total_btn a img').click(function() {
			$('#total_menu').css({display:'block'});
		})
	
		$('#total_close a img').click(function() {
			$('#total_menu').css({display:'none'});
		})
	

	
});