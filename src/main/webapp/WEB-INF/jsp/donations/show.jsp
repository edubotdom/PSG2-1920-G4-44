<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<petclinic:layout pageName="donations">

    <h2><fmt:message key="infoDonations"/></h2>


    <table class="table table-striped">
        <tr>
            <th><fmt:message key="createDonationClient"/></th>
            <td><b><c:out value="${donation.client}"/></b></td>
        </tr>
        <tr>
            <th><fmt:message key="createDonationAmount"/></th>
            <td><c:out value="${donation.amount}"/></td>
        </tr>
        <tr>
            <th><fmt:message key="createDonationDate"/></th>
            <td><c:out value="${donation.date}"/></td>
        </tr>
        <tr>
            <th><fmt:message key="createDonationCause"/></th>
            <td><c:out value="${donation.cause.name}"/></td>
        </tr>
    </table>
</petclinic:layout>