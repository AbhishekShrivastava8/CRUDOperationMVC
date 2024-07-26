//Client Side Error message cfgs

function validation(frm) {
	
	alert("CLient Side:: Error message");
	document.getElementById("enameErr").innerHTML = "";
	document.getElementById("jobErr").innerHTML = "";
	document.getElementById("salErr").innerHTML = "";
	document.getElementById("deptnoErr").innerHTML = "";

	var name = frm.ename.value;
	var desg = frm.job.value;
	var salary = frm.sal.value;
	var deptno = frm.deptno.value;
	var validationFlag = true;

	if (name == "") {
		document.getElementById("enameErr").innerHTML = "Employee Name is required(cs)";
		validationFlag = false;
	}
	else if (name.length() < 5) {
		document.getElementById("enameErr").innerHTML = "Employee Name must have minimum of 5 characters(cs)";
		validationFlag = false;
	}

	if (desg == "") {
		document.getElementById("jobErr").innerHTML = "Employee Desg is required(cs)";
		validationFlag = false;
	}
	else if (desg.length() < 5) {
		document.getElementById("jobErr").innerHTML = "Employee Desg must have minimum 5 characters(cs)";
		validationFlag = false;
	}

	if (salary == "") {
		document.getElementById("salErr").innerHTML = "Employee Salary is required(cs)";
		validationFlag = false;
	}
	else if (isNaN(salary)) {
		document.getElementById("salErr").innerHTML = "Employee salary must be numeric value(cs)";
		validationFlag = false;
	}
	else if (salary < 10000 || salary > 1000000) {
		document.getElementById("salErr").innerHTML = "Employee salary must be given in the range 10000 to 10000000(cs)";
		validationFlag = false;
	}

	if (deptno == "") {
		document.getElementById("deptnoErr").innerHTML = "Employee Dept number is required(cs)";
		validationFlag = false;
	}
	else if (isNaN(deptno)) {
		document.getElementById("deptnoErr").innerHTML = "Employee Dept must be numeric value(cs)";
		validationFlag = false;
	}
	else if (deptno < 10 || deptno > 1000) {
		document.getElementById("deptnoErr").innerHTML = "Employee Dept must be given in the range of 100 to 1000(cs)";
		validationFlag = false;
	}
	frm.vflag.value="yes";
	return validationFlag;
}
