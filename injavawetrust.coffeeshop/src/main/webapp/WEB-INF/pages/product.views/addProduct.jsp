<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/bootstrap.min.css" />" />
<title><spring:message code='product.shop.name'/></title>
</head>
<body>

<spring:url value="/menu/all" var="menuAll" htmlEscape="true"/> 	

<c:url var="actionURL" value="product.add"/>
	
<c:set var="buttonName">
	<spring:message code='product.add.button'/>
</c:set>
<c:if test="${ !empty update}">
	<c:url var="actionURL" value="product.update"/>
	<c:set var="buttonName">
		<spring:message code='product.update.button'/>
	</c:set>
</c:if>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h1><spring:message code="product.products"/></h1>				
			</div>										
		</div>
	</section>
	
	<section class="container">
		<div class="row">
			<div class="col-md-12">
				<form:form  commandName="newProduct" class="form-horizontal" method="post" action="${actionURL}">
					<fieldset>
						<legend><spring:message code="product.add.newproduct"/>				
						<span style="float:right">
							<a href="?language=en" >
								<img src="<c:url value="/resources/images/UK.png" />" />							
							</a>
							|
							<a href="?language=tr">
								<img src="<c:url value="/resources/images/Turkey.png" />" />
							</a>
							|
							<a href="${menuAll}">
								<img src="<c:url value="/resources/images/icon_home.png" />" />
							</a>						
						</span>
						
					</legend>
	    
					<div class="form-group">
						<label class="control-label col-lg-2" for="name">
							<spring:message code="product.name"/>
						</label>
						<div class="col-lg-10">													
							<form:hidden path="id" />
							<form:input id="name" path="name" type="text" class="form:input-large"/>
							<form:errors path="name" cssClass="text-danger"/>
						</div>
					</div>
	
					<div class="form-group">
						<label class="control-label col-lg-2" for="price">
							<spring:message code="product.price"/>					
						</label>
						<div class="col-lg-10">
							<div class="form:input-prepend">
								<form:input id="price" path="price" type="text" class="form:input-large"/>							
								<form:errors path="price" cssClass="text-danger" cssStyle="display: inline-flex;"/>	
							</div>
						</div>
					</div>
	
					<div class="form-group">
						<label class="control-label col-lg-2" for="description">
							<spring:message code="product.description"/>
						</label>
						<div class="col-lg-10">
							<form:textarea id="description" path="description" rows = "2"/>
						</div>
					</div>
	
	
					<div class="form-group">
						<label class="control-label col-lg-2" for="category">
							<spring:message code="product.category"/>
						</label>
						<div class="col-lg-10">						 
							 <form:select id="type" path="category" type="text" class="form:input-large" items="${productCategories}"/>						 
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2" for="condiment">
							<spring:message code="product.condiment"/>
						</label>
						<div class="col-lg-10">						 
							 <form:select id="condiment" path="condiment" type="text" class="form:input-large">							 	
							 	<form:option value="false"><spring:message code='product.no'/></form:option>
							 	<form:option value="true"><spring:message code='product.yes'/></form:option>
							 </form:select>						 
						</div>
					</div>
					
	 
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">						
							<input type="submit" id="btnAdd" class="btn btn-primary" value ="${buttonName}"/>
						</div>
					</div>								
					
				   </fieldset>
			    </form:form>
		     </div>
	    </div>
		<div class="row">
			<div class="col-md-12">
				<legend><spring:message code="product.list"/></legend>
				<div class="table-responsive">
					<table id="example" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th><spring:message code="product.id"/></th>
								<th><spring:message code="product.name"/></th>
								<th><spring:message code="product.description"/></th>
								<th><spring:message code="product.price"/></th>
								<th><spring:message code="product.category"/></th>
								<th><spring:message code="product.condiment"/></th>
								<th><spring:message code="product.action"/></th>
							</tr>
						</thead>
						<tbody>
					
							<c:forEach items="${allProducts}" var="product">
								<tr>
									<td><c:out value="${product.id}" /></td>
									<td><c:out value="${product.name}" /></td>
									<td><c:out value="${product.description}" /></td>
									<td><fmt:formatNumber pattern="#0.00" value="${product.price}"/></td>
									<td><c:out value="${product.category}" /></td>
									<td><c:out value="${product.condiment}" /></td>								
									<td colspan="2">
										<a href="product.delete?id=${product.id}"
											class="btn btn-danger" type="button">
											<spring:message code="product.delete.button"/>
										</a>
									
										<a href="product.edit?id=${product.id}"
										class="btn btn-warning" type="button">
											<spring:message code="product.edit.button"/>
										</a>
										
									</td>									    
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>					
	</section>
</body>
</html>
