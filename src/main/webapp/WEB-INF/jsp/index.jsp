<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Search Insurance Plans</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container my-5">
		<h1 class="pb-3 pt-3 text-center">Search Insurance Plans</h1>
		<div class="col-md-8">
			<form:form method="POST" action="search" modelAttribute="search">

				<label for="planName">Plan Name:</label>
				<select id="planName" name="planNames">
					<option value="">Select Plan Name</option>
					<c:forEach var="planName" items="${planNames}">
						<option>${planName}</option>
					</c:forEach>
				</select> &nbsp; &nbsp; &nbsp;
 
        <label for="planStatus">Plan Status:</label>
				<select id="planStatus" name="planStatus">
					<option value="">Select Plan Status</option>
					<c:forEach var="planStatus" items="${planStatus}">
						<option value="${planStatus}">${planStatus}</option>
					</c:forEach>
				</select>&nbsp; &nbsp; &nbsp;
 
        <label for="gender">Gender:</label>
				<select name="gender" id="gender">
					<option value="">Select Gender</option>
					<option value="Male">Male</option>
					<option value="Female">Female</option>
					<option value="Tech">Tech</option>
				</select>
				<br>
				<br>

				<label for="startDate">Start Date:</label>
				<input type="date" name="startDate" />

				<label for="endDate">End Date:</label>
				<input type="date" name="endDate" />

				<br>
				<br>
				<div class="text-center"> <input type="submit" value="Search" class="btn btn-primary"> </div>
			</form:form>

		</div>
		<hr>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Sr N0</th>
					<th>Holder Name</th>
					<th>Gender</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>BenifitAmt</th>
					<th>DenielReason</th>
					<th>TerminatedDate</th>
					<th>TerminationRsn</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${plans}" var="plan" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.citizenName}</td>
						<td>${plan.gender}</td>
						<td>${plan.planName}</td>
						<td>${plan.planStatus}</td>
						<td>${plan.planStartDate}</td>
						<td>${plan.planEndDate}</td>
						<td>${plan.benifitAmt}</td>
						<td>${plan.denielReason}</td>  
						<td>${plan.terminatedDate}</td>
						<td>${plan.terminationRsn}</td>
					</tr>
				</c:forEach>
				<tr>
				<c:if test="${empty plans}">
						<td colspan="8" style="text-align: center">No Record Found</td>
				</c:if>
				</tr>
						
			</tbody>
			
		</table>
		Export: <a href="excel">Excel</a>|<a href="pdf">Pdf 
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>