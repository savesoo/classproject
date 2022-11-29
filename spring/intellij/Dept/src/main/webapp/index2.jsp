<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index2</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<%--
<script>

    console.log(1);
    console.log(2);
    setTimeout(()=> console.log(3), 1000);
    console.log(4);

</script>
--%>



<%--<script>--%>

<%--    const xhr = new XMLHttpRequest();--%>
<%--    //xhr.open('get', 'https://jsonplaceholder.typicode.com/todos/1');--%>
<%--    xhr.open('get', '/api/v1/depts/10');--%>
<%--    xhr.send();--%>

<%--    &lt;%&ndash; 콜백함수 사용 &ndash;%&gt;--%>
<%--    xhr.onreadystatechange = () => {--%>

<%--        &lt;%&ndash; 완료되지 않았다면 return &ndash;%&gt;--%>
<%--        if(xhr.readyState !== XMLHttpRequest.DONE){--%>
<%--            return;--%>
<%--        }--%>

<%--        if(xhr.status === 200) {--%>
<%--            console.log(JSON.parse(xhr.response));--%>
<%--            &lt;%&ndash; 응답 안에 데이터 받아오기. 그냥 출력하면 JSON형식(문자열)이므로 parse 사용 &ndash;%&gt;--%>
<%--        } else {--%>
<%--            console.log("error", xhr.status, xhr.statusText ); &lt;%&ndash; 오류 나면 상태코드값 반환 &ndash;%&gt;--%>
<%--        }--%>

<%--    }--%>


<%--</script>--%>

<script>

    const request = {
        get(url) {
            return fetch(url);
        },
        post(url, payload) {
            return fetch(url, {
                method : 'POST',
                headers : { 'content-Type' : 'application/json'},
                body : JSON.stringify(payload);
            })
        },
        put(url, payload) {
            return fetch(url, {
                method: 'PUT',
                headers: {'content-Type': 'application/json'},
                body: JSON.stringify(payload);
            })
        },
        delete(url){
            return fetch(url, {method : 'DELETE'});
        }
    }

    request.get('/api/v1/depts/150')
        .then(response => {
            if (!response.ok){
                throw new Error(response.statusText);
            }

            return response.get('/api/v1/depts/10'); <%--여기 응답이 promise이므로 다음 then에는 이 값 반영 --%>
        })
        .then(response => {
            if (!response.ok){
                throw new Error(response.statusText);
            }

            return response.json();
        })
        .then(list => console.log(list))
        .catch(err => console.log(err));


</script>



</body>
</html>