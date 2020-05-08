/**
 * 
 */

$(function() {
	$('a[rel="prettyPopin"]:eq(0)').prettyPopin({
		width:400
	});
	$('a[rel="prettyPopin"]:eq(1)').prettyPopin({
		width:400,
		callback:function(){
			alert('팝업을 닫음');
		}
	});
})