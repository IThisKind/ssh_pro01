<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<div>
    <c:if test="${empty page}">
        <c:redirect url="emp_list!getPage"></c:redirect>
    </c:if>
    <table cellpadding="0" cellspacing="0" border="8" width="400">
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>职位</th>
            <th>薪资</th>
        </tr>
        <c:forEach items="${page.data}" var="i">
            <tr>
                <th>${i.empno}</th>
                <th>${i.ename}</th>
                <th>${i.job}</th>
                <th>${i.sal}</th>
            </tr>
        </c:forEach>
    </table>

    <h6>当前页数${page.currPageNo}/共${page.totalPageCount}页</h6>

    <a href="emp_list!getPage?currentPage=${page.currPageNo-1}&size=6">
        上一页
    </a>
    <a href="emp_list!getPage?currentPage=${page.currPageNo+1}&size=6">
        下一页
    </a>

</div>

</body>
</html>
