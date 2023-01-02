import React from "react";
import PageLayout from "../../layout/PageLayout";
import {Button, Grid, Paper} from "@mui/material";
import {useNavigate, useSearchParams} from "react-router-dom";
import Typography from "@mui/material/Typography";
import TodoListComponent from "../../components/todo/TodoListComponent";

function TodoListPage(props) {

    // 쿼리스트링 받아서 처리, 상태값 변경
    const [searchParams, setSerachParams] = useSearchParams();

    const navigate = useNavigate();

    const page = searchParams.get("page");
    const size = searchParams.get("size");

    // 두 개의 data를 받아 특정 페이지로 이동 처리
    const clickMove = (page, size) => {
        setSerachParams({page, size});
    };

    const clickRegister = () => {
        navigate("/todo/register");
    };

    const moveToRead = (id) => {
        const pageNum = page || 1 ;
        const sizeNum = size || 10 ;
        // 객체 형식으로 속성 부여
        navigate({
            pathname: `/todo/read/${id}`,
            search: `?page=${pageNum}&size=${sizeNum}`
        });
    };

    // ListComponent로 전달될 값
    const query = {page, size}

    return (
        <PageLayout title={'Todo List Page'}>
            <Grid item xs={12} md={12} lg={12}>
                <Paper sx={{p:2, display:'flex',flexDirection: 'column'}}>
                    <h1>Todo List Page</h1>

                    <TodoListComponent query={query} moveToRead={moveToRead}></TodoListComponent>

                    <Typography variant={'h5'}> page : {page} </Typography>
                    <Typography variant={'h5'}> size : {size} </Typography>
                    <Button onClick={clickRegister}>등록</Button>
                    <Button onClick={() => clickMove(3, 3)}>Move</Button>
                </Paper>
            </Grid>
        </PageLayout>
    );
}

export default TodoListPage;