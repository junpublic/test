$(function() {
	
	$('.menuCount').click(function() {
		var thisCF = $(this);		
		var li = thisCF.parent().children('span').eq(0).attr('value');	
		var li1 = thisCF.val();
		$('#listTable').append('<tr><td>'+li+'</td><td>'+li1+'<td><button id="'+li+'" class="delete" value="">삭제</button></td></tr>');
	
	});
	$(document).on("click",".delete",function(){//동적으로 할당된 클래스는 on으로 찾아줘야만 한다.
		$(this).closest('tr').remove();
	});
	
	
});


	