<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 디자이너가 html파일을 주면 jsp파일로 바꿈 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <style>
        label {
            display: inline-block;
            color : blue;
            font-weight : bold;
            width: 100px;
            height: 25px;
        }
        #tel {
            width: 130px;
           
        }
        #fil{
            border : 0;
        }
        #adr{
            width: 250px;
        }
       .btn{
            display: inline-block;
         
        }
       
    </style>
</head>

<body>

    <h1>회원가입서 작성하기</h1>
    <form method="get" action="result.jsp">

        <!--  1  -->
        <fieldset id="fil">
            <label for="id">아이디</label>
            <input type="text" name="id" id="id" autofocus="autofocus" placeholder="5자~10자 영어와 숫자조합"><button>중복확인</button> <br>

            <label for="pass">비밀번호</label>
            <input type="password" name="password" id="pass" placeholder="4자이상 영어와 숫자조합">
            <br>

            <label for="passcon">비밀번호확인</label>
            <input type="passcon" name="passcon" id="passcon">
            <br>

            <label for="name">이름</label>
            <input type="text" name="name" id="name" pattern="^[가-힣]{2,5}$" title="한글 2~5글자 이내" placeholder="한글 5자 이내"><br>



            <label for="tel">전화번호</label>

            <input type="tel" name="tel" id="tel" required="required" placeholder="-없이 숫자조합">

            <br>

            <label for="adr">주소</label>
            <input id="adr" name = "adr" type="text" placeholder="20자 이내">
        </fieldset>
        <input class="btn" type="submit" value="회원가입">
        <input class="btn" type="reset" value="취소">
    </form>
    </body>

    </html>