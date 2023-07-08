<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page isELIgnored = "false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Jobs</title>
<%@include file="all_components/all_css.jsp"%>
</head>
<body style="background-color: #C8C8C8">
	<%@include file="all_components/navbar.jsp"%>
	<div class="container p-2">
		<div class="col-md-10 offset-md-1">
			<div class="card">
				<div class="card-body">
					<div class="text-center text-success">
						<i class="fas fa-user-friends fa-3x"></i>
						 
						 <c:if test="${not empty succMsg }">
							<div class="alert alert-success" role="alert">${succMsg }</div>
							<c:remove var="succMsg" />
						</c:if> 
						<h5>Add Jobs</h5>

					</div>
					<form action="add_jobs" method="post">
						<div class="form-group">
							<label>Enter Title</label><input type="text" name="title"
								required class="form-control">
						</div>
						<div class="form-row">
							<div class="form-group col-md-4">
								<label>Location</label><select name="location"
									class="custom-select" id="inlineFormCustomSelectPref"><option
										selected>Choose....</option>
									<option value="New Delhi">New Delhi</option>
									<option value="Jharkhand">Jharkhand</option>
									<option value="Gujurat">Gujurat</option>
									<option value="Bhubaneswar">Bhubaneswar</option>
									<option value="Banglore">Banglore</option>
									<option value="Hydrabad">Hydrabad</option>
								</select>
							</div>

							<div class="form-group col-md-4">
								<label>Category</label><select class="custom-select"
									id="inlineFormCustomSelectPref" name="category">
									<option selected>Choose ...</option>
									<option value="IT">IT</option>
									<option value="Devloper">Devloper</option>
									<option value="Banking">Banking</option>
									<option value="Tester">Testing</option>
									<option value="Sales">Sales</option>
								</select>
							</div>

							<div class="form-group col-md-4">
								<label>Status</label> <select class="form-control" name="status">
									<option class="Active" value="Active">Active</option>
									<option class="Inactive" value="Inactive">InActive</option>
								</select>
							</div>

						</div>
						<div class="form-group">
							<label>Enter Description</label>
							<textarea required rows="6" cols="" name="desc"
								class="form-control"></textarea>
						</div>
						<button class="btn btn-success">Publish Job</button>

					</form>
				</div>
			</div>
		</div>

	</div>

</body>
</html>