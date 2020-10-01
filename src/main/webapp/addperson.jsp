<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Person record activity</title>


</head>
<body>
<script>
function add(){
	document.getElementById("perinfoForm").action='addPerson';
	 document.getElementById("perinfoForm").submit();
}
function del(){
	document.getElementById("perinfoForm").action='delPerson';
	 document.getElementById("perinfoForm").submit();
}
function modify(){
	document.getElementById("perinfoForm").action='modifyPerson';
	 document.getElementById("perinfoForm").submit();
}

function view(){
	
	//document.getElementById("perinfoForm")[0].method='GET';
	 var r=document.getElementById("perinfoForm").action;
	 document.getElementById("perinfoForm").action='viewPerson';
	 document.getElementById("perinfoForm").submit();
}
function viewAll(){
	
	//document.getElementById("perinfoForm")[0].method='GET';
	 var r=document.getElementById("perinfoForm").action;
	 document.getElementById("perinfoForm").action='viewAllPerson';
	 document.getElementById("perinfoForm").submit();
}

function addAdress1(){
	
	//document.getElementById("perinfoForm")[0].method='GET';
	 var r1=document.getElementById("street").value;
	 var r2=document.getElementById("city").value;
	 var r3=document.getElementById("state").value;
	 var r4=document.getElementById("postCode").value;
	 
	
}

function addAddress(){
	document.getElementById("addreinfoForm").action='addAdress';
	 document.getElementById("addreinfoForm").submit();
}

function delAdress(){
	document.getElementById("addreinfoForm").action='delAddress';
	 document.getElementById("addreinfoForm").submit();
}
function modifyAddress(){
	document.getElementById("addreinfoForm").action='modifyAddress';
	 document.getElementById("addreinfoForm").submit();
}

function viewAddress(){
	
	//document.getElementById("perinfoForm")[0].method='GET';
	 var r=document.getElementById("addreinfoForm").action;
	 document.getElementById("addreinfoForm").action='viewAddress';
	 document.getElementById("addreinfoForm").submit();
}

</script>

<div align="center">
<h2> Person info </h2>
<form id="perinfoForm" action="addPerson" method="post">
Person id:* <input type="text" name="eid"><br>
firstName:  <input type="text" name="firstName"><br>
lastName:   <input type="text" name="lastName"><br>
<button onclick="add()">add</button> <button onclick="del()">delete</button> <button onclick="modify()">modify</button><button onclick="view()">view</button><button onclick="viewAll()">viewAll</button>

</form>

<h4> ${result}</h4>
</div>

<br><br><br>
 
<div align="center">
<h2> Address info</h2>

<form id="addreinfoForm" action="addAdress" method="post">
PersonId: *   <input type="text" name="apid" ><br>
AddressId:*   <input type="text" name="aid"><br>
Street:       <input type="text" name="street"><br>
city:         <input type="text" name="city"><br>
state:        <input type="text" name="state"><br>
PostalCode:   <input type="text" name="postCode"><br>
<button onclick="addAddress()">add</button> <button onclick="delAdress()">delete</button> <button onclick="modifyAddress()">modify</button><button onclick="viewAddress()">view</button>

</form>
<h4> ${result1}</h4>
</div>
</body>
</html>