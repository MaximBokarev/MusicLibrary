<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<ul>
<c:forEach items="${tracks}" var="track">
    <li><a href="tracks/${track.id}">${track.path}</a></li>
    <li><a href="tracks/${track.id}?action=play">play</a></li>
    </c:forEach>
</ul>
</body>
</html>