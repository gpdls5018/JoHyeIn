<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/Top.jsp"/>
    <div class="container" style="margin-top: 49px">
        <div class="jumbotron">
            <h1>Spring Framework <small>Database</small></h1>           
        </div><!--jumbotron-->
        <fieldset class="form-group border p-3">
        	<legend class="w-auto px-3">데이타베이스 연결하기</legend>
        	<!-- 스프링 부트 : 커넥션 풀(디폴트) -->
        	<span class="text-info">${message}</span>
        	<span class="text-success">${param.method}</span>
	    	<ul class="list-unstyled">
	    		<li><a href="<c:url value="/Database/HikariConnectionPool.do?method=HIKARI_CONNECTION_POOL"/>">히카리 커넥션 풀 사용</a></li>
	    	</ul>
        </fieldset>
    </div><!--container-->
<jsp:include page="/WEB-INF/views/template/Footer.jsp"/>
    