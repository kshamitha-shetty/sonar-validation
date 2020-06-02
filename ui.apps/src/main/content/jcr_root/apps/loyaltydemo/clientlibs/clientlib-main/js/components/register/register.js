(function() {
    "use strict";


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

    // register form validation 
    var $register = $("#register"),
        $accountNo = $register.find('input[name="accountNo"]').data("error"),
        $name = $register.find('input[name="name"]').data("error"),
        $email = $register.find('input[name="email"]').data("error"),
        $invalidEmail = $register.find('input[name="email"]').data("pattern"),
        $userName = $register.find('input[name="userName"]').data("error"),
        $password = $register.find('input[name="password"]').data("error"),
        $confirmPassword = $register.find('input[name="confirmPassword"]').data("error"),
        $invalidConfirmPassword = $register.find('input[name="confirmPassword"]').data("pattern");

    $('form[id="register"]').validate({
        rules: {
            accountNo: 'required',
            name: 'required',
            email: {
                required: true,
                email: true,
                emailValidation: true
            },
            userName: 'required',
            password: {
                required: true
            },
            confirmPassword: {
                required: true,
                equalTo: "#password"
            }
        },
        messages: {
            accountNo: $accountNo,
            name: $name,
            email: {
                required: $email,
                email: $invalidEmail,
                emailValidation: $invalidEmail
            },
            userName: $userName,
            password: $password,
            confirmPassword: {
                required: $confirmPassword,
                equalTo: $invalidConfirmPassword
            }
        },
        submitHandler: function(form) {
            form.submit();
        }
    });

})();