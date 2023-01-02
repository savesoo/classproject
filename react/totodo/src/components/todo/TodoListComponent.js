import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {getTodoList} from "../../apis/todoAPI";
import {Table, TableBody, TableCell, TableHead, TableRow} from "@mui/material";

function TodoListComponent({query, moveToRead}) {

    const [todos, setTodos] = useState([]); // 초기값 빈 배열
    const navigate = useNavigate();

    // UI와 상관없이 별도로 통신이 이루어져야 함 -> 갱신시 처리됨
    useEffect(() => {
        getTodoList().then( result => {setTodos(result)} )
    }, [query]);

    return (
        <>
            <Table sx={{minWidth:650}} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell align={"center"}>ID</TableCell>
                        <TableCell align={"center"}>Title</TableCell>
                        <TableCell align={"center"}>Writer</TableCell>
                        <TableCell align={"center"}>Complete</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {todos.map((row) => (
                        <TableRow key={row.id} onClick={() => moveToRead(row.id)}>
                            <TableCell align={"center"}>{row.id}</TableCell>
                            <TableCell align={"center"}>{row.title}</TableCell>
                            <TableCell align={"center"}>{row.writer}</TableCell>
                            <TableCell align={"center"}>{row.complete?'완료':'진행중'}</TableCell>
                        </TableRow>
                    ) )}
                </TableBody>
            </Table>
        </>
    );
}

export default TodoListComponent;