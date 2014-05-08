<div id="header-panel">
	<p>My Health Schedule Logo!</p>
	<div id="top-menu-panel">
		<a href="#" id="login-button">Sign In / Register</a>
	</div>
	<script>
		$(function() {
			$("#login-button").addClass("loginButton");
			$("#login-button").button().click(function(event) {
				event.preventDefault();
				fgsApp.showLoginOptions();
			});
			$("#top-menu-panel").position({
							of: $("#header-panel"), 
							my:"right top", 
							at:"right top", 
							collision:"fit fit"
						});
		});
	</script>
</div>

<script type="text/javascript">
  (function() {
    var po = document.createElement('script');
    po.type = 'text/javascript'; po.async = true;
    po.src = 'https://plus.google.com/js/client:plusone.js';
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(po, s);
  })();
  
  function onGoogleSignInCallback(authResult) {
  	fgsApp.googleSignInCallback(authResult);
  }
</script>

<div id="login-menu-panel">
	<table id="login-option-table">
		
		<!-- google sign in -->
		<tr><td class="login-menu-option">
		  <div id="gConnect" style="margin:auto;">
		    <button class="g-signin"
		        data-scope="https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email"
		        data-requestvisibleactions=""
		        data-clientId="44577598835-edk4kn9g4k4nj92bi5osr200795e2v4g.apps.googleusercontent.com"
		        data-callback="onGoogleSignInCallback"
		        data-theme="dark"
		        data-width="wide"
		        data-cookiepolicy="single_host_origin">
		  	</button>
		  </div>
		</td></tr>
		
		<tr><td class="login-menu-option">
			<p style="height:30px; background:lightblue;">Facebook SignIn </p>
		</td></tr>
		<tr><td class="login-menu-option">
			<p>MyHealth!</p>
			<input type="text" name="userId" class="login-form-input" placeholder="User Id" size="30" ><br>
			<input type="password" name="userId" class="login-form-input" placeholder="Password" size="30"><br>
			<a href="#" id="fgs-signin">Sign In</a> &nbsp;&nbsp;&nbsp; <a href="#">Need Help?</a>
		</td></tr>
		<tr><td class="login-menu-option"><p>Not a member? Register Now!</p></td></tr>
		<tr><td class="login-menu-option"><p>I am a Customer</p></td></tr>
		<tr><td class="login-menu-option"><p>I am a Doctor</p></td></tr>
		<tr><td class="login-menu-option"><p>I have a Medical Practice</p></td></tr>
	</table>
</div>

<script>
	$(function() {
		$("#fgs-signin").addClass("fgsSigninButton");
		$("#fgs-signin").button().click(function(event) {
			event.preventDefault();
			fgsApp.fgsSignIn();
		});
	});
</script>
