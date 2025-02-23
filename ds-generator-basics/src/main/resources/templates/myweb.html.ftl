<!DOCTYPE html>
<html>
<head>
    <title>网页</title>
</head>
<body>
<h1>欢迎来到freeMarket网页</h1>
<ul>
    <#-- 循环 -->
    <#list menuItems as item>
        <li><a href="${item.url}">${item.label}</a></li>
    </#list>
</ul>
<#--  底部信息  -->
<footer>
    ${currentYear} 网页. All rights reserved.
</footer>


</body>
</html>