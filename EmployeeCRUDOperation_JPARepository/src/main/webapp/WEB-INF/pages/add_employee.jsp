
<%@ page language="java" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1>REgistration page</h1>
<script type="text/javascript" src="js/form_validation.js"></script>

<form:form modelAttribute="emp" onclick="return validation(this)">
<!-- 	<p> -->
<%-- 		<form:errors path="*" /> --%>
<!-- 	</p> -->
	<table>
		<tr>
			<td>emp name::</td>
			<td><form:input path="ename" /> <form:errors path="ename" /><span id="enameErr"></span></td>
		</tr>
		<tr>
			<td>emp desg::</td>
			<td><form:input path="job" /> <form:errors path="job" /><span id="jobErr"></span></td>
		</tr>
		<tr>
			<td>emp salary::</td>
			<td><form:input path="sal" /> <form:errors path="sal" /><span id="salErr"></span></td>
		</tr>
		<tr>
			<td>emp Deptno::</td>
			<td><form:input path="deptno" /> <form:errors path="deptno" /><span id="deptnoErr"></span></td>
		</tr>	
		<tr>
			<td><input type="submit" value="Insert" /></td>
			<td><button type="reset">Reset</button></td>
		</tr>
		<tr>
			<td><form:hidden path="vflag" /></td>
		</tr>
	</table>
</form:form>