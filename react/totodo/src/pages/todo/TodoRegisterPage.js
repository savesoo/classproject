import React, {useState} from "react";
import PageLayout from "../../layout/PageLayout";
import {Dialog, DialogTitle, Grid, Paper} from "@mui/material";
import TodoRegisterComponent from "../../components/todo/TodoRegisterComponent";
import {useNavigate} from "react-router-dom";
import Typography from "@mui/material/Typography";

function TodoRegisterPage(props) {

    const [msg, setMsg] = useState(null); // state 설정하고 결과에 따라 메시지 처리
    const navigate = useNavigate();

    const setResult = (result) => {
        setMsg(result);
    }

    // msg 닫히면 list로 이동
    const closeAndMove = () => {
        setMsg(null);

        navigate("/todo/list");
    }

    // Component로 전달됨
    return (
        <PageLayout title={'Todo Register Page'}>
            <Grid item xs={12} md={12} lg={12}>
                <Paper sx={{p:2, display:'flex',flexDirection: 'column'}}>
                    <TodoRegisterComponent setResult={setResult}></TodoRegisterComponent>
                </Paper>
            </Grid>

            {/*msg가 null이 아니면 open-dialog 출력*/}
            <Dialog open={msg!==null}
                    onClose={closeAndMove}
                    aria-labelledby="alert-dialog-title"
                    aria-describedby="alert-dialog-description"
                    id="alert-dialog-title"
            >
                <DialogTitle>등록 결과</DialogTitle>
                <Typography variant={'h6'}> 할일 등록 완료</Typography>
            </Dialog>
        </PageLayout>
    );
}

export default TodoRegisterPage;