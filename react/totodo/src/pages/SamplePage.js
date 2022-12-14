import React from 'react';
import SampleLayout from "../layout/SampleLayout";
import Ex1 from "../components/ex/Ex1";
import PageLayout from "../layout/PageLayout";
import {Grid, Paper} from "@mui/material";


// sx : style = { }
// 안에 필요한 컴포넌트 들어있음
function SamplePage(props) {
    return (
        <PageLayout title={'Sample Page'}>
            <Grid item xs={12} md={12} lg={12}>
                <Paper sx={{p:2, display:'flex',flexDirection: 'column'}}>
                    <h1>페이지의 컨텐츠 내용이 들어갑니다.</h1>
                    <Ex1/>
                </Paper>
            </Grid>
        </PageLayout>
    );
}

export default SamplePage;