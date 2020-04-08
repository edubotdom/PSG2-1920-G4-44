<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="bookroom">
    <jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#start").datepicker({dateFormat: 'yy/mm/dd'});
                $("#end").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
    <jsp:body>
    
    
    
        <h2><fmt:message key="createBookRoom"/></h2>
        <c:if test="${dateError==true}">
        <h4><fmt:message key="errorDateBookRoom"/></h4>
        </c:if>
        <c:if test="${concurrentError==true}">
        <h5><fmt:message key="errorConcurrentBookRoom"/></h5>
        </c:if>
        <form:form modelAttribute="bookroom"
                   class="form-horizontal" action="/bookroom/save/">
            <div class="form-group has-feedback">
                <petclinic:inputField label="Start Date of the book of the room" name="start"/>
                <petclinic:inputField label="End Date of the book of the room" name="end"/>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10"> 
                <input type="hidden" name="id" value="${bookroom.id}"/>
                <input type="hidden" name="petId" value="${bookroom.pet.id}"/>
                <input type="hidden" name="ownerId" value="${bookroom.owner.id}"/>
                      <button class="btn btn-default" type="submit" ><fmt:message key="createBookRoom"/></button>
				</div>
            </div>
        </form:form>
    </jsp:body>
</petclinic:layout>
