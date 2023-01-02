import React, {useState} from "react";
import PageLayout from "../../layout/PageLayout";
import {Dialog, DialogTitle, Grid, Paper} from "@mui/material";
import {useNavigate, useParams, useSearchParams} from "react-router-dom";
import Typography from "@mui/material/Typography";
import TodoReadComponent from "../../components/todo/TodoReadComponent";
import TodoModifyComponent from "../../components/todo/TodoModifyComponent";

function TodoReadPage(props) {

    // cmd값에 따라 read와 modify Component를 나눠 처리하도록
    const {cmd, id} = useParams();
    const [msg, setMsg] = useState(null); // state 설정하고 결과에 따라 메시지 처리
    const navigate = useNavigate();
    const [searchParams, setSearchParams] = useSearchParams();

    const page = searchParams.get("page");
    const size = searchParams.get("size");


    const moveToList = () => {
        const pageNum = page || 1 ;
        const sizeNum = size || 10 ;

        navigate({
            pathname: `/todo/list`,
            search: `?page=${pageNum}&size=${sizeNum}`
        });
    };

    const moveToModify = () => {
        const pageNum = page || 1 ;
        const sizeNum = size || 10 ;

        navigate({
            pathname: `/todo/modify/${id}`,
            search: `?page=${pageNum}&size=${sizeNum}`
        });
    };

    const moveToBack = () => {
        const pageNum = page || 1 ;
        const sizeNum = size || 10 ;

        navigate({
            pathname: `/todo/read/${id}`,
            search: `?page=${pageNum}&size=${sizeNum}`
        });
    };

    const setResult = (result) => {
        setMsg(result);
    }

    const closeAndMove = () => {
        setMsg(null);

        navigate("/todo/list");
    }

    const getComponent = () => {
        if(cmd === 'read'){
            return <TodoReadComponent id={id} setResult={setResult} moveToList={moveToList} moveToModify={moveToModify}></TodoReadComponent>;
        } else if(cmd === 'modify'){
            return <TodoModifyComponent id={id} setResult={setResult} moveToList={moveToList} moveToBack={moveToBack}></TodoModifyComponent>;
        }
        return <></>
    }


    return (
        <PageLayout title={'Todo Read Page'}>
            <Grid item xs={12} md={12} lg={12}>
                <Paper sx={{p:2, display:'flex',flexDirection: 'column'}}>
                    {getComponent(id)}
                </Paper>
            </Grid>

            {/*msg가 null이 아니면 open-dialog 출력*/}
            <Dialog open={msg!==null}
                    onClose={closeAndMove}
                    aria-labelledby="alert-dialog-title"
                    aria-describedby="alert-dialog-description"
                    id="alert-dialog-title"
            >
                <DialogTitle>처리 결과</DialogTitle>
                <Typography variant={'h6'}> {msg} </Typography>
            </Dialog>
        </PageLayout>
    );
}

export default TodoReadPage;