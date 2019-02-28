<html>
<body>
<h2>Hello World!</h2>
<script src="js/jquery-3.3.1.min.js"></script>
<h1>
    <button id="b"> 获取json数据 com.oracle.action.EmpActionJson</button>
    <br/>
    <button><a href="list.jsp">查看分页数据</a>com.oracle.action.EmpAction</button>
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
