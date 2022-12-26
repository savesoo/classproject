import React from "react";
import Player from "./Player";

// 컴포넌트에서 다른 컴포넌트 이용하기
function Team(props){

    return (
        <div>

            <Player playerName='SON' playerNumber='7'></Player>
            <Player playerName='LEE' playerNumber='20'></Player>
            <Player playerName='PARK' playerNumber='9'></Player>

        </div>
    )
}

export default Team;