<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Insurance Policy Management</title>
	</head>
	<body>
	<div>
		<h2>Insurance Policy List</h2>

		<input type="button" value="Add InsurancePolicy" onclick="window.location.href='addInsurancePolicyForm'; return false;"/>
        <form:form action="search" method="POST">
			    <input type="text" placeholder="Search By Name/Policy Name" name="theSearchName">
			    <input type="submit" value="Search"/>
        </form:form>

		<table border="1">
			<tr>
				<th>S No.</th>

				<th>First Name
       	        &nbsp &nbsp <a href= "/search?page=0&size=5&theSearchName=${theSearchName}&sort=firstName,desc"> Desc </a>
                &nbsp &nbsp <a href= "/search?page=0&size=5&theSearchName=${theSearchName}&sort=firstName"> Asc </a>
				</th>

				<th>Last Name
       	        &nbsp &nbsp <a href= "/search?page=0&size=5&theSearchName=${theSearchName}&sort=lastName,desc"> Desc </a>
                &nbsp &nbsp <a href= "/search?page=0&size=5&theSearchName=${theSearchName}&sort=lastName"> Asc </a>
				</th>

				<th>Policy Name
       	        &nbsp &nbsp <a href= "/search?page=0&size=5&theSearchName=${theSearchName}&sort=policyName,desc"> Desc </a>
                &nbsp &nbsp <a href= "/search?page=0&size=5&theSearchName=${theSearchName}&sort=policyName"> Asc </a>
				</th>

				<th>Amount
       	        &nbsp &nbsp <a href= "/search?page=0&size=5&theSearchName=${theSearchName}&sort=amount,desc"> Desc </a>
                &nbsp &nbsp <a href= "/search?page=0&size=5&theSearchName=${theSearchName}&sort=amount"> Asc </a>
				</th>

				<th>Interest</th>

				<th>Tenure</th>

				<th>Start Date
       	        &nbsp &nbsp <a href= "/search?page=0&size=5&theSearchName=${theSearchName}&sort=startDate,desc"> Desc </a>
                &nbsp &nbsp <a href= "/search?page=0&size=5&theSearchName=${theSearchName}&sort=startDate"> Asc </a>
				</th>

				<th>Nominee</th>

				<th colspan="2">Action</th>
			</tr>

			<c:set var="index" value="${page * 5 + 1}" />
			<c:forEach var="insurancePolicy" items="${insurancePolicys}">
				<c:url var="updateLink" value="/insurancePolicy/updateInsurancePolicyForm">
					<c:param name="insurancePolicyId" value="${insurancePolicy.id}"></c:param>
				</c:url>

				<c:url var="deleteLink" value="/insurancePolicy/delete">
					<c:param name="insurancePolicyId" value="${insurancePolicy.id}"></c:param>
				</c:url>

				<tr>
					<td>${index}</td>
					<td>${insurancePolicy.firstName}</td>
					<td>${insurancePolicy.lastName}</td>
					<td>${insurancePolicy.policyName}</td>
					<td>${insurancePolicy.amount}</td>
					<td>${insurancePolicy.interest}</td>
					<td>${insurancePolicy.tenure}</td>
					<td>${insurancePolicy.startDate}</td>
					<td>${insurancePolicy.nominee}</td>
					<td>
						<!-- display the update link -->
						<a href="${updateLink}">Update</a>
					</td>
					<td>
						<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this insurancePolicy?'))) return false">Delete</a>
					</td>
					<c:if test="${insurancePolicy.is_claimed}"><td>Policy Claimed</td></c:if>
                    <c:set var="now" value="<%= LocalDate.now() %>" />
					<c:if test="${!insurancePolicy.is_claimed && insurancePolicy.startDate > now}"><td>Policy not applied yet</td></c:if>
					<c:if test="${!insurancePolicy.is_claimed && insurancePolicy.startDate <= now}"><td><a href="/updateClaimed?policyId=${insurancePolicy.id}">Claim Now</a></td></c:if>
									<c:set var="index" value="${index + 1}" />

				</tr>
			</c:forEach>
		</table>
	        <br><br>
            	<c:choose>
                    <c:when test="${totalPage == 0}">
                        No Record Found
                    </c:when>
                    <c:otherwise>
                        <c:forEach begin="0" end="${totalPage-1}" varStatus="loop">
                                &nbsp &nbsp<a href="/search?page=${loop.index}&size=5&theSearchName=${theSearchName}&sort=${sortBy}">${loop.index + 1}</a></li>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>


	</body>
</html>