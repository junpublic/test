//
//public class 문제_0325 {
//	1. 다음 프로그램의 결과는?
//
//			 
//
//			public class Test {
//
//			public static void main ( String  [] args ) {
//
//			  String s;
//
//			  System.out.println(“s=” + s );
//
//			}
//
//			}
//
//			 
//
//			           (1) String s에 초기값을 지정하지 않아 컴파일 에러가 발생한다. //답
//
//			           (2) 결과는 “s=”만 출력된다.
//
//			           (3) 결과는 “s=null”이라고 출력된다.
//
//			           (4) 컴파일은 성공하지만, 실행할 때NullPointerException이 발생한다.
//
//			 
//
//			 
//
//			 
//
//			2 다음 소스중에서 출력 결과로“i=0”이라고 출력되는 것은?
//
//			           (1) class Test {
//
//			                       int  i;//static이 없어서 안됨
//
//			                       public  static void main( String [] args ) {
//
//			                                  System.out.println(“i=”+i);
//
//			                       }
//
//			              }
//
//			           (2) class Test {  //답
//
//			                       static  int  i;
//
//			                       public  static void main( String [] args ) {
//
//			                                  System.out.println(“i=”+i);
//
//			                       }
//
//			              }
//
//			           (3) class Test {
//
//			                       int  i;
//
//			                       public  static void main( String [] args ) {
//
//			                                  System.out.println(“i=”+Test.i);//이상함
//
//			                       }
//
//			              }
//
//			           (4) class Var {
//
//			                       private  int  i;//private떄문에 안됨
//
//			              }
//
//			class Test {
//
//			                       int  i;
//
//			                       public  static void main( String [] args ) {
//
//			                                  Var  v = new Var();
//
//			                                  System.out.println(“i=”+v.i);
//
//			                       }
//
//			              }
//
//			 
//
//			 
//
//			 
//
//			3. 다음 소스에서 method()메소드의 오버로딩으로 선언한 메소드는?
//
//			class Test {
//
//			    private int x, y;
//
//			    private double z;
//
//			    public void method ( int a, int b, double c ) {
//
//			        x = a;
//
//			        y = b;
//
//			        z = c;
//
//			    }
//
//			}
//
//			 
//
//			           (1) void  method( int a, int b, double c ) {//변수형식이 같아서 앋됨
//								x = a;
//
//			                   y = b;
//
//			                   z = c;               
//
//			              }
//
//			           (2) public  void method ( int a, double b, int c ) {
//
//			                       method( a, c,b );
//
//			              }
//
//			           (3) public  void method ( int a, double b, int c ) {
//
//			                       this( a, c, b);
//
//			              }
//
//			           (4) void  method( int a, int b) {
//
//								x = a;
//
//			                   y = b;
//
//			              }
//
//			           (5) void  method( int i, int j, double k ) {
//
//								x = i;
//
//			                   y = j;
//
//			                   z = k;               
//
//			              }
//
//			 
//
//			4. 다음 소스에서 잘못 된 부분을 찾아 수정하시오.
//
//			class MyClass{
//
//			     int  var ;
//
//			}
//
//			public class Test {
//
//			   public static void main ( String [] args ) {
//
//			         MyClass  my = new MyClass;
//
//			         my.var = 1000;
//
//			         System.out.println( my. var );
//
//			   }
//
//			}
//
//			 
//
//			5. 다음 소스에서 잘못 된 부분을 찾아 수정하시오.
//
//			class MyClass{
//
//			     public int  method ( int i , int j ) {
//
//			          return i + j;
//
//			     }
//
//			     public double method  ( int i, int j ) {//클라스 이름을 바꾸거나 변수형을 바꿔라
//
//			          return ( i + j ) / 3. 0;
//
//			     }
//
//			}
//
//			 
//
//			6. 다음 소스에서 잘못 된 부분을 찾아 수정하시오.
//
//			class MyClass{
//
//			   String name;
//
//			   public MyClass() {
//
//			       System.out.println(“생성자 실행”);
//
//			       this(“이름없음”);//디스가 위로
//
//			   }
//
//			   public MyClass( String name ) {
//
//			      this.name = name;
//
//			   } 
//
//			public static void main ( String [] args ) {
//
//			      MyClass  my = new MyClass();
//
//			 }
//
//			}
//}
