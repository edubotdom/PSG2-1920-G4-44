<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<petclinic:layout pageName="causes">

    <h2><fmt:message key="infoCauses"/></h2>


    <table class="table table-striped">
        <tr>
            <th><fmt:message key="createCauseName"/></th>
            <td><b><c:out value="${cause.name}"/></b></td>
        </tr>
        <tr>
            <th><fmt:message key="createCauseDescription"/></th>
            <td><c:out value="${cause.description}"/></td>
        </tr>
        <tr>
            <th><fmt:message key="createCauseOrganization"/></th>
            <td><c:out value="${cause.organization}"/></td>
        </tr>
        <tr>
            <th><fmt:message key="createCauseBudgetTarget"/></th>
            <td><c:out value="${cause.budgetTarget}"/></td>
        </tr>
        <tr>
            <th><fmt:message key="causeIsClosed"/></th>
            <td> <c:if test="${cause.isClosed==true}">
                  <p><fmt:message key="causeClosed"/></p>
                </c:if>
                <c:if test="${cause.isClosed==false}">         
                  <p><fmt:message key="causeOpen"/></p>
                </c:if></td>
        </tr>
    </table>
</petclinic:layout>
