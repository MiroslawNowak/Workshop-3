<%@ include file="/header.jsp" %>
<p>Lista użytkowników</p>
<c:forEach items="${users}" var="user">
    <p>${user}</p>
</c:forEach>
<%@ include file="/footer.jsp" %>
