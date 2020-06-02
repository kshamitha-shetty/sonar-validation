(function() {
    "use strict";
    // forgot-username component specific code here…

    // custom email validation
    $.validator.addMethod(
        "emailValidation",
        function(value, element) {
            if (!/^([0-9a-zA-Z]+[-._'+&])*[_0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$/.test(value)) {
                return false; // FAIL validation when REGEX matches
            } else {
                return true; // PASS validation otherwise
            }
        },
        ""
    );

    var $forgotUsername = $("#forgotUsername"),
        $email = $forgotUsername.find('input[name="email"]').data("error"),
        $invalidEmail = $forgotUsername.find('input[name="email"]').data("pattern");

    // login form validation
    $('form[id="forgotUsername"]').validate({
        rules: {
            email: {
                required: true,
                email: true,
                emailValidation: true
            }
        },
        messages: {
            email: {
                required: $email,
                email: $invalidEmail,
                emailValidation: $invalidEmail
            }
        },
        submitHandler: function(form) {
            form.submit();
        }
    });
})();