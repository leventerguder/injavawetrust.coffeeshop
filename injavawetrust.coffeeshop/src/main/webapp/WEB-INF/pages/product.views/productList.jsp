<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<spring:url value="/menu" var="mainMenuURL" htmlEscape="true"/>
<spring:url value="/menu/product.detail?productId=" var="productDetailURL" htmlEscape="true"/>
<spring:url value="/product.add" var="adminMenu" htmlEscape="true"/>
<spring:url value="/order.list" var="orderList" htmlEscape="true"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/sidebar.css" />" /> 
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/bootstrap.min.css" />" />
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	
<title><spring:message code='product.shop.name'/></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1><spring:message code='product.shop.name'/></h1>
				<p><spring:message code='product.shop.description'/></p>
			</div>
		</div>
	</section>

   		
	<div id="page-content-wrapper">
	<section class="container">
	
		<div class="row">
			<div class="col-md-6">
				<ul class="nav nav-tabs">
					<li class="">
						<a href="${mainMenuURL}/all">
							<spring:message code='product.products.all'/>
						</a>
					</li>
					<li>
						<a href="${mainMenuURL}/hot">
							<spring:message code='product.hot.beverages'/>
						</a>
					</li>
					<li class="">
						<a href="${mainMenuURL}/cold">
							<spring:message code='product.cold.beverages'/>
						</a>
					</li>
				</ul>
			</div>
			
			<div class="col-md-6">
				<span style="float:right">
				<a href="?language=en" >
					<img src="<c:url value="/resources/images/UK.png" />" />							
				</a>
				|
				<a href="?language=tr">
					<img src="<c:url value="/resources/images/Turkey.png" />" />
					</a>
					
				|
				
				<a href="${adminMenu}">
					<img src="<c:url value="/resources/images/admin.png" />" />
				</a>
				
				<a href="${orderList}">
					<img src="<c:url value="/resources/images/order_icon.png" />" />
				</a>
						

				</span>
			</div>
		</div>
	
		<div class="row">
			<div class="col-md-12">
				<c:forEach items="${products}" var="product">
					<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
						<div class="thumbnail">
							<div class="caption">
								<h3>${product.name}</h3>
								<p>${product.description}</p>
								<p><fmt:formatNumber pattern="#0.00" value="${product.price}"/></p>							
								<p>
									<a
										href="${productDetailURL}${product.id}"
										class="btn btn-primary"> 
										<span class="glyphicon-info-sign glyphicon" /></span>
										<spring:message code='product.details'/>
									</a>
								</p>
	
							</div>
						</div>
					</div>
				</c:forEach>
				
				<c:if test="${empty products}">
					<h2><spring:message code='product.any.product.in.category'/>  </h2>
				</c:if>
				
			</div>	
		</div>
		</section>
		</div>
	</div>
</body>
</html>
