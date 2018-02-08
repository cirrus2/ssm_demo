<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/my/common.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <%@ include file="/WEB-INF/pages/my/header.jsp" %>
    <title>${title}</title>
</head>
<body>
<%@ include file="/WEB-INF/pages/my/search.jsp" %>

<div class="weui-msg">
    <div class="weui-msg__text-area">
        <h2 class="weui-msg__title">${title}</h2>
        <p class="weui-msg__desc" style="border-top: 1px solid #ccc;
    margin-top: 10px;
    padding-top: 10px;">
            ${content}
        </p>
    </div>
</div>

<%@ include file="/WEB-INF/pages/my/footer.jsp" %>

</body>
</html>