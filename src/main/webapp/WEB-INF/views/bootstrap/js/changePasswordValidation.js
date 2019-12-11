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
    $.validator.addMethod(
        "emailregex",
        function(value, element, emailregex) {
            if (emailregex.constructor != RegExp) emailregex = new RegExp(emailregex);
            else if (emailregex.global) emailregex.lastIndex = 0;
            return this.optional(element) || emailregex.test(value);
        }
    );
    $.validator.addMethod("notEqual", function(value, element, param) {
        return this.optional(element) || value != param;
    }, "Please specify a different value");

    // validate signup form on keyup and submit
    $("#updatePasswordForm").validate({
        //                onkeyup: false,
        //                errorClass: "req_mess",
        //                ignore: ":hidden",
        //                validClass: "signup_valid_class",
        //                errorClass: "signup_error_class",
        rules: {
            password: {
                required: true,
                minlength: 6
            },

            verifyPassword: {
                required: true,
                minlength: 6,
                equalTo: password
            },

        },
        messages: {

            password: {
                required: "Password Required",
                minlength: "Password must be atleast 6 character long"
            },
            verifyPassword: {
                required: "Enter Confirm Password Same as Password",
                minlength: "Password must be atleast 6 character long"
            },
        },
        submitHandler: function(form) {
            return true;
        }
    })
});