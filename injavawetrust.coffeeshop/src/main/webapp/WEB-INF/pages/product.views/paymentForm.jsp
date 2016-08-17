<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

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

        
        <form:form  commandName="paymentFormData"  method="post" action="${orderPaymentConfirm}">

			<div id="io-formcont-kartno">
            	<label><spring:message code='payment.card.holder'/></label>            	               
                <form:input id="customerName" path="customerName" type="text" class="io-inputstyle" maxlength="20"/>
            </div>
            
            <div class="io-clearbox"></div>
            
            <div id="io-formcont-kartno">
            	<label><spring:message code='payment.card.number'/></label>                
                <form:input id="cardNumber" path="cardNumber" type="text" class="io-inputstyle" maxlength="20"/>
            </div>
            <div id="io-formcont-tarih">
            	<label><spring:message code='payment.expiry.date'/></label>
            	<form:select id="io-input-ay" path="month" name="month" type="text" class="io-inputstyle">            	            	                
                    <form:option value="01">01</form:option>
                    <form:option value="02">02</form:option>
                    <form:option value="03">03</form:option>
                    <form:option value="04">04</form:option>
                    <form:option value="05">05</form:option>
                    <form:option value="06">06</form:option>
                    <form:option value="07">07</form:option>
                    <form:option value="08">08</form:option>
                    <form:option value="09">09</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="11">11</form:option>
                    <form:option value="12">12</form:option>                
                </form:select>
                
                <form:select path="year" class="io-inputstyle" id="io-input-yil" name="year" >
                    <form:option value="17">2017</form:option>
                    <form:option value="18">2018</form:option>
                    <form:option value="19">2019</form:option>
                    <form:option value="20">2020</form:option>
                    <form:option value="21">2021</form:option>
                </form:select>
            </div>
            <div id="io-formcont-guvenlik">
            	<label><spring:message code='payment.security.code'/></label>
                <table width="130" cellpadding="0" cellspacing="0" border="0">
                	<tr>
                    	<td>
                    		<form:input id="io-input-guvenlik" path="cvv" type="text" class="io-inputstyle" name="cvv"/>
                    	</td>
                		<td align="right" valign="bottom">
                			<img src="<c:url value="/resources/images/payment/img-cardback.png"/>">                			
                		</td>
                	</tr>
                </table>
            </div>
            <div class="io-clearbox"></div>
             <div class="io-infocont"><p class="io-p-info001"><spring:message code='order.total'/> : <span>${calculatedAmount} TL</span></p></div>
            <div class="io-infocont"><p class="io-p-info001"></p></div>
            <div class="io-infocont io-alignright io-mobilecenter"><input type="submit" value="<spring:message code='payment.submit'/>" class="io-submitstyle"></div>

            
        </form:form>

        <div class="io-clearbox"></div>
        <div class="io-seperator">
        	<div class="io-seperator-line"></div>
            <div class="io-seperator-text"><span></span></div>
        </div>
        <div class="io-sortpay">
                                    	

        </div>
        <div class="io-sortpay">
        	<img src="<c:url value="/resources/images/payment/visa.png"/>">
        	<img src="<c:url value="/resources/images/payment/mastercard.png"/>">
        	<img src="<c:url value="/resources/images/payment/americanex.png"/>">
        	<img src="<c:url value="/resources/images/payment/unionpay.png"/>">
        	<img src="<c:url value="/resources/images/payment/unionpay.png"/>">
        	<img src="<c:url value="/resources/images/payment/maestro.png"/>">
        
        </div>
    </div>

</body>
</html