<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Insurance Policy Management</title>
	</head>
	<body>
	<div>
		<h2><a href="${pageContext.request.contextPath}/insurancePolicy/list">Insurance Policy List</a></h2>

		<input type="button" value="Add InsurancePolicy" onclick="window.location.href='addInsurancePolicyForm'; return false;"/>
        <form:form action="search" method="POST">
			<div>
			    <div>
			      <div><i aria-hidden="true"></i></div>
			    </div>
			    <input type="text" placeholder="Search By Name" name="theSearchName">
			    <input type="submit" value="Search"/>
			</div>
        </form:form>
		<table border="1">
			<tr>
				<th>#</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Amount</th>
				<th>Interest</th>
				<th>Tenure</th>
				<th>Start Date</th>
				<th>Nominee</th>
				<th>Policy Name</th>
				<th colspan="2">Action</th>
			</tr>
			<c:set var="index" value="0" />
			<c:forEach var="insurancePolicy" items="${insurancePolicys }">
				<c:url var="updateLink" value="/insurancePolicy/updateInsurancePolicyForm">
					<c:param name="insurancePolicyId" value="${insurancePolicy.id}"></c:param>
				</c:url>

				<c:url var="deleteLink" value="/insurancePolicy/delete">
					<c:param name="insurancePolicyId" value="${insurancePolicy.id}"></c:param>
				</c:url>

				<c:set var="index" value="${index + 1}" />
				<tr>
					<td>${index}</td>
					<td>${insurancePolicy.firstName}</td>
					<td>${insurancePolicy.lastName}</td>
					<td>${insurancePolicy.amount}</td>
					<td>${insurancePolicy.interest}</td>
					<td>${insurancePolicy.tenure}</td>
					<td>${insurancePolicy.startDate}</td>
					<td>${insurancePolicy.nominee}</td>
					<td>${insurancePolicy.policyName}</td>
					<td>
						<!-- display the update link -->
						<a href="${updateLink}">Update</a>
					</td>
					<td>
						<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this insurancePolicy?'))) return false">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</body>
</html>