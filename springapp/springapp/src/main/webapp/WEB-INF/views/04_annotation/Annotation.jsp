<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/Top.jsp"/>
    <div class="container" style="margin-top: 49px">
        <div class="jumbotron">
            <h1>Spring Framework <small>Annotation</small></h1>           
        </div><!--jumbotron-->
        <fieldset class="form-group border p-3">
        	<legend class="w-auto px-3">어노테이션</legend>
        	<h1 class="display-4">@RequestMapping/@PathVariable</h1>
        	<h5>@RequestMapping("/요청URL") : 모든 HTTP메소드 요청 처리 가능</h5>
        	<form class="form-inline" action="<c:url value="/Annotation/RequestMappingBoth.do"/>" method="get">
				<label>아이디</label> 
				<input type="text" name="id" class="form-control mx-2" /> 
				<label>비밀번호</label> <input type="password" name="pwd" class="form-control mx-2" /> 
				<input type="submit" class="btn btn-danger mx-2" value="로그인" />
			</form>
			
			<h5>@RequestMapping(value="/요청URL",method=RequestMethod.GET) :
			HTTP메소드중 하나만 처리 가능</h5>
			<form class="form-inline" action="<c:url value="/Annotation/RequestMappingOne.do"/>" method="get">
				<label>아이디</label> 
				<input type="text" name="id" class="form-control mx-2" /> 
				<label>비밀번호</label> <input type="password" name="pwd" class="form-control mx-2" /> 
				<input type="submit" class="btn btn-danger mx-2" value="로그인" />
			</form>
			
			<c:if test="${! empty loginInfo }">
				<kbd>${loginInfo }</kbd>
			</c:if>
			
			<h1 class="display-4">@RequestParam</h1>
			<!--
			  	예]
				//컨트롤러 메소드]
			  	public String 메소드(@RequestParam 자료형 매개변수){
			  	}
			    단, 파라미터명과  매개변수명이 일치하지 않은 경우
			 	@RequestParam("파라미터명") 자료형 매개변수명
				- 해당 파라미터의 자료형으로 받을 수 있다 즉 형변환 불필요
				- 여러개일 때는 자료형을 Map으로
			-->
			<span class="text-danger">${error}</span>
			
			<h5>파라미터명과 매개변수명 일치시</h5>
			<form class="form-inline" action="<c:url value="/Annotation/RequestParamEqual.do"/>" method="POST">
				<label>이름</label> 
				<input type="text" name="name" class="form-control mx-2" /> 
				<label>나이</label> <input type="text" name="age" class="form-control mx-2" /> 
				<input type="submit" class="btn btn-danger mx-2" value="확인" />
			</form>
			
			<h5>파라미터명과 매개변수명 불 일치시</h5>
			<form class="form-inline" action="<c:url value="/Annotation/RequestParamDiff.do"/>" method="POST">
				<label>이름</label> 
				<input type="text" name="nickname" class="form-control mx-2" /> 
				<label>나이</label> <input type="text" name="years" class="form-control mx-2" /> 
				<input type="submit" class="btn btn-danger mx-2" value="확인" />
			</form>
			
			<kbd>이름 : ${name},10년후 나이 : ${age }</kbd>
			
			<h5>맵으로 모든 파라미터 받기</h5>
			<form action="<c:url value="/Annotation/RequestParamMap.do"/>" method="post">
				<div class="form-group">
					<label><kbd class="lead">아이디</kbd></label> 
					<input type="text" value="${param.id}" class="form-control" name="id" placeholder="아이디를 입력하세요">
				</div>
				<div class="form-group">
					<label><kbd class="lead">성별</kbd></label>
					<div class="d-flex">
						<div class="custom-control custom-radio mr-2">
							<input type="radio" class="custom-control-input" name="gender" value="man" id="male" <c:if test="${ gender=='man' }">checked</c:if> /> 
							<label for="male" class="custom-control-label">남자</label>
						</div>
						<div class="custom-control custom-radio">
							<input type="radio" class="custom-control-input" name="gender" value="woman" id="female" <c:if test="${gender=='woman' }">checked</c:if> /> 
							<label for="female" class="custom-control-label">여자</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label><kbd class="lead">관심사항</kbd></label>
					<div class="d-flex">
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input" name="inter" value="POL" id="POL"> 
							<label class="custom-control-label"	for="POL">정치</label>
						</div>
						<div class="custom-control custom-checkbox mx-2">
							<input type="checkbox" class="custom-control-input" name="inter" value="ECO" id="ECO"> 
							<label class="custom-control-label"	for="ECO">경제</label>
						</div>
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input" name="inter" value="ENT" id="ENT"> 
							<label class="custom-control-label"	for="ENT">연예</label>
						</div>
						<div class="custom-control custom-checkbox ml-2">
							<input type="checkbox" class="custom-control-input" name="inter" value="SPO" id="SPO"> 
							<label class="custom-control-label" for="SPO">스포츠</label>
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">확인</button>
			</form>
			
			<kbd>아이디:${id},성별:${gender},관심사항:${inter}</kbd>
			
			<h1 class="display-4">@ModelAttribute</h1>
			<form action="<c:url value="/Annotation/ModelAttribute.do"/>" method="post">
				<div class="form-group">
					<label><kbd class="lead">이름</kbd></label> 
					<input type="text" class="form-control" name="name" placeholder="이름를 입력하세요">
				</div>
				<div class="form-group">
					<label><kbd class="lead">아이디</kbd></label> 
					<input type="text" class="form-control" name="id" placeholder="아이디를 입력하세요">
				</div>
				<div class="form-group">
					<label><kbd class="lead">비밀번호</kbd></label> 
					<input type="password" class="form-control" name="pwd" placeholder="비밀번호를 입력하세요">
				</div>
				<div class="form-group">
					<label><kbd class="lead">성별</kbd></label>
					<div class="d-flex">
						<div class="custom-control custom-radio mr-2">
							<input type="radio" class="custom-control-input" name="gender" value="man" id="male1"> 
							<label for="male1" class="custom-control-label">남자</label>
						</div>
						<div class="custom-control custom-radio">
							<input type="radio" class="custom-control-input" name="gender" value="woman" id="female1"> 
							<label for="female1" class="custom-control-label">여자</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label><kbd class="lead">관심사항</kbd></label>
					<div class="d-flex">
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input" name="inter" value="POL" id="POL1"> 
							<label class="custom-control-label" for="POL1">정치</label>
						</div>
						<div class="custom-control custom-checkbox mx-2">
							<input type="checkbox" class="custom-control-input" name="inter" value="ECO" id="ECO1"> 
							<label class="custom-control-label" for="ECO1">경제</label>
						</div>
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input" name="inter" value="ENT" id="ENT1"> 
							<label class="custom-control-label" for="ENT1">연예</label>
						</div>
						<div class="custom-control custom-checkbox ml-2">
							<input type="checkbox" class="custom-control-input" name="inter" value="SPO" id="SPO1"> 
							<label class="custom-control-label" for="SPO1">스포츠</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label><kbd class="lead">학력사항</kbd></label> 
					<select name="grade" class="custom-select mt-3 custom-select-lg">
						<option value="">학력을 선택하세요</option>
						<option value="ELE">초등학교</option>
						<option value="MID">중학교</option>
						<option value="HIG">고등학교</option>
						<option value="UNI">대학교</option>
					</select>
				</div>
				<div class="form-group">
					<label><kbd class="lead">첨부파일</kbd></label>
					<div class="custom-file">
						<input type="file" class="custom-file-input" name="file" id="file1" />
						<label class="custom-file-label" for="file1">파일을 첨부하세요</label>
					</div>
				</div>
				<div class="form-group">
					<label><kbd class="lead">자기소개</kbd></label>
					<textarea class="form-control" rows="5" name="self"></textarea>
				</div>
				<button type="submit" class="btn btn-primary">확인</button>
			</form>
			
			<h1 class="display-4">DI와 관련된 어노테이션</h1>
			<h5>@Autowired(의존성 주입을 위한 어노테이션)</h5>
			<a href="<c:url value="/Annotation/Autowired.do"/>">오토와이어링</a>
			
			<h5>@Lazy(지연로딩을 위한 어노테이션)</h5>
			<a href="<c:url value="/LazyLoading/Lazy.do"/>">지연로딩</a>
			
			<h5>@Configuration(컨테이너에 등록할 빈을 자바코드로 작성할 경우 사용하는 어노테이션)</h5>
			<a href="<c:url value="/Configuration/Configuration.do"/>">자바코드로 빈 등록</a>
			
			<div>
				<kbd>${message }</kbd>
			</div>
			
			<h1 class="display-4">기타 어노테이션</h1>
			<h5>@SessionAttribute(세션으로 인증을 위한 어노테이션)</h5>
			<!-- HttpSession 혹은 @SessionAttribute(맵으로 파라미터 받기)으로 인증처리 시 -->
			
			<c:if test="${empty sessionScope.id }" var="isNotLogin">
				<h6 class="font-weight-bolder">로그인 전</h6>
				<form class="form-inline" action="<c:url value="/Annotation/SessionAttributeLogin.do"/>" method="GET">
					<label>아이디</label> 
					<input type="text" name="id" class="form-control mx-2" /> 
					<label>비밀번호</label> 
					<input type="password" name="pwd" class="form-control mx-2" /> 
					<input type="submit" class="btn btn-danger mx-2" value="로그인" />
				</form>
				
				<kbd>에러메시지 : ${loginError}</kbd>
			</c:if>
			
			<c:if test="${! isNotLogin }">
				<h6 class="font-weight-bolder">로그인 후</h6>
				<!--@SessionAttribute 사용시 모델계열에 데이타 저장하면 두 영역에 동시에 저장됨  -->
				<kbd>세션영역 : ${sessionScope.id}${sessionScope.loginCommand.id}</kbd>
				<br />
				
				<kbd>리퀘스트 영역 : ${requestScope.id}${requestScope.loginCommand.id}</kbd>
				<br />
				
				<kbd>${sessionScope.id }${sessionScope.loginCommand.id} 님 즐감하세요</kbd>
				
				<a href="<c:url value="/Annotation/SessionAttributeLogout.do"/>">로그아웃</a>
			</c:if>
			<hr />
			
			<h6 class="font-weight-bolder">로그인 여부 판단</h6>
			<a href="<c:url value="/Annotation/SessionAttributeIsLogin.do"/>">로그인여부 판단</a><br />
			<kbd>서블릿 API(HttpSession 사용시) : ${isLoginMessageAPI}</kbd>
			<br />
			
			<kbd>@SessionAttribute 사용시 : ${isLoginMessage}</kbd>
        </fieldset>
    </div><!--container-->
<jsp:include page="/WEB-INF/views/template/Footer.jsp"/>
    