<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>

<div class="weui-footer" style="padding: 20px 0;">
    <p class="weui-footer__text">Copyright © <%=new Date()%></p>
</div>

<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>

<script src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/swiper.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/city-picker.min.js"></script>

<script src="https://cdn.bootcss.com/jquery_lazyload/1.9.7/jquery.lazyload.min.js"></script>

<script>
    $(function () {
        $("img.lazy").lazyload();
        $("img.lazy").css("width", "100%");
        $("img.lazy").css("height", "auto");
    });
</script>