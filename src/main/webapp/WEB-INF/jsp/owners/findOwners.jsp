<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="owners">

    <h2><fmt:message key="findOwnerMessage"/></h2>

    
    <form:form modelAttribute="owner" action="/owners" method="get" class="form-horizontal"
               id="search-owner-form">
        <div class="form-group">
            <div class="control-group" id="lastName">
                <label class="col-sm-2 control-label"><fmt:message key="lastNameMessage"/></label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="lastName" size="30" maxlength="80"/>
                    <span class="help-inline"><form:errors path="*"/></span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default"><fmt:message key="findMessage"/></button>
            </div>
        </div>

    </form:form>

    <br/>
    <a class="btn btn-default" href='<spring:url value="/owners/new" htmlEscape="true"/>'><fmt:message key="addOwnerMessage"/></a>
</petclinic:layout>
