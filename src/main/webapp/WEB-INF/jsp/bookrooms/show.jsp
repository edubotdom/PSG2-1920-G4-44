<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<petclinic:layout pageName="bookroom">

    <h2>Information of the book</h2>


    <table class="table table-striped">
        <tr>
            <th><fmt:message key="ownerMessage"/></th>
            <td><b><c:out value="${bookroom.owner.firstName} ${bookroom.owner.lastName}"/></b></td>
        </tr>
        <tr>
            <th><fmt:message key="petMessage"/></th>
            <td><c:out value="${bookroom.pet.name}"/></td>
        </tr>
        <tr>
            <th><fmt:message key="startMessage"/></th>
            <td><c:out value="${bookroom.start}"/></td>
        </tr>
        <tr>
            <th><fmt:message key="endMessage"/></th>
            <td><c:out value="${bookroom.end}"/></td>
        </tr>
    </table>
</petclinic:layout>
