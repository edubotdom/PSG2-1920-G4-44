<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="donations">
    <jsp:body>
        <h2><fmt:message key="createDonation"/></h2>
        <c:if test="${error==true}">
        <h4><fmt:message key="errorDonation"/></h4>
        </c:if>
        <form:form modelAttribute="donation"
                   class="form-horizontal" action="/donation/create/${causeId}">
            <div class="form-group has-feedback">
                <label><fmt:message key="amountDonation"/></label><input name="amount"/><br>
             <br>
			<label><fmt:message key="dateDonation"/></label><input name="date"/><br>
			<br>
			<label><fmt:message key="clientDonation"/></label><input name="client"/><br>
			<br>
            </div>
            <div class="form-group">
                <div> 
                <input type="hidden" name="id" value="${donation.id}"/>
                      <button class="btn btn-default" type="submit" ><fmt:message key="createDonation"/></button>
				</div>
            </div>
        </form:form>
    </jsp:body>
</petclinic:layout>