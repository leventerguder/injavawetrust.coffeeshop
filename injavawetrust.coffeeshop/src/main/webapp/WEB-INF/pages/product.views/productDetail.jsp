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
	
	<spring:url value="/menu/product.add.to.cart" var="addToCartURL" htmlEscape="true"/>
	<spring:url value="/menu/all" var="menuAllURL" htmlEscape="true"/> 		
	<spring:url value="/menu/product.delete.all.cart" var="productDeleteAllCartURL" htmlEscape="true"/>
	<spring:url value="/menu/product.delete.from.cart" var="productDeleteFromCartURL" htmlEscape="true"/>
	<spring:url value="/menu/product.delete.condiment" var="productDeleteCondiment" htmlEscape="true"/>
	<spring:url value="/menu/product.add.condiment" var="productAddCondiment" htmlEscape="true"/>
	<spring:url value="/menu/product.shopping.cart" var="productGoToShoppingCart" htmlEscape="true"/>
	
	 
	<c:set var="shoppingCartByProductId" scope="session" value="${shoppingCart[(product.id).intValue()]}"/> 
	<c:set var="allCondimentsByProductId" scope="session" value="${allCondiments[(product.id).intValue()]}"/>
	
	<section class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="col-md-12">
					<h4>
						<spring:message code='product.name'/> : 
						<span class="label label-info">${product.name}</span>
					</h4>				
					<p>
						<spring:message code='product.id'/> :
						<span>${product.id}</span>
					</p>
					<p>
						<spring:message code='product.description'/>: 
						<span>${product.description}</span>
					</p>
										
					<p>
						<spring:message code='product.price'/> :
						<strong><span class="label label-info">
							<fmt:formatNumber pattern="#0.00" value="${product.price}"/>
						</span></strong>
					</p>
					<p>																					
					
					<a href="${addToCartURL}" class="btn btn-default btn-sm"> 
						<span class="glyphicon-shopping-cart glyphicon"></span>
						<spring:message code='product.add.to.cart'/>  
					</a>
														
					<a href="${menuAllURL}" 
						class="btn btn-default btn-sm"> 
						<span class="glyphicon-hand-left glyphicon"></span> 
						<spring:message code='product.menu.back'/> 
					</a>
					
					<a href="${productDeleteAllCartURL}"
						class="btn btn-danger btn-sm"> 
					<span class="glyphicon glyphicon-remove"></span> 
					<spring:message code='product.remove.all'/> 
					</a>
																			
					</p>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="col-md-12">
																																				
					<a href="${productGoToShoppingCart}" class="btn btn-success btn-sm"> 
						<span class="glyphicon-shopping-cart glyphicon"></span>
						<spring:message code='product.go.to.cart'/>  
					</a>
																			
					
				</div>
			</div>
				
		</div>						
		
		<%--			
			shoppingCartByProductId  TreeMap<Integer, Product>
			orderIndexProduct Product
		--%>
		<c:forEach items="${shoppingCartByProductId}" var="orderIndexProduct">
			<div class="row">
				<div class="col-md-4">
					<div class="col-md-12">	
						<div class="thumbnail">
							<div class="caption">
							
								<p>
									<spring:message code='product.name'/> : 
									<span>${product.name}</span>
								</p>
								
								<p>
									<spring:message code='product.price'/> : 						
									<span class="label label-info">									
										<fmt:formatNumber pattern="#0.00" value="${orderIndexProduct.value.price}"/>
									</span>
								</p>
										      					    			
				      			<a href="${productDeleteFromCartURL}?indexId=${orderIndexProduct.key} " class="btn btn-danger btn-sm"> 
									<span class="glyphicon glyphicon-remove"></span> <spring:message code='product.remove.from.cart'/> 
								</a>
														      									
							</div>
						</div>						
					</div>
									
				</div>
				
				<div class="col-md-4">
					<div class="col-md-12">	
						<div class="thumbnail">
							<div class="caption">
																																															
								<c:forEach items="${orderIndexProduct.value.condimentsInProduct}" var="current">
								
									<p>
									  ${current.key.name} 									  
									  <fmt:formatNumber pattern="#0.00" value="${current.key.price}"/>									  									  								  									  									 
									  X ${current.value}	
										<a href="${productDeleteCondiment}?indexId=${orderIndexProduct.key}&condimentId=${current.key.id}" id="deleteCondiment"
										class="btn btn-danger btn-xs"> 
										<span class="glyphicon glyphicon-remove"></span> <spring:message code='product.remove.from.cart'/> 
										</a>
									   
									</p>
									
								 </c:forEach>																
																																									
								  <div class="form-group">										
										<select class="form-control" id="condiment${orderIndexProduct.key}" id="condiment${orderIndexProduct.key}" >
											<c:forEach items="${allCondimentsInShop}" var="element">										  
											 	<option value="${element.value.id}" name="${element.value.name}"> 
											 		${element.value.name} ,
											 		
											 		<fmt:formatNumber pattern="#0.00" value="${element.value.price}"/>
											 		 
											 	</option>
											 </c:forEach>				
										</select>
								  </div>
																
								   <a  href="${productAddCondiment}?indexId=${orderIndexProduct.key}" onclick="addCondimentFunction(this)"  id="addCondiment${orderIndexProduct.key}" 
								   name="${orderIndexProduct.key}"
								   class="btn btn-default btn-sm"> 
										<span class="glyphicon glyphicon-plus"></span> 
										<spring:message code='product.add.condiment'/> 
								   </a>
								
								</form>
			      			</div>
						</div>
					</div>							
				</div>			
			</div>	
			
											
		</c:forEach>		
	</section>
	
	<script type="text/javascript">
	function addCondimentFunction(obj){
		
		var link= obj.id;
		var value=obj.name;
		var e = document.getElementById('condiment'+value);
		var selected = e.options[e.selectedIndex].value;
			
		obj.href=obj.href+"&condimentId="+selected;

	}
	
	</script>
	
</body>
</html>
