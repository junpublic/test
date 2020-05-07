$(function() {
	
	$('.menuCount').click(function(evt) {
		var thisCF = $(evt.target);
		
		var li = $('#label1').text();
		
		alert(li);
		var li1 = $('#menu1Count').val();
		$('#listTable').append('<tr><td>'+li+'</td><td>'+li1+'<td><button id="btn1" class="delete" value="delete">삭제</button></td></tr>');
		
	});
})


	