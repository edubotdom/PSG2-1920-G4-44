<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="vets">
    <jsp:body>
        <h2>
            <fmt:message key="vet"/>
        </h2>
        <form:form modelAttribute="vet"
                   class="form-horizontal"
                   action="/vets/{vetId}/save">
            <input type="hidden" name="id" value="${vet.id}"/>
            <div class="form-group has-feedback">
                <petclinic:inputField label="Name" name="firstName"/>
                <petclinic:inputField label="Surname" name="lastName"/>
               <div class="control-group">
                    <petclinic:selectField name="specialties" label="Specialties" names="${specialties}" size="5"/>
                </div>
            </div>
            <button class="btn btn-default" type="submit"><fmt:message key="edit"/></button>
        </form:form>
    </jsp:body>
</petclinic:layout>
