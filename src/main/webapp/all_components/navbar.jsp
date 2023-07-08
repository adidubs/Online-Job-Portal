<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page isELIgnored = "false" %> 

<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
	<a class="navbar-brand" href="#">Navbar</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">Home
					<span class="sr-only">(current)</span>
			</a></li>
			
			<c:if test = "${userobj.role eq 'admin'}">
			<li class="nav-item"><a class="nav-link" href="add_jobs.jsp"><i
					class="fa-solid fa-plus"></i>Post Job</a></li>
			<li class="nav-item"><a class="nav-link" href="view_jobs.jsp"><i
					class="fa-solid fa-eye"></i>View Job</a></li>
			
			</c:if>
			
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<a href="login.jsp" class="btn btn-light mr-1"><i
				class="fa-solid fa-user"></i> Login</a> <a href="signUp.jsp"
				class="btn btn-light"><i class="fa-solid fa-user"></i> Sign Up</a>
		</form>
	</div>
</nav>