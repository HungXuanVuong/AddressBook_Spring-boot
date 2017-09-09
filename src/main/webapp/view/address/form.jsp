<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<div class="panel panel-default">
	<div class="panel panel-heading">
		<strong> <span class="glyphicon glyphicon-plus-sign"></span>
			New Address
		</strong>
	</div>
	<form:form method="post" class="form-horizontal"
		action="${path}/address/add" commandName="addressForm">
		<form:hidden path="id" />
		<div class="panel panel-body">
			<div class="form-group">
				<label class="col-md-2 control-label">Country :</label>
				<div class="col-md-4">
					<form:input class="form-control" path="country" placeholder="Enter Country" required="true"/>
				</div>
				<label class="col-md-2 control-label">State :</label>
				<div class="col-md-4">
					<form:input path="state" placeholder="Enter State" class="form-control" required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">City :</label>
				<div class="col-md-4">
					<form:input path="city" placeholder="Enter City" class="form-control" required="true"/>
				</div>
				<label class="col-md-2 control-label">User :</label>
				<div class="col-md-4">
					<form:select path="user.id" class="form-control">
						<c:forEach items="${users}" var="user">
							<form:option value="${user.id}">${user.userName}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>

		</div>
		<div class="panel panel-footer">
			<form:button value="Save" class="btn btn-xs btn-default">
				<span class="glyphicon glyphicon-floppy-disk"></span>Save
				</form:button>
		</div>
	</form:form>

</div>

<%-- <form:form method="post" action="${path}/address/add"
	commandName="addressForm">
	<form:hidden path="id" />
	<p>
		Country :
		<form:input path="country" placeholder="Enter Country" />
	</p>
	<p>
		State :
		<form:input path="state" placeholder="Enter State" />
	</p>
	<p>
		City :
		<form:input path="city" placeholder="Enter City" />
	</p>
	<p>
		User :
		<form:select path="user.id">
			<c:forEach items="${users}" var="user">
				<form:option value="${user.id}">${user.userName}</form:option>
			</c:forEach>
		</form:select>
	</p>
	<p>
		<form:button value="Save">Save
				</form:button>
		<a href="${path}/address/list">Addres List</a>
	</p>
</form:form> --%>
