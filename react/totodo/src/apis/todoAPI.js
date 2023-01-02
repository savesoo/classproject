import axios from "axios";

// todo 등록
export const postTodo = async (todo) => {
    // todo => {title: '청소', writer: '유', complete:false}
    const res = await axios.post('http://localhost/todos', todo);
    return res.data;
};

// Todo List 전체 출력
export const getTodoList = async () => {
    const res = await axios.get('http://localhost/todos');
    return res.data;
}

// todo 출력
export const getTodo = async (id) => {
    const res = await axios.get(`http://localhost/todos/${id}`);
    return res.data;
}

// todo 삭제
export const deleteTodo = async (id) => {
    const res = await axios.delete(`http://localhost/todos/${id}`);
    return res.data;
}

// todo 수정
export const putTodo = async (todo) => {
    const res = await axios.put(`http://localhost/todos/${todo.id}`, todo);
    return res.data;
}