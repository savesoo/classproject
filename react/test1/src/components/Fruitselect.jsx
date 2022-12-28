import React from "react";
import { useState } from "react";

function Fruitselect(props){

    // 속성과 연결하여 사용
    const [value, setValue] = useState('strawberry'); // 이전 선택값 : 초기값을 props로

    const handleChange = (event) => {
        setValue(event.target.value);
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        alert('선택한 과일 : ' + value);
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>
                과일 선택 : 
                <select value={value} onChange={handleChange}>
                    <option value="apple">사과</option>
                    <option value="strawberry">딸기 </option>
                    <option value="grape">포도</option>
                    <option value="peach">복숭아 </option>
                </select>
            </label>
            <br/>
            <button type="submit">제출</button>
        </form>
    )
}


export default Fruitselect;