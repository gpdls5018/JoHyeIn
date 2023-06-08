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
// AJAX는 웹 페이지에서 비동기적으로 데이터를 주고받을 수 있는 기술로, 
//페이지 전체를 다시 로드하지 않고도 서버와 데이터를 주고받을 수 있게 합니다.
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
		//true : 비동기방식(asynk)
		//순서대로 처리하지 않고 동시에 처리한다
		//xhr.open("post", "<c:url value="/ReturnType/Void.do"/>", true); //post방식은 쿼리스트링으로 넘기지 않는다
		xhr.open("get", "<c:url value="/ReturnType/Void.do?returnType=Void!"/>", true);
		
		/*
		요청 헤더 설정(get 방식일 때 필요 없음, post 방식일 때 반드시 Content-Type 설정)
		HTTP 프로토콜은 요청과 응답 메시지를 교환할 때, 메시지의 헤더와 바디로 구성되는데 
		헤더에는 메시지에 대한 정보와 메타데이터가 포함되고, 바디에는 실제 데이터가 포함된다
		POST 방식은 데이터를 요청의 바디에 담아 서버로 전송하기때문에 
		POST 요청을 보낼 때는 바디에 어떤 형식의 데이터가 있는지 서버에 알려줘야하므로 아래 코드를 반드시 작성해야한다
		데이터를 키-값 쌍으로 인코딩하고, 각각의 쌍은 "&"로 구분되며, 키와 값은 "="로 구분한다는 의미이다.
		*/
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		
		// 요청 파라미터 생성
		var params = "returnType=Void!";
		
		// 요청 완료 후 처리할 콜백 함수 설정
		xhr.onreadystatechange = function() { //상태 변화를 감지하고, 요청이 완료됐을 때 적절한 처리를 수행
		  if (xhr.readyState === XMLHttpRequest.DONE) { //.DONE : 요청이 정상적으로 완료된 상태
		    if (xhr.status === 200) {//HTTP 응답 상태 코드(status) 200은 요청이 성공적으로 처리되었음
		    	
		      // 요청이 성공적으로 완료되었을 때 처리할 로직
		      console.log('서버로부터 받은 데이타',xhr.responseText);//responseText:서버로부터 받은 응답 데이터
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
		xhr.send(); //GET 방식 요청일 때.(쿼리스트링으로 넘기므로 params 필요없음)
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
    