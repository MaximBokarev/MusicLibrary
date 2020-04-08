<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<ul>
<c:forEach items="${tracks}" var="track">
    <li><a href="tracks/${track.id}?action=play">${track.name} &nbsp; play</a></li>
    </c:forEach>
</ul>
</body>
</html>