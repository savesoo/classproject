import React from "react";
import { useState } from "react";
import Dialog from "./Dialog";


let room = [];

function SignUpDialog(props){

    const [nickname, setNickname] = useState('');

    const handleClick = (event) => {
        alert(`어서오세요, ${nickname}님!`);
        room.push(nickname); // 배열에 넣어줌
        setNickname(''); // input 공백으로 변경해줌
    }

    return (
        <Dialog title="프로젝트 팀 참여" message="닉네임을 입력해 주세요.">
            <input type="text" 
                    value={nickname} 
                    onChange={(event)=>{
                        setNickname(event.target.value);
                    }} />
            <button onClick={handleClick}>참여하기</button>
            <div>
                {room.map((name, index) => {
                    return <p key={index}> {name} </p>
                })}
            </div>
        </Dialog>
    )
}

export default SignUpDialog;