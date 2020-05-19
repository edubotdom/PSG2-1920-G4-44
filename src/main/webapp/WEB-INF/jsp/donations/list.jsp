<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="donations">
    <h2><fmt:message key="listDonations"/></h2>

    <table id="DonationsTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;"><fmt:message key="donationCause"/></th>
            <th style="width: 150px;"><fmt:message key="donationAmount"/></th>
            <th style="width: 120px;"><fmt:message key="donationDate"/></th>
            <th style="width: 120px;"><fmt:message key="budgetTarget"/></th>
            <th></th>
            
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${donations}" var="donation">
            <tr>
               
                <td>
                    <c:out value="${donation.cause.name}"/>
                </td>
                <td>
                    <c:out value="${donation.amount}"/>
                </td>
                <td>
                	<c:out value="${donation.date}"></c:out>
                </td>
                <td>
                	<c:out value="${donation.cause.budgetTarget}"/>
                </td>
                <td>
                     <a href='<spring:url value="/donation/${donation.id}"/>'><fmt:message key="seeMore"/></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</petclinic:layout>