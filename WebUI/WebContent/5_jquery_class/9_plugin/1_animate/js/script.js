$(function() {
	$('#bio>div').hide();
	
	$('#bio > h3').click(function() {
		$(this).next().animate({'height':'toggle'},1000);
	});
});