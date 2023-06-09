<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
1. HTML태그에 URL패턴을 생성(A태그의 href속성 혹은 form의 action 속성)
2. 컨트롤러 생성

[application.properties 추가]
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
 -->
<jsp:include page="/WEB-INF/views/template/Top.jsp"/>
    <div class="container" style="margin-top: 49px">
        <div class="jumbotron">
            <h1>Hello Spring!!! <small>${requestScope.today }</small></h1>            
        </div><!--jumbotron-->
        <fieldset class="form-group border p-3">
        	<legend class="w-auto px-3">스프링 프레임워크</legend>
        	<h2>1. static resource(정적자원) 표시방법 <small>이미지, 동영상, .css, .js 파일 등</small></h2>
        	<h4><kbd>디폴트 설정 사용시(설정 불 필요)</kbd></h4>
        	<img class="img-thumbnail" alt="디폴트" src="<c:url value="/images/thumbnail.jpg" />" />
        	<img class="img-thumbnail" alt="static" src="<c:url value="/static/images/thumbnail.jpg" />" />
        	<img class="img-thumbnail" alt="springapp/static" src="<c:url value="springapp/static/images/thumbnail.jpg" />" />
        	<img class="img-thumbnail" alt="virtual" src="<c:url value="/virtual/images/thumbnail.jpg" />" />
        	
        	<h4><kbd>디폴트 설정 미 사용시(설정 필요)</kbd></h4>
        	<img class="img-thumbnail" alt="디폴트" src="<c:url value="/resources/images/thumbnail.jpg" />" />
        	
        	<h4><kbd>WebMvcConfigurer로 리소스 핸들러 추가(설정 불 필요, 클래스 필요)</kbd></h4>
        	<img class="img-thumbnail" alt="virtual" src="<c:url value="/virtual/images/thumbnail.jpg" />" />
        	
        	<h2>2. Controller <small><a href="<c:url value="/controller.do"/> ">컨트롤러</a></small></h2>
        	
        	<h2>3. Controller Method <small><a href="<c:url value="/returntype.do"/> ">컨트롤러 메소드의 반환타입</a></small></h2>
        	
        	<h2>4. Dependency Injection <small><a href="<c:url value="/injection.do"/> ">의존성 주입</a></small></h2>
        	
        	<h2>5. Annotation <small><a href="<c:url value="/annotation.do"/> ">어노테이션</a></small></h2>
        	
        	<h2>6. Properties <small><a href="<c:url value="/properties.do"/> ">속성 파일(.properties 파일)</a></small></h2>
        	
        	<h2>7. Database <small><a href="<c:url value="/database.do"/> ">데이타베이스</a></small></h2>
        	
        	<h2>8. Validation <small><a href="<c:url value="/validation.do"/> ">유효성 검증</a></small></h2>
        </fieldset>
        
    </div><!--container-->
<jsp:include page="/WEB-INF/views/template/Footer.jsp"/>
    