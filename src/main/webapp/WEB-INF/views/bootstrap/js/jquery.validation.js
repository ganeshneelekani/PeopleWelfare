$(document).ready(function() {
    // validate the comment form when it is submitted

    $.validator.addMethod(
        "regex",
        function(value, element, regexp) {
            if (regexp.constructor != RegExp)
                regexp = new RegExp(regexp);
            else if (regexp.global)
                regexp.lastIndex = 0;
            return this.optional(element) || regexp.test(value);
        },
        "Please check your input."
    );


    // validate signup form on keyup and submit
    $("#loginForm").validate({

        //        onkeyup: false,
        //        errorClass: "req_mess",
        //        ignore: ":hidden",
        //        validClass: "signup_valid_class",
        //        errorClass: "signup_error_class",

        rules: {
            username: {
                required: true,
                regex: /^[A-Za-z0-9_]{5,15}$/,
                minlength: 5,
                maxlength: 15,

            },
            password: {
                required: true,
                minlength: 5
            }
        },
        messages: {
            username: {
                required: "Please enter a username",
                minlength: "Your username must consist of at least 5 characters",
                regex: "Please enter any alphaNumeric char of length between 5-15, ie, sbp_arun_2016"
            },
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            }
        },
        submitHandler: function(form) {
            return true;
        }
    })
});