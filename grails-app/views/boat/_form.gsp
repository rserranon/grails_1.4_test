<%@ page import="org.example.Boat" %>



<div class="fieldcontain ${hasErrors(bean: boatInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="boat.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${boatInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: boatInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="boat.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="owner" required="" value="${boatInstance?.owner}"/>
</div>

