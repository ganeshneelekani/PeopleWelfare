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
    $("#studentRegistration").validate({
        //                onkeyup: false,
        //                errorClass: "req_mess",
        //                ignore: ":hidden",
        //                validClass: "signup_valid_class",
        //                errorClass: "signup_error_class",
        rules: {
            studentId: {
                minlength: 10,
                maxlength: 10,
                required: true,
                regex: /^[A-Za-z0-9]{10,10}$/
            },
            studentName: {
                required: true,
                regex: /^[A-Za-z ]{2,50}$/,
                minlength: 2,
                maxlength: 50
            },
            studentBDate: {
                required: true
            },
            studentGender: {
                required: true,
                notEqual: "Select Gender"
            },
            studentClass: {
                required: true,
                notEqual: "Select Class"
            },
            classTeacherId: {
                required: true,
                notEqual: "Select Faculty Id"
            },
            studentAddress: {
                required: true,
                maxlength: 500
            },
            guardianName: {
                required: true,
                regex: /^[A-Za-z ]{2,50}$/,
                minlength: 2,
                maxlength: 50,
            },
            studentSection: {
                required: true,
                notEqual: "Select Section"
            },
            guardianEmailAddress: {
                required: true,
                email: true,
                emailregex: /\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b/i
            },
            gurdianContactNumber: {
                required: true,
                regex: /^[A-Za-z0-9]{10,10}$/,
                minlength: 10,
                maxlength: 10
            },
            password: {
                required: true,
                minlength: 6


            },


        },
        messages: {
            studentId: {
                required: "Only Characters and Number are allowed ex : KA01YYARUN",
                regex: "Only Characters and Number are allowed ex : KA01YYARUN",
                minlength: "Only Characters and Number are allowed ex : KA01YYARUN",
                maxlength: "Only Characters and Number are allowed ex : KA01YYARUN"
            },
            studentName: {
                required: "Please provide a Student Name",
                minlength: "Your password must be at least 5 characters long"
            },
            studentBDate: {
                required: "Please provide a BDate"
            },
            studentClass: {
                required: "Please provide a Student Class"
            },
            studentSection: {
                required: "Please provide a Student Section"
            },
            studentAddress: {
                required: "Please provide a Student Address"
            },
            classTeacherId: {
                required: "Please provide a Class Teacher Name"
            },
            guardianEmailAddress: {
                required: "Please provide a Guardian Email Address ",
            },
            guardianName: {
                required: "Please provide a Guardian Name ",
            },
            gurdianContactNumber: {
                regex: "Only Numbers are allowed EX : 9999999999",
                required: "Please provide a Gurdian Contact Number",
                minlength: "Your Contact Number must be at 10 digit Number"
            },
            password: {

                required: "Password Required",
                minlength: "Password must be atleast 6 character long"
            }
        },
        submitHandler: function(form) {
            return true;
        }
    })
});