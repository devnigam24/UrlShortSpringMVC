<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<NullTag id="someID">${longUrlToGo}</NullTag>

<script type="text/javascript">
window.location.href = document.getElementById("someID").innerHTML.trim();
</script>