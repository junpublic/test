package g_access;

import g_access.sub.Access;

// 2. 다른 패키지에서 확인
class Main
{
	public static void main(String[] args) 
	{
		Access me = new Access();
//		me.a = "프라이빗 변경";//private는 접근 불가
		me.b = "퍼블릭 변경";
//		me.c = "프로텍티드 변경";
//		me.d = "디폴트 변경";
		
		me.output();
	}
}

