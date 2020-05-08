/**
 * 
 */

$(function() {
	
	$('#signup >form').validate({
		rules:{
			name:{required:true},//이름 필요함
			email:{required:true,//이메일이 필요하고 형식도 맞아야함
					email:true},
			website:{url:true},
			password:{required:true,
					minlength:6},//minlength:최소자리수
			
			passconf:{equalTo:'#password'}
		},
		success:function(label){//성공했을때
			label.addClass('valid');
			label.text('성공');//실행?안돼지만 없으면 안됨
			
		}
		
	});
	$(".check-all").click(function() {
//		$(".agree").prop("checked", true);//prop()=attr()
//		$(".agree").prop("checked", this.checked);//여기서 this.checked는 자바스크립트꺼임
		$(".agree").prop("checked", $(this).is(':checked'));//jquery로만 이루어짐 ///is() true인지 아닌지 감지하는 함수 개꿀
		
	});
	if($(".agree").is(":checked") == true) {
		submit
		}
	
});