(function () {
	"use strict";
	// forgot-password component specific code here…

	$("form[name='forgot-password']").validate({
		// Specify validation rules
		rules: {
			email: {
				required: true,
				// Specify that email should be validated
				// by the built-in "email" rule
				email: true
			},
			password: {
				required: true,
				minlength: 8,
				maxlength: 35
			},
			confirmPassword: {
				required: true,
				equalTo: "#password"
			}
		},
		messages: {
			password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long"
			},
			confirmPassword: {
				required: "Please provide a password"
			},
			email: "Please enter a valid email address"
		},
		submitHandler: function (form) {
			form.submit();
		}
	});

})();
