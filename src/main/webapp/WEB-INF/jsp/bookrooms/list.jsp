<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="bookroom">
    <h2>List of book of rooms</h2>

    <table id="bookroomTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Owner</th>
            <th style="width: 150px;">Pet</th>
            <th style="width: 120px;">Start</th>
            <th style="width: 120px">End</th>
            <th style="width: 120px"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookrooms}" var="bookroom">
            <tr>
               
                <td>
                    <c:out value="${bookroom.owner.firstName} ${bookroom.owner.lastName}"/>
                </td>
                <td>
                    <c:out value="${bookroom.pet.name}"/>
                </td>
                <td>
                    <c:out value="${bookroom.start}"/>
                </td>
                <td>
                     <c:out value="${bookroom.end}"/>
                </td>
                <td>
                     <a href='<spring:url value="/bookroom/${bookroom.id}"/>'> See more</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</petclinic:layout>