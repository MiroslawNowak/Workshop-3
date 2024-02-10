<%@ include file="/header.jsp" %>
<c:forEach items="${users}" var="user">
    <p>${user}</p>
</c:forEach>
<%@ include file="/footer.jsp" %>
