// 함수의 인자로 들어오는 함수처리
function arrayProcess( data, f ) {//f로 함수이름이 넘어옴
	for( key=0; key < data.length; key++ ){
	//for(var key in data ){
		f( key, data[key].value );//f에 함수명을 넣어주면 밑에 미리 지정해놓은 함수가 불려져옴 개쩌는 기능인듯 
	}
}

// 각각의 데이터를 더하는 함수
var sumResult = 0;
function sum( key, data ){	//현재 key는 없어도됨
	sumResult += parseInt(data);
}

// 각각의 데이터의 곱을 구하는 함수
var squareResult = new Array();
function square( key, data ){			
	squareResult.push( data * data );
}
