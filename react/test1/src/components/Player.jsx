import React from "react";


// 함수 컴포넌트
function Player(props){

    const name = props.playerName
    const number = props.playerNumber

    // element로 만들어 응답 처리
    return (
        <ul>
            <li>선수 이름 : {name} </li>
            <li>선수 번호 : {number} </li>
        </ul>
    )
}

export default Player;