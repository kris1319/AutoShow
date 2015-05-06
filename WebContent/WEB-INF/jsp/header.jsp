<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="WEB-INF/resources/main.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.0/jquery.form-validator.min.js"></script>
    <script>
    	var myLanguage = {
                errorTitle: 'Form submission failed!',
                requiredFields: 'Заполните поле',
                badTime: 'You have not given a correct time',
                badEmail: 'Некорректный email адрес',
                badTelephone: 'You have not given a correct phone number',
                badSecurityAnswer: 'You have not given a correct answer to the security question',
                badDate: 'Некорректный формат даты',
                lengthBadStart: 'The input value must be between ',
                lengthBadEnd: ' символов',
                lengthTooLongStart: 'Длина поля не может содержать больше ',
                lengthTooShortStart: 'The input value is shorter than ',
                notConfirmed: 'Input values could not be confirmed',
                badDomain: 'Incorrect domain value',
                badUrl: 'The input value is not a correct URL',
                badCustomVal: 'Неправильный формат ввода',
                andSpaces: ' and spaces ',
                badInt: 'Введите положительное число',
                badSecurityNumber: 'Your social security number was incorrect',
                badUKVatAnswer: 'Incorrect UK VAT Number',
                badStrength: 'The password isn\'t strong enough',
                badNumberOfSelectedOptionsStart: 'You have to choose at least ',
                badNumberOfSelectedOptionsEnd: ' answers',
                badAlphaNumeric: 'The input value can only contain alphanumeric characters ',
                badAlphaNumericExtra: ' and ',
                wrongFileSize: 'The file you are trying to upload is too large (max %s)',
                wrongFileType: 'Only files of type %s is allowed',
                groupCheckedRangeStart: 'Please choose between ',
                groupCheckedTooFewStart: 'Please choose at least ',
                groupCheckedTooManyStart: 'Please choose a maximum of ',
                groupCheckedEnd: ' item(s)',
                badCreditCard: 'The credit card number is not correct',
                badCVV: 'The CVV number was not correct'
        };
  	</script>
</head>
<body>
