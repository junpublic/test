/**
 * 
 */
$(function() {
	$('.accordion').each(function() {//each는 각각 무언가를 실행할때
		var allDt = $(this).find('dt');
		var allDd = $(this).find('dd');
		
		allDd.hide();
		allDt.css('cursor','pointer');
		allDt.click(function() {
//			allDd.hide();
//			$(this).next().show();
			$(this).next().toggle();//next자식의 ㅣ요소를 토글시킴
		})
		
	})
});