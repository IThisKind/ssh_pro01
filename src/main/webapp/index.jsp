<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.3.1.min.js"></script>
<h1>
    <button id="b"> 获取json数据</button>
    3


    com.oracle.action.EmpActionJson
    <br/>
    <a href="list.jsp">
        <button>查看分页数据</button>
    </a>com.oracle.action.EmpAction
</h1>
</body>
<script>
    $(function () {
        $("#b").click(function () {

            alert("请求");
            $.getJSON("emp-json!getPage", "{'a':1}", function (data) {
                alert(data);
            })

        })

    })

</script>


</html>
