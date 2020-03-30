<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="causes">
    <h2><fmt:message key="listCauses"/></h2>

	<a class="btn btn-default" href='<spring:url value="/cause/create"></spring:url>'><fmt:message key="createNewCause"/></a>
    <table id="causesTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;"><fmt:message key="createCauseName"/></th>
            <th style="width: 150px;"><fmt:message key="createCauseOrganization"/></th>
            <th style="width: 120px;"><fmt:message key="causeIsClosed"/></th>
            <th></th>
            
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${causes}" var="cause">
            <tr>
               
                <td>
                    <c:out value="${cause.name}"/>
                </td>
                <td>
                    <c:out value="${cause.organization}"/>
                </td>
                <td>
                <c:if test="${cause.isClosed==true}">
                  <p><fmt:message key="causeClosed"/></p>
                </c:if>
                <c:if test="${cause.isClosed==false}">         
                  <p><fmt:message key="causeOpen"/></p>
                </c:if>
                </td>
                <td>
                     <a href='<spring:url value="/cause/${cause.id}"/>'><fmt:message key="seeMore"/></a>
                </td>
                <td>
                     <a href='<spring:url value="/donation/create"></spring:url>'><fmt:message key="createNewDonation"/></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</petclinic:layout>
