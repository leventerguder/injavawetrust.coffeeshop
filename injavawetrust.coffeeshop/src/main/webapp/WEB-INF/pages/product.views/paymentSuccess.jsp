<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<spring:url value="/order.payment.confirm" var="orderPaymentConfirm" htmlEscape="true"/> 

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title><spring:message code='payment.title'/></title>
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/payment/style.css" />" />
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/payment/reset.css" />" />


</head>
<body>
	<div id="io-page-wrapper">
    	<div id="io-cont-lock">	<img src="<c:url value="/resources/images/payment/lock-blue.png"/>"></div>    	
    	<div id="io-cont-logovisa"><img src="<c:url value="/resources/images/payment/logo-visa.png"/>"></div>
    	<div id="io-cont-logomastercard"><img src="<c:url value="/resources/images/payment/logo-mastercard.png"/>"></div>
    	<div id="io-cont-logoaexpress"><img src="<c:url value="/resources/images/payment/logo-aexpress.png"/>"></div>
        <div class="io-clearbox"></div>
        <p class="io-p-header001">Java Coffee Shop</p>

	
        <form action="${orderPaymentConfirm}" method="post" name="logoform">


            <div id="io-formcont-kartno">
       
            </div>
            <div id="io-formcont-tarih">

            </div>
            <div id="io-formcont-guvenlik">

            </div>
            <div class="io-clearbox"></div>
            <div class="io-infocont"><p class="io-p-info001"></div>
            <div class="io-infocont"><p class="io-p-info001"><spring:message code='payment.result'/> : <span> <spring:message code='payment.succeed'/></span></p></div>
            <div class="io-infocont"><p class="io-p-info001"></div>
            
            <br/>
            <br/>
            <br/>

            
        </form>
        <div class="io-sortpay">
        	<img src="<c:url value="/resources/images/payment/visa.png"/>">
        	<img src="<c:url value="/resources/images/payment/mastercard.png"/>">
        	<img src="<c:url value="/resources/images/payment/americanex.png"/>">
        	<img src="<c:url value="/resources/images/payment/unionpay.png"/>">
        	<img src="<c:url value="/resources/images/payment/unionpay.png"/>">
        	<img src="<c:url value="/resources/images/payment/maestro.png"/>">
        
        </div>
    </div><!-- io-page-wrapper -->

</body>
</html