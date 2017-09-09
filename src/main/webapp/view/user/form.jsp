<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<div class="panel panel-default">
	<div class="panel panel-heading">
		<strong> <span class="glyphicon glyphicon-plus-sign"></span>
			New User
		</strong>
	</div>
	<form:form method="post" class="form-horizontal" action="${path}/user/add"
		commandName="userForm">
		<form:hidden path="id" />
		<div class="panel-body">
			<div class="form-group">
				<label class="col-md-2 control-label"><strong>User
						Id :</strong></label>
				<div class="col-md-4">
					<form:input class="form-control" path="userId"
						placeholder="Enter User Id" required="true"/>
				</div>
				<label class="col-md-2 control-label">User Name :</label>
				<div class="col-md-4">
					<form:input class="form-control" path="userName"
						placeholder="Enter User Name" required="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Password :</label>
				<div class="col-md-4">
					<form:password class="form-control" path="password"
						placeholder="Enter Password" required="true"/>
				</div>
				<label class="col-md-2 control-label">Role :</label>
				<div class="col-md-4">
					<form:select path="role.id" class="form-control">
						<c:forEach items="${roles}" var="role">
							<form:option value="${role.id}">${role.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
		</div>
		<div class="panel panel-footer">
			<form:button value="Save" class="btn btn-xs btn-default">
				<span class="glyphicon glyphicon-floppy-disk"></span> Save
			</form:button>
		</div>
	</form:form>
</div>

<%-- <form:form method="post" action="${path}/user/add"
	commandName="userForm">
	<form:hidden path="id" />
	<p>
		User Id :
		<form:input path="userId" placeholder="Enter User Id" />
	</p>
	<p>
		User Name :
		<form:input path="userName" placeholder="Enter User Name" />
	</p>
	<p>
		Password :
		<form:password path="password" placeholder="Enter Password" />
	</p>
	<p>
		Role :
		<form:select path="role.id">
			<c:forEach items="${roles}" var="role">
				<form:option value="${role.id}">${role.name}</form:option>
			</c:forEach>
		</form:select>
	</p>
	<p>
		<form:button value="Save">Save
				</form:button>
		<a href="${path}/user/list">User List</a>
	</p>
</form:form> --%>
