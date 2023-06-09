<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
     
     <!--
    <link rel="stylesheet" href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.min.css">
    <script src="<%=request.getContextPath() %>/bootstrap/js/jquery.slim.min.js"></script>
    <script src="<%=request.getContextPath() %>/bootstrap/js/popper.min.js"></script>
    <script src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.bundle.min.js"></script>
    -->
    <script src="https://kit.fontawesome.com/dedb6fdace.js" crossorigin="anonymous"></script>
    <title>TemplateApplyingModule.jsp</title>
    <style>
        /*점보트론 세로폭 및 마진바툼 줄이기*/
        .jumbotron{
            padding-top:1rem;
            padding-bottom:1rem;            
            margin-bottom: .5rem;
            
            border-top-left-radius:0;
            border-top-right-radius:0;
        }
        .nav-link:hover{
          color: rgba(174, 174, 174, 0.971) !important;/*navbar-dark 때문에 안먹음*/
        }
        button > span:hover{
          border:  rgba(174, 174, 174, 0.971) 2px solid ;
          border-radius: 10%;
        }
    </style>
</head>
<body>
	<!-- 네비게이션 바 -->
	<!-- 상단 고정 -->
	<nav class="navbar navbar-expand-md bg-secondary navbar-dark text-nowrap py-1 fixed-top">
  
      <!--Brand / Logo 표시-->
      <a class="navbar-brand" href="<c:url value="/" />"><i class="fa-brands fa-font-awesome" style="font-size: 28px;"></i></a>
      <!-- Navbar Text -->
      <span class="navbar-text mr-2">
        여러분들을 위한 플랫폼
      </span>

      <!-- Toggler/collapsibe Button -->
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
      </button>
        <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
          <!-- Links -->
          <ul class="navbar-nav">
            <li class="nav-item" id="test">
              <a class="nav-link text-white active" id="test" href="#/06_session/LoginBasedToken.jsp"><i class="fa-regular fa-face-meh"></i></a><!-- 로그인(토큰) -->
            </li>
            
            <li class="nav-item" id="test">
              <a class="nav-link text-white active" id="test" href="#/06_session/LogoutBasedToken.jsp"><i class="fa-regular fa-face-smile"></i></a><!-- 로그아웃(토큰) -->
            </li>
            
            <li class="nav-item">
              <a class="nav-link text-white" href="#/06_session/MyPageBasedToken.jsp"><i class="fa-solid fa-paper-plane"></i></a><!-- 마이페이지 -->
            </li>
            <li class="nav-item">
              <a class="nav-link text-white" href="#/08_bbs/List.jsp"><i class="fa-regular fa-paper-plane"></i></a><!-- 게시판 -->
            </li>
            
          </ul>
        </div>
    </nav>