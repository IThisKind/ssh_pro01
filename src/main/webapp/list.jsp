<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    page:${page}
    <table cellpadding="0" cellspacing="0" border="8" width="400">
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>职位</th>
            <th>薪资</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${page.data}" var="i">
            <tr>
                <th>${i.empno}</th>
                <th>${i.ename}</th>
                <th>${i.job}</th>
                <th>${i.sal}</th>
                <th>
                    <button><a href=".action?empno=${i.empno}">详情</a></button>
                </th>
                <th>
                    <button><a href=".action?empno=${i.empno}">删除</a></button>
                </th>
            </tr>
        </c:forEach>
    </table>
    <a href="add.jsp">添加</a>

    <h6>当前页数${page.currPageNo}/共${page.totalPageCount}页</h6>

    <button><a href="getPage!getPage?currentPage=${page.currPageNo-1}">上一页</a></button>
    <button><a href="getPage!getPage?currentPage=${page.currPageNo+1}">下一页</a></button>

</div>

</body>
</html>
