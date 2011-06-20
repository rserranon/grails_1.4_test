<%@ page import="org.example.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'userName', 'error')} required">
	<label for="userName">
		<g:message code="user.userName.label" default="User Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="userName" required="" value="${userInstance?.userName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'facebookUID', 'error')} ">
	<label for="facebookUID">
		<g:message code="user.facebookUID.label" default="Facebook UID" />
		
	</label>
	<g:textField name="facebookUID" value="${userInstance?.facebookUID}"/>
</div>

