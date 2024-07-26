<%@ page language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>EMployee LIst</h1>

<c:choose>
	<c:when test="${!empty pageData }">
		<table>
			<tr>
				<th>eno</th>
				<th>ename</th>
				<th>desg</th>
				<th>salary</th>
				<th>deptno</th>
				<th>operations</th>
				<c:forEach var="emp" items="${pageData.getContent() }">
					<tr>
						<td>${emp.empno }</td>&nbsp;
						<td>${emp.ename }</td>&nbsp;
						<td>${emp.job }</td>&nbsp;
						<td>${emp.sal }</td>&nbsp;
						<td>${emp.deptno }</td>&nbsp;
						<td><a href="edit_employee?eno=${emp.empno }"">Edit</a>&nbsp;&nbsp;</td>
						<td><a href="delete_employee?eno=${emp.empno }"
							onclick="confirm('Do you want to delete bro')">Delete</a></td>
					</tr>
				</c:forEach>
		</table>
		<br>
		<br>
		<p>
		<c:if test="${!pageData.isFirst() }">
			<a href="emp_report?page=0">[first]</a>&nbsp;
		</c:if>
		<c:if test="${!pageData.isLast() }">
			<a href="emp_report?page=${pageData.getNumber()+1 }">[next]</a>&nbsp;
		</c:if>

			<c:forEach var="i" begin="1" end="${pageData.getTotalPages() }" step="1">
				[<a href="emp_report?page=${i-1 }">${i }</a>]&nbsp;&nbsp;	
			</c:forEach>

		<c:if test="${!pageData.isLast() }">
			<a href="emp_report?page=${pageData.getTotalPages()-1 }">[last]</a>&nbsp;
		</c:if>
		<c:if test="${!pageData.isFirst() }">
			<a href="emp_report?page=${pageData.getNumber()-1 }">[previous]</a>&nbsp;
		</c:if>
		</p>
	</c:when>
	<c:otherwise>
		<h1>Record not found</h1>
	</c:otherwise>
</c:choose>
<blink>
	<h1>${result }</h1>
</blink>
<br>
<br>
<h1>
	<a href="insert_employee">Add Employee</a>
</h1>
<br>
<br>
<H1>
	<a href="./">Home</a>
</H1>
