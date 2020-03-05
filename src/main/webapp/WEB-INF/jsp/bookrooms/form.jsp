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
        <h2>Create book for a room</h2>
        <form:form modelAttribute="bookroom"
                   class="form-horizontal" action="/bookroom/save">
            <div class="form-group has-feedback">
				<petclinic:inputField label="Name" name="name"/>
                <petclinic:inputField label="Pet" name="mascota"/>
                <petclinic:inputField label="Start Date of the book of the room" name="start"/>
                <petclinic:inputField label="End Date of the book of the room" name="end"/>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10"> 
                <input type="hidden" name="id" value="${bookroom.id}"/>
                      <button class="btn btn-default" type="submit">Create book</button>
				</div>
            </div>
        </form:form>
    </jsp:body>
</petclinic:layout>
