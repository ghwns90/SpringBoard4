<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" type="image/ico" href="/img/favicon.ico" />
<link rel="stylesheet"  href="/css/common.css" />

<style>
	
	td {
	   padding : 10px;
	   width : 700px;
	   text-align: center; 	   
	}
	
	td:nth-of-type(1) {
	   width: 200px;
	} 
	
	input { width : 100%; }
	input[type=submit] { width:100px; }
	

</style>

</head>
<body>
  <main>
    
    <!-- 메뉴 리스트 -->
    <%@include file="/WEB-INF/include/menus.jsp" %>
  
	<h2>${ menuDTO.menu_name }  새 게시글 추가</h2>
	<form action="/Board/Write" method="POST">
	  <input type="hidden" name="menu_id" value="${ menuDTO.menu_id }" />
	  <table>
	    <tr>
	      <td>제목</td>
	      <td><input type="text" name="title"  /></td>
	    </tr>
	    <tr>
	      <td>작성자 이름</td>
	      <td><input type="text" name="writer" /></td>
	    </tr>
	    <tr>
	      <td>내용</td>
	      <td><textarea name="content"></textarea></td>
	    </tr>	 
	    <tr>	      
	      <td colspan="2">
	      <input type="submit" value="등록" />
	      </td>
	    </tr>
	  </table>
	</form>
  </main>	
    
  <script>

    const  formEl = document.querySelectorAll("form")[0];
    
    formEl.addEventListener('submit', function(e) {
    	// alert('ok')
    	// 아이디 
    	const  inputEl1 = document.querySelector('[name="userid"]')
    	if( inputEl1.value.trim().length < 6 
    		 || inputEl1.value.trim().length > 12 ) {
    		alert('아이디는 6~12 자 사이입니다')
    		e.stopPropagation();  // 이벤트 버블일 방지
    		e.preventDefault();   // 이벤트를 취소 
    		inputEl1.focus();
    		return false
    	} 
    	
    	// 암호
    	const  inputEl2 = document.querySelector('#pwd1')
    	if( inputEl2.value.trim() == '' ) {
    		alert('암호가 입력되지 않았습니다')
    		e.stopPropagation();
    		e.preventDefault();
    		inputEl2.focus();
    		return false
    	}
    	
    	// 암호확인
    	const  inputEl3 = document.querySelector('#pwd2')
    	if( inputEl3.value.trim() == '' ) {
    		alert('암호확인이 입력되지 않았습니다')
    		e.stopPropagation();
    		e.preventDefault();
    		inputEl3.focus();
    		return false
    	}
    	
    	// 암호 == 암호확인
    	if( inputEl2.value != inputEl3.value ) {
    		alert('암호가 일치하지 않습니다')
    		e.stopPropagation();
    		e.preventDefault();
    		inputEl3.focus();
    		return false
    	}
		
    	// 이름
    	const  inputEl4 = document.querySelector('[name="username"]')
    	if( inputEl4.value.trim() == '' ) {
    		alert('이름이 입력되지 않았습니다')
    		e.stopPropagation();
    		e.preventDefault();
    		inputEl4.focus();
    		return false
    	} 
    	
    	// 이메일
    	const  inputEl5 = document.querySelector('[name="email"]')
    	if( inputEl5.value.trim() == '' ) {
    		alert('이름이 입력되지 않았습니다')
    		e.stopPropagation();
    		e.preventDefault();
    		inputEl5.focus();
    		return false
    	} 
    })
    

  </script>
  
  
  
</body>
</html>



