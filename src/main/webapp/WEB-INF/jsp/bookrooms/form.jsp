<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="bookroom">
    <h2>
        <c:if test="${bookroom['new']}"><fmt:message key="newMessage"/> </c:if><fmt:message key="ownerMessage"/></h2>
        
    <form:form modelAttribute="bookroom" class="form-horizontal" id="add-room-form">
        <div class="form-group has-feedback">
            <petclinic:inputField label="Start of the book" name="start"/>
            <petclinic:inputField label="End of the book" name="end"/>
            <petclinic:inputField label="Pet" name="mascota"/>
            <petclinic:inputField label="Owner" name="propietario"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${bookroom['new']}">
                        <button class="btn btn-default" type="submit"><fmt:message key="addOwnerMessage"/></button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit"><fmt:message key="updateOwnerMessage"/></button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</petclinic:layout>
