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
    $("#loginForm").validate({
        //                onkeyup: false,
        //                errorClass: "req_mess",
        //                ignore: ":hidden",
        //                validClass: "signup_valid_class",
        //                errorClass: "signup_error_class",
        rules: {
            personId: {
                minlength: 7,
                maxlength: 7,
                required: true,
               // regex: /^[A-Za-z0-9]{7,7}$/
                regex: /^[a-zA-Z]{2}[0-9]{5,5}$/
            },
            personPassword: {
                required: true,
                minlength: 6
            },
        },
        messages: {
            personId: {
                required: "Person Id cannot be blank",
                regex: "Valid Person ID is PP00000",
                minlength: "7 characters are allowed",
                maxlength: "7 characters are allowed"
            },
            personPassword: {
                required: "Password cannot be blank",
            }
        },
        submitHandler: function(form) {
            return true;
        }
    })
});