import {createBrowserRouter, Navigate} from "react-router-dom";
import MainPage from "./pages/MainPage";
import AboutPage from "./pages/AboutPage";
import TodoListPage from "./pages/todo/TodoListPage";
import TodoRegisterPage from "./pages/todo/TodoRegisterPage";
import TodoReadPage from "./pages/todo/TodoReadPage";

// 경로 처리를 할 수 있음(하위 경로 설정도 가능)
// route 객체를 요소로 갖는 배열 형태
const routers = createBrowserRouter([
    {
        path: "",
        element: <MainPage></MainPage>
    },
    {
        path: "about", // /about 접속시
        element: <AboutPage></AboutPage> // 화면에 출력
    },
    {
        path: "todo",
        children: [
            {
                path: "list", // todo/list
                element: <TodoListPage></TodoListPage>
            },
            {
                path: "register", // /todo/register
                element: <TodoRegisterPage></TodoRegisterPage>
            },
            {  // /todo 일때의 경로
                path: "",
                element:<Navigate to={"/todo/list"} replace={true} ></Navigate>
            },
            {
                path: ":cmd/:id",
                element: <TodoReadPage></TodoReadPage>
            }
        ]
    }
]);

export default routers;