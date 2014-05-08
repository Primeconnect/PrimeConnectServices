
var fgsApp = {
	showLoginOptions : function() {
		$(document).bind('mouseup.loginhandler', this.hideLogin);
		//$("#login-menu-panel").show();
		$("#login-menu-panel").show();
		this.positionLogin();
	},
	
	positionLogin : function() {
		$("#login-menu-panel").position({
			of : $("#login-button"),
			my : "right top",
			at : "right bottom",
			collision : "fit fit"
		});
	},
	
	hideLoginPanel : function() {
		$("#login-menu-panel").hide();
	},

	hideLogin : function(e) {
		var container = $("#login-menu-panel");

		if (!container.is(e.target)// if the target of the click isn't the container...
		&& container.has(e.target).length === 0)// ... nor a descendant of the container
		{
			$(document).unbind('mouseup.loginhandler', this.hideLogin);
			$("#login-menu-panel").hide();
		}
	},
	
	googleSignInCallback : function(authResult) {
		this.hideLoginPanel();
		gapi.client.load('plus','v1', googleAPI.loadProfile);
	},
	
	fgsSignIn : function() {
		alert("FGS Sign In invokved!");
	},
	
	displayProfile : function(profile) {
		var s = "";
		for (var i in profile) {
			var email = "no-email";
			if (i == "emails") {
				// Filter the emails object to find the user's primary account, which might
			    // not always be the first in the array. The filter() method supports IE9+.
			    email = profile['emails'].filter(function(v) {
			        return v.type === 'account'; // Filter out the primary email
			    })[0].value; // get the email from the filtered results, should always be defined.
			    
			    s = s + "<p>" + i + ": " + email + "[</p>";
			}
			else if ($.isArray(profile[i])) {
				s = s + "<p>" + i + ": " + profile[i] + "[</p>";
				for (var k in profile[i]) {
					s = s + "<p>" + k + ": " + profile[i][k] + ", </p>";
				}
				s = s + "<p>]</p><br/>";
			} else {
				s = s + "<p>" + i + ": " + profile[i] + "</p><br/>";
			}
		}
		
		$("#contentdiv").html(s);
	}
};

var googleAPI = {
	  /**
   * Uses the JavaScript API to request the user's profile, which includes
   * their basic information. When the plus.profile.emails.read scope is
   * requested, the response will also include the user's primary email address
   * and any other email addresses that the user made public.
   */
  loadProfile : function () {
    var request = gapi.client.plus.people.get( {'userId' : 'me'} );
    request.execute(function(profile){ fgsApp.displayProfile(profile); });
  }
};

