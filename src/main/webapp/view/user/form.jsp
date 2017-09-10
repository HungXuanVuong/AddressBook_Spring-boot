<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="${path}/js/jquery.boot.js"></script>
<script type="text/javascript" src="${path }/js/jquery.save.js"></script>

<div class="panel panel-default">
	<div class="panel panel-heading">
		<strong> <span class="glyphicon glyphicon-plus-sign"></span>
			New User
		</strong>
	</div>
	 <form:form method="post" class="form-horizontal" action="${path}/user/add"
		commandName="userForm" id="submitUserForm">
		<form:hidden path="id" />
		<div class="panel-body">
		<div class="form-group">
				<label class="col-md-2 control-label"><strong>Full Name :</strong></label>
				<div class="col-md-4">
					<form:input class="form-control" path="fullName"
						placeholder="Enter User Id" required="true"/>
				</div>
				<label class="col-md-2 control-label">User
						Id :</label>
				<div class="col-md-4">
					<form:input class="form-control" path="userId"
						placeholder="Enter User Id" required="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label"><strong>User Name :</strong></label>
				<div class="col-md-4">
					<form:input class="form-control" path="userName"
						placeholder="Enter User Name" required="true"/>
				</div>
				<label class="col-md-2 control-label">Password :</label>
				<div class="col-md-4">
					<form:password class="form-control" path="password"
						placeholder="Enter Password" required="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Role :</label>
				<div class="col-md-4">
					<form:select class="form-control" path="roleId">
						<c:forEach items="${roles}" var="role">
							<form:option value="${role.id}">${role.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<label class="col-md-2 control-label"></label>
				<div class="col-md-4">
					
				</div>
			</div>
		</div>
		<div class="panel-footer">
			<form:button value="Save" class="btn btn-xs btn-default">
				<span class="glyphicon glyphicon-floppy-disk"></span> Save
			</form:button>
		</div>
	</form:form>
</div>

