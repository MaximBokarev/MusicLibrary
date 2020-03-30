<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<ul>
<c:forEach items="${playlists}" var="playlist">
    <li><a href="playlist/${playlist.id}">${playlist.name}</a></li>
</c:forEach>
</ul>
</body>
</html>