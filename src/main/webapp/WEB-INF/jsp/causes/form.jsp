<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="causes">
    <jsp:body>
        <h2><fmt:message key="createCause"/></h2>
        <c:if test="${error==true}">
        <h4><fmt:message key="errorCause"/></h4>
        </c:if>
        <form:form modelAttribute="cause"
                   class="form-horizontal" action="/cause/save/">
            <div class="form-group has-feedback">
                <petclinic:inputField label="Name" name="name"/>
                <petclinic:inputField label="Description" name="description"/>
                <petclinic:inputField label="Budget target" name="budgetTarget"/>
                <petclinic:inputField label="Organization" name="organization"/>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10"> 
                <input type="hidden" name="id" value="${cause.id}"/>
                      <button class="btn btn-default" type="submit" ><fmt:message key="createCause"/></button>
				</div>
            </div>
        </form:form>
    </jsp:body>
</petclinic:layout>
