<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<ul>
<c:forEach items="${plalist}" var="plalist">
    <li><a href="playlist/${playlis.id}">${playlist.name}</a></li>
</c:forEach>
</ul>
</body>
</html>