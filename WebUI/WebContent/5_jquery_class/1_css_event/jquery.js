/**
 * 
 */

$(function() {
//	$('#celebs tbody tr:odd').css({'background':'lightpink'});
	
	$('#celebs tbody tr:odd').addClass('table_striping');
	
	
	$('#celebs tbody tr').hover(function() {
		$(this).addClass('td_mouseover');//css스타일시트에 있는 것을 끌어와서 씀 tr밑에 있는거라 tr.td_~안해도됨
	},function(){
		$(this).removeClass('td_mouseover');
	});
	
	$('#hideButton').click(function() {
		$('#intro img').slideUp(1000);
	});
	$('#showButton').click(function() {
		$('#intro img').slideDown(1000);
	});
	$('#toggleButton').click(function() {
		$('#intro img').fadeToggle(1000);
	});
});