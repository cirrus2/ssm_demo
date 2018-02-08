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

<div class="weui-panel weui-panel_access">
    <div class="weui-panel__hd">列表</div>
    <div class="weui-panel__bd">
        <div class="weui-media-box weui-media-box_small-appmsg">
            <div class="weui-cells">
                <c:forEach items="${list}" var="item">
                    <a href="<%=PATH%>/detail?url=${item.value}" class="weui-media-box weui-media-box_appmsg">
                        <div class="weui-media-box__bd">
                            <h4 class="weui-media-box__title">${item.key}</h4>
                            <p class="weui-media-box__desc">${item.key}</p>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<div class="weui-loadmore">
    <i class="weui-loading"></i>
    <span class="weui-loadmore__tips">正在加载</span>
</div>

<input type="hidden" name="current_page" value="3">
<%@ include file="/WEB-INF/pages/my/footer.jsp" %>

<script>
    $(function () {
        var loading = false;  //状态标记
        $(document.body).infinite().on("infinite", function() {
            if(loading) return;
            loading = true;
            var page = $("input[name=\"current_page\"]").val();
            var html = "";
            $.post("<%=PATH%>/more", {page: page}, function (data) {
                $.each(data, function (k, v) {
                    html += '<a href="<%=PATH%>/detail?url='+v.link+'" class="weui-media-box weui-media-box_appmsg">\n' +
                        '<div class="weui-media-box__bd">\n' +
                        '<h4 class="weui-media-box__title">'+v.title+'</h4>\n' +
                        '<p class="weui-media-box__desc">'+v.title+'</p>\n' +
                        '</div>\n' +
                        '</a>';
                })
                $(".weui-cells").append(html);
                loading = false;
                $("input[name=\"current_page\"]").val(++page)
            }, "json");
        });
    });
</script>

</body>
</html>