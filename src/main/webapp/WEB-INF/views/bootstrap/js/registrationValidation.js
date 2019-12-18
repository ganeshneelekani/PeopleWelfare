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
    $("#personRegistrationForm").validate({
        //                onkeyup: false,
        //                errorClass: "req_mess",
        //                ignore: ":hidden",
        //                validClass: "signup_valid_class",
        //                errorClass: "signup_error_class",
        rules: {
            personFirstName: {
                required: true,
                regex: /^[A-Za-z]{2,50}$/,
                minlength: 2,
                maxlength: 50
            },
            personLastName: {
                required: true,
                regex: /^[A-Za-z]{2,50}$/,
                minlength: 1,
                maxlength: 50
            },
            gender: {
                required: true,
                notEqual: "Select Gender"
            },
            personAddress: {
                required: true,
                maxlength: 500
            },
            nominee: {
                required: true,
                regex: /^[A-Za-z]{2,50}$/,
                minlength: 2,
                maxlength: 50,
            },
            nomineeRelation: {
                required: true,
                minlength: 2,
                maxlength: 50,
            },
            country: {
                required: true,
                notEqual: "Select Country"
            },
            state: {
                required: true,
                notEqual: "Select State"
            },
            emailAddress: {
                required: true,
                email: true,
                emailregex: /\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b/i
            },
            contactNumber: {
                required: true,
                regex: /^[0-9]{10,10}$/,
                minlength: 10,
                maxlength: 10
            },
            pinCode: {
                required: true,
                regex: /^[0-9]{6,6}$/,
                minlength: 6,
                maxlength: 6
            },
            password: {
                required: true,
                minlength: 6
            },

            verifyPassword: {
                required: true,
                minlength: 6,
                equalTo: password
            },
            parentReference: {
                minlength: 7,
                maxlength: 7,
                required: true,
                // regex: /^[A-Za-z0-9]{7,7}$/
                regex: /^[a-zA-Z]{2}[0-9]{5,5}$/
            },
        },
        messages: {
            personFirstName: {
                regex: "Cannot have special character",
                required: "First Name Required",
                minlength: "Minimum 2 characters"

            },
            personLastName: {
                regex: "Cannot have special character",
                required: "Last Name Required"
            },
            country:{
            required: "Please provide the Country"
            },
            nominee: {
                required: "Please provide the Nominee name"
            },
            nomineeRelation: {
                required: "Please provide the Nominee relation"
            },
            personAddress: {
                required: "Please provide a Person address"
            },
            emailAddress: {
                required: "Please provide valid email address"
            },
            contactNumber: {
                regex: "Your Number must be at 10 digit Number EX : 9999999999",
                required: "Please provide Contact Number",
                minlength: "Your Contact Number must be at 10 digit Number"
            },
            pinCode: {
                regex: "Your Pin Code must be at 6 digit Number EX : 555555",
                required: "Please provide Pin Code",
                minlength: "Your Contact Number must be at 6 digit Number"
            },
            password: {
                required: "Password Required",
                minlength: "Password must be atleast 6 character long"
            },
            verifyPassword: {
                required: "Enter Confirm Password Same as Password",
                minlength: "Password must be atleast 6 character long"
            },
            parentReference: {
                required: "Person reference cannot be blank",
                regex: "Valid Person reference is PP00000",
                minlength: "7 characters are allowed",
                maxlength: "7 characters are allowed"
            },

        },
        submitHandler: function(form) {
            return true;
        }
    })
});