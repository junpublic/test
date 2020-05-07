/**
 * 
 */

$(function(){//window.onload랑 비슷한 기능을 함
			
			/*$('.menu:first-child').mouseenter(function() {
				$('.menu:first-child').attr('src','imgs/menu01_on.png');	
	 			});
			$('.menu:nth-child(1)').mouseenter(function() {
				$('.menu:nth-child(1)').attr('src','imgs/menu02_on.png');	
	 			});
			$('.menu:last-child').mouseenter(function() {
				$('.menu:last-child').attr('src','imgs/menu03_on.png');	
	 			});*/
			
			$('.rollover img').hover(function() {
				var src = $(this).attr('src');
				var new_src = src.replace('_off','_on');
				$(this).attr('src',new_src);
				
//				$(this).attr('src',$(this).attr('src').replace('_off','_on'));	
			},function() {
				var src = $(this).attr('src');
				var new_src = src.replace('_on','_off');
				$(this).attr('src',new_src);
			});
		});