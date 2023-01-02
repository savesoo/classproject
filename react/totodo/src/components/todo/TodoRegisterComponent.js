import React, {useState} from 'react';
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";
import {Button, TextField} from "@mui/material";
import {postTodo} from "../../apis/todoAPI";

function TodoRegisterComponent({setResult}) {

    // 객체를 하나의 상태로 묶음
    const [todo, setTodo] = useState({title: '', writer: '', complete: false});

    // 입력할 값이 많은 경우 하나의 코드로 일괄 처리 가능!
    const changeTodo = (e) => {

        const attr = e.target.name; // 속성 attr=입력되어 있던 값
        const value = e.target.value; // 사용자 입력 값

        todo[attr] = value;

        // 재렌더링을 위한 변경 처리
        setTodo({...todo});

        console.log(todo)

    }

    const clickRegister = async () => {
        // 프로미스 처리
        const result = await postTodo(todo); // todo = 최신의 상태 유지!
        console.log(result);

        setResult(result);
    }

    return (
        <>
            <Typography variant={'h4'} sx={{p:3}}> Todo Register Page </Typography>

            <Box sx={{p:1}}>
                <TextField
                    variant="outlined"
                    fullWidth
                    name={'title'}
                    label={'title'}
                    onChange={(e) => changeTodo(e)}
                ></TextField>
            </Box>
            <Box sx={{p:1}}>
                <TextField
                    variant="outlined"
                    fullWidth
                    name="writer"
                    label="writer"
                    onChange={(e) => changeTodo(e)}
                ></TextField>
            </Box>
            <Box sx={{p:1}} display={"flex"} justifyContent={"right"}>
               <Button variant={"contained"} onClick={clickRegister}>등록</Button>
            </Box>
        </>

    );
}

export default TodoRegisterComponent;