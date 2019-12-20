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
    $("#updatePassword").validate({
        //                onkeyup: false,
        //                errorClass: "req_mess",
        //                ignore: ":hidden",
        //                validClass: "signup_valid_class",
        //                errorClass: "signup_error_class",
        rules: {
            otp: {
                required: true,
                minlength: 6,
                maxlength: 6
            },
            password: {
                            required: true,
                            minlength: 6
                        },
                        reEnterPassword: {
                            required: true,
                            minlength: 6,
                            equalTo: password
                        },
        },
        messages: {
            otp: {
                            regex: "OTP must be at 6 digit Number EX : 555555",
                            required: "Please provide OTP",
                            minlength: "Your OTP 6 digit Number",
                            maxlength: "Your OTP 6 digit Number"
                        },
                        password: {
                            required: "Password Required",
                            minlength: "Password must be atleast 6 character long"
                        },
                        reEnterPassword: {
                            required: "Enter Confirm Password Same as Password",
                            minlength: "Password must be atleast 6 character long"
                        },
        },
        submitHandler: function(form) {
            return true;
        }
    })
});