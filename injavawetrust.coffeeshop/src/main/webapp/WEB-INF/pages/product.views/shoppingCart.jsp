<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title><spring:message code='product.shop.name'/></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1><spring:message code='product.shop.name'/></h1>
			</div>
		</div>
	</section>
		
	<spring:url value="/menu/product.detail" var="menuBack" htmlEscape="true"/> 
	<spring:url value="/menu/order.delete.from.cart" var="orderDeleteFromCartURL" htmlEscape="true"/>
	<spring:url value="/menu/all" var="menuAllURL" htmlEscape="true"/> 
	<spring:url value="/order.payment" var="productPayment" htmlEscape="true"/> 		
		
	<section class="container">
		<div class="row">	
			<c:forEach items="${calculatedPrices}" var="prices" varStatus="count">
				<div class="row">
					<div class="col-md-6">
						<div class="col-md-12">	
							<div class="thumbnail">
								<div class="caption">																				
								
									<h4>
										<spring:message code='product.name'/> : 
										<span class="label label-info">${products[(prices.key).intValue()].name}</span>
									</h4>
									
									<p>
										<spring:message code='product.id'/> :
										<span>${products[(prices.key).intValue()].id}</span>
									</p>
									<p>
										<spring:message code='product.description'/>: 
										<span>${products[(prices.key).intValue()].description}</span>
									</p>
														
									</p>
										<spring:message code='product.price'/> :
										<strong><span class="label label-info">
											<fmt:formatNumber pattern="#0.00" value="${products[(prices.key).intValue()].price}"/>
										</span></strong>
									</p>	
										
									<h4>
										<spring:message code="product.price.total.by.productId"/> : 						
										<span class="label label-info">									
											<fmt:formatNumber pattern="#0.00" value="${prices.value}"/>
										</span>
									</h4>										      					    			
									
									<a href="${menuBack}?productId=${products[(prices.key).intValue()].id}" class="btn btn-default btn-md"> 
										<span class="glyphicon-info-sign glyphicon"></span> 
										<spring:message code='product.menu.back.to.detail'/> 
									</a>

					      			<a href="${orderDeleteFromCartURL}?productId=${products[(prices.key).intValue()].id} " class="btn btn-danger btn-md"> 
										<span class="glyphicon glyphicon-remove"></span> <spring:message code='product.remove.from.cart'/> 
									</a>									
																																														      									
								</div>
							</div>						
						</div>									
					</div>										
				</div>															
			</c:forEach>
		
			<div class="row">
				<div class="col-md-6">
					<div class="col-md-12">	
						<div class="thumbnail">
							<div class="caption">
											
							<h4>
								<spring:message code='product.price.total.all'/> : 
								<span class="label label-info">																
									<fmt:formatNumber pattern="#0.00" value="${totalAll}"/>
								</span>																
							</h4>																	
							
							<h4>
						
							<c:if test="${reducedPrice ne totalAll}">
								<spring:message code='product.price.reduced.all'/> : 
									<span class="label label-info">
										<fmt:formatNumber pattern="#0.00" value="${reducedPrice}"/>
								</span>	
							</c:if>		
																		
							</h4>
							
							<c:if test="${totalAll !=0 }">
															
								<form action="${productPayment}" method="POST">							  							  
								  	<input type="submit" value="<spring:message code='product.confirm'/> " class="btn btn-success">
								  	<input type="hidden" value="${reducedPrice}">						  
								</form>		
								
							</c:if>
							<a href="${menuAllURL}" class="btn btn-default btn-md"> 
								<span class="glyphicon-hand-left glyphicon"></span> 
								<spring:message code='product.menu.back'/> 
							</a>
																																				      								
							</div>
						</div>						
					</div>
												
				</div>
			</div>	
		</div>		
	</section>
		
</body>
</html>
