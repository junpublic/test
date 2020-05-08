/**
 * 
 */

$(document).ready(function() {
	$('#navigation li').hover(
	function() {
		$(this).animate({paddingLeft:'+=15px'},200);
	},function() {
		$(this).animate({paddingLeft:'-=15px'},200);
	}		
	);
	
	$(window).scroll(function(){//위치를 고정시킴
		$('#navigation').css({'top':$(document).scrollTop()});//하나일떄는 속성에 , 여러개일떄는 {:}괄호에 콜롬까지 해줘야함
	});
})