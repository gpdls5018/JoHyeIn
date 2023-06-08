<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/template/Top.jsp"/>
    <div class="container" style="margin-top: 49px">
        <div class="jumbotron">
            <h1>Spring Framework <small>Annotation</small></h1>           
        </div><!--jumbotron-->
        <fieldset class="form-group border p-3">
        	<legend class="w-auto px-3">@ModelAttribute</legend>
        	<div class="form-group">
			<label><kbd class="lead">이름</kbd></label> 
			<input type="text" class="form-control" name="name" value="${name}${cmd.name}">
		</div>
		<div class="form-group">
			<label><kbd class="lead">아이디</kbd></label> 
			<input type="text" class="form-control" name="id" value="${id}${cmd.id}">
		</div>
		<div class="form-group">
			<label><kbd class="lead">비밀번호</kbd></label> 
			<input type="text" class="form-control" name="pwd" value="${pwd}${cmd.pwd}">
		</div>
		<div class="form-group">
			<label><kbd class="lead">성별</kbd></label>
			<div class="d-flex">
				<div class="custom-control custom-radio mr-2">
					<input type="radio" class="custom-control-input" name="gender" value="man" id="male" <c:if test="${gender=='man' or cmd.gender=='man' }">checked</c:if> />
					<label for="male" class="custom-control-label">남자</label>
				</div>
				<div class="custom-control custom-radio">
					<input type="radio" class="custom-control-input" name="gender" value="woman" id="female" <c:if test="${gender=='woman' or cmd.gender=='woman' }">checked</c:if> />
					<label for="female" class="custom-control-label">여자</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label><kbd class="lead">관심사항</kbd></label>
			<div class="d-flex">
				<div class="custom-control custom-checkbox">
					<input type="checkbox" class="custom-control-input" name="inter" value="POL" id="POL" <c:if test="${fn:contains(inter,'POL') or fn:contains(cmd.inter,'POL') }">checked</c:if> />
					<label class="custom-control-label" for="POL">정치</label>
				</div>
				<div class="custom-control custom-checkbox mx-2">
					<input type="checkbox" class="custom-control-input" name="inter" value="ECO" id="ECO" <c:if test="${fn:contains(inter,'ECO') or fn:contains(cmd.inter,'ECO') }">checked</c:if> /> 
						<label class="custom-control-label" for="ECO">경제</label>
				</div>
				<div class="custom-control custom-checkbox">
					<input type="checkbox" class="custom-control-input" name="inter" value="ENT" id="ENT" <c:if test="${fn:contains(inter,'ENT') or fn:contains(cmd.inter,'ENT') }">checked</c:if> /> 
						<label class="custom-control-label" for="ENT">연예</label>
				</div>
				<div class="custom-control custom-checkbox ml-2">
					<input type="checkbox" class="custom-control-input" name="inter" value="SPO" id="SPO" <c:if test="${fn:contains(inter,'SPO') or fn:contains(cmd.inter,'SPO') }">checked</c:if> /> 
					<label class="custom-control-label" for="SPO">스포츠</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label><kbd class="lead">학력사항</kbd></label> <select name="grade"
				class="custom-select mt-3 custom-select-lg">
				<option value="ELE" <c:if test="${grade=='ELE' || cmd.grade=='ELE' }">selected</c:if>>초등학교</option>
				<option value="MID" <c:if test="${grade=='MID' || cmd.grade=='MID' }">selected</c:if>>중학교</option>
				<option value="HIG" <c:if test="${grade=='HIG' || cmd.grade=='HIG' }">selected</c:if>>고등학교</option>
				<option value="UNI" <c:if test="${grade=='UNI' || cmd.grade=='UNI' }">selected</c:if>>대학교</option>
			</select>
		</div>
		<div class="form-group">
			<label><kbd class="lead">첨부파일</kbd></label>
			<div class="custom-file">
				<input type="file" class="custom-file-input" name="file" id="file" />
				<label class="custom-file-label" for="file">${file }${cmd.file }</label>
			</div>
		</div>
		<div class="form-group">
			<label><kbd class="lead">자기소개</kbd></label>
			<textarea class="form-control" rows="5" name="self">${self }${cmd.self }</textarea>
		</div>
        </fieldset>
    </div><!--container-->
<jsp:include page="/WEB-INF/views/template/Footer.jsp"/>
    