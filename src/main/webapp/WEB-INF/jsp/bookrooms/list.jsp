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
            <th style="width: 150px;"><fmt:message key="ownerMessage"/></th>
            <th style="width: 150px;"><fmt:message key="petMessage"/></th>
            <th style="width: 120px;"><fmt:message key="startMessage"/></th>
            <th style="width: 120px"><fmt:message key="endMessage"/></th>
            
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
                <td>
                     <spring:url value="/bookroom/{bookroomId}/delete" var="deleteBookRoomUrl">
                    <spring:param name="bookroomId" value="${bookroom.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(deleteBookRoomUrl)}"><fmt:message key="deleteBookRoomMessage"/></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</petclinic:layout>
