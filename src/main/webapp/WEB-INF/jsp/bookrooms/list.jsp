<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="bookroom">
    <h2><fmt:message key="ownersMessage"/></h2>

    <table id="bookroomTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Owner</th>
            <th style="width: 150px;">Pet</th>
            <th style="width: 120px;">Start</th>
            <th style="width: 120px">End</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${selections}" var="bookroom">
            <tr>
                <!-- <td>
                    <spring:url value="/bookroom/{bookroomId}" var="bookroomUrl">
                        <spring:param name="bookroomId" value="${bookroom.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(bookroomUrl)}"><c:out value="${bookroom.owner} ${bookroom.pet}"/></a>
                </td>
                 -->
                <td>
                    <c:out value="${bookroom.propietario}"/>
                </td>
                <td>
                    <c:out value="${bookroom.mascota}"/>
                </td>
                <td>
                    <c:out value="${bookroom.start}"/>
                </td>
                <td>
                     <c:out value="${bookroom.end}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</petclinic:layout>
