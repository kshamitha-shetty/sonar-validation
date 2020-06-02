(function() {
    "use strict";
    // login component specific code here…
    var $login = $("#login"),
        $userName = $login.find('input[name="userName"]').data("error"),
        $password = $login.find('input[name="password"]').data("error");

    // login form validation
    $('form[id="login"]').validate({
        rules: {
            userName: 'required',
            password: {
                required: true
            }
        },
        messages: {
            userName: $userName,
            password: $password
        },
        submitHandler: function(form) {
            form.submit();
        }
    });
})();