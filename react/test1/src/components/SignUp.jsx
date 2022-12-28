import React from "react";
import { useState } from "react";

function SignUp(props){

    const [name, setName] = useState('');
    const [gender, setGender] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        alert(`이름 : ${name}, 성별: ${gender}`)
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>
                이름 :
                <input 
                    type="text" 
                    value={name} 
                    onChange={(event) => {
                        setName(event.target.value);
                    }}
                /> 
            </label>
            <br/>
            <label>
                성별 : 
                <select 
                    value={gender} 
                    onChange={(event) => {
                        setGender(event.target.value);
                }}>
                    <option value="male">남자</option>
                    <option value="female">여자</option>
                </select> 
            </label>
            <br/>
            <button type="submit">제출</button>
        </form>
    )
}

export default SignUp;