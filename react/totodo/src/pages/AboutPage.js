import React from 'react';
import PageLayout from "../layout/PageLayout";
import {Grid, Paper} from "@mui/material";


// sx : style = { }
// 안에 필요한 컴포넌트 들어있음
function AboutPage(props) {
    return (
        <PageLayout title={'About Page'}>
            <Grid item xs={12} md={12} lg={12}>
                <Paper sx={{p:2, display:'flex',flexDirection: 'column'}}>
                    <h1>About Page</h1>
                </Paper>
            </Grid>
        </PageLayout>
    );
}

export default AboutPage;