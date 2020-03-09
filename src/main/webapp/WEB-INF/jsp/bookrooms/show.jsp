<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="bookroom">

    <h2>Information of the book</h2>


    <table class="table table-striped">
        <tr>
            <th>Owner</th>
            <td><b><c:out value="${bookroom.owner.firstName} ${bookroom.owner.lastName}"/></b></td>
        </tr>
        <tr>
            <th>Pet</th>
            <td><c:out value="${bookroom.pet.name}"/></td>
        </tr>
        <tr>
            <th>Start of the book</th>
            <td><c:out value="${bookroom.start}"/></td>
        </tr>
        <tr>
            <th>End of the book</th>
            <td><c:out value="${bookroom.end}"/></td>
        </tr>
    </table>
</petclinic:layout>
