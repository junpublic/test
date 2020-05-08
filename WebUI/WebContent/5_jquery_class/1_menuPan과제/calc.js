$(function() {
	
	$('.menuCount').click(function(evt) {
		var thisCF = $(evt.target).parent().va;
		alert(thisCF);
		
//		var li = thisCF.parent().children().eq(1).text();
		var li1 = thisCF.val();
		$('#listTable').append('<tr><td>'+li+'</td><td>'+li1+'<td><button id="btn1" class="delete" value="delete">삭제</button></td></tr>');
		
	});
})


	