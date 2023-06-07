<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/Top.jsp"/>
    <div class="container" style="margin-top: 49px">
        <div class="jumbotron">
            <h1>Spring Framework <small>Controller Method</small></h1>           
        </div><!--jumbotron-->
        <fieldset class="form-group border p-3">
        	<legend class="w-auto px-3">컨트롤러 메소드의 반환타입</legend>
        	<h3>반환 타입들</h3>
	    	<ul class="list-unstyled">
	    		<!-- Model : 데이타의 정보나 로직을 가지고 있는 객체 -->
	    		<li><a href="<c:url value="/ReturnType/ModelAndView.do?returnType=ModelAndView!!!"/>">ModelAndView 반환</a></li>
	    		<li><a href="<c:url value="/ReturnType/String.do?returnType=String!!!"/>">String반환(뷰정보 반환)</a></li>
	    		<li><button id="ajax" class="btn btn-info">void 타입반환(@Controller어노테이션 사용시에 클라이언트로 페이지가 아닌 데이타(JSON형식으로 문자열 생성)만 보낼때)</button></li>
	    		<!-- @Controller : HTML 페이지 이동할 때(반환타입 String) -->
	    		<!-- @RestController : 데이터를 이동시킬 때(반환타입 Void)
	    				반환타입은 String @ResponseBody(응답바디)로 데이터 이동 가능 -->
	    		<!-- jackson 라이브러리 : 컨버터가 java의 json으로 변환해준다(map) -->
	    		<li><a  href="<c:url value="/ReturnType/Object.do?returnType=Object!!!"/>">객체 타입(자바빈(좁은 의미) 혹은 컬렉션)반환(@ResponseBody어노테이션-페이지가 아닌 데이타(JSON-컨버터가 자동로 생성해줌)만 보낼때)-브라우저로 바로 출력 시</a></li>
	    		<li><a  href="javascript:printConsole()">객체 타입(자바빈(좁은 의미) 혹은 컬렉션)반환(@ResponseBody어노테이션-페이지가 아닌 데이타(JSON-컨버터가 자동로 생성해줌)만 보낼때)-콘솔로 바로 출력 시</a></li>
	    	</ul>
	    	<h3>결과 값 출력</h3>
	    	<ul class="list-unstyled">
	    		<li>\${requestScope.message }  : ${requestScope.message }</li>
	    		<li>\${requestScope.returnType }  : ${requestScope.returnType }</li>
	    		<li>\${param.returnType }  : ${param.returnType }</li>
	    	</ul>
        </fieldset>
    </div><!--container-->
<jsp:include page="/WEB-INF/views/template/Footer.jsp"/>
<script>
/*
	$('#ajax').click(function(){
		console.log('버튼 클릭!!');
		$.ajax({
			url:"<c:url value="/ReturnType/Void.do?returnType=Void!!!"/>",
			dataType:"json"
		}).done((data)=>{
			console.log('서버로부터 받은 데이타:',data);
			console.log('아이디:%s,비밀번호:%s,파라미터:%s',data.username,data['password'],data.parameter);
		}).fail((error)=>{
			console.log(error);
		});
	});
*/

	var button = document.querySelector('#ajax');
	button.onclick=function(e){
		//XMLHttpRequest 객체 생성
		var xhr = new XMLHttpRequest();
		
		// 요청 메서드 및 URL 설정
		//xhr.open("post", "<c:url value="/ReturnType/Void.do"/>", true); //true : 비동기방식(asynk??)
		xhr.open("get", "<c:url value="/ReturnType/Void.do?returnType=Void!"/>", true);
		
		// 요청 헤더 설정(get 방식일 때 필요 없음, post 방식일 때 반드시 Content-Type 설정)
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		
		// 요청 파라미터 생성
		var params = "returnType=Void!";
		
		// 요청 완료 후 처리할 콜백 함수 설정
		xhr.onreadystatechange = function() {
		  if (xhr.readyState === XMLHttpRequest.DONE) { //.DONE : 요청이 정상적으로 완료된 상태
		    if (xhr.status === 200) {
		    	
		      // 요청이 성공적으로 완료되었을 때 처리할 로직
		      console.log('서버로부터 받은 데이타',xhr.responseText);
		      console.log('서버로부터 받은 데이타의 타입',typeof xhr.responseText); //string
		      
		      var data = JSON.parse(xhr.responseText);
		      console.log('아이디:%s,비밀번호:%s,파라미터:%s',data.username,data['password'],data.parameter);
		      
		    } else {
		      // 요청이 실패했을 때 처리할 로직
		      console.error(xhr.status);
		    }
		  }
		};
		// 요청 전송(post 방식)
		//xhr.send(params); //파라미터를 "POST" 방식으로 전송 시. GET 방식일 때는 주석처리
		xhr.send(); //GET 방식 요청일 때.
	};
	
	function printConsole(){

		$.ajax({
			url:"<c:url value="/ReturnType/Object.do?returnType=Object!!!"/>",
			dataType:"json",
			method:'get'
		}).done((data)=>{
			console.log('서버로부터 받은 데이타:',data);
			console.log('아이디:%s,비밀번호:%s,파라미터:%s',data.username,data['password'],data.parameter);
		}).fail((error)=>{
			console.log(error);
		});
	}
</script>
    