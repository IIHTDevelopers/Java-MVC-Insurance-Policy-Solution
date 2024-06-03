<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Insurance Policy Management</title>
	</head>
	<body>
	<div>
		<h2>Insurance Policies</h2>
		<h3>Add InsurancePolicy</h3>
		<div>
			<div>
				<hr>
				<form:form action="saveInsurancePolicy" modelAttribute="insurancePolicy" method="POST">
					<div>
						<label for="firstName">First Name: </label>
						<form:input path="firstName" name="firstName" />
						<form:errors path="firstName"/>
					</div>
                    <div>
						<label for="lastName">Last Name: </label>
						<form:input path="lastName" name="lastName" />
						<form:errors path="lastName"/>
					</div>
                    <div>
						<label for="amount">Amount: </label>
						<form:input type="number" path="amount" name="amount" step = "0.1" />
						<form:errors path="amount"/>
					</div>
                    <div>
						<label for="interest">Interest: </label>
						<form:input type="number" path="interest" name="interest"  />
						<form:errors path="interest"/>
					</div>
                    <div>
						<label for="tenure">Tenure(In Months): </label>
						<form:input type="number" path="tenure" name="tenure"  />
						<form:errors path="tenure"/>
					</div>
                    <div>
						<label for="startDate">Start Date: </label>
						<form:input type="date" path="startDate" name="startDate"/>
						<form:errors path="startDate"/>
					</div>
						<label for="nominee">Nominee: </label>
						<form:input path="nominee" name="nominee" />
						<form:errors path="nominee"/>
					</div>
						<label for="policyName">Policy Name: </label>
						<form:input path="policyName" name="policyName" />
						<form:errors path="policyName"/>
					</div>

					<input type="submit" value="Save"/>
				</form:form>
			</div>
		</div>
		<a href="${pageContext.request.contextPath}/insurancePolicy/list">Back to List</a>
	</div>
	</body>
</html>