import React from "react";

const players = [
    {id: 1, name: '백형훈'},
    {id: 2, name: '류정한'},
    {id: 3, name: '문성일'},
    {id: 4, name: '최재웅'}
];


function TeamPlayers(props){
    
    // return시 인라인 안에서 처리
    return (
        <ul>
            {
                players.map((player, index) => {
                    return <li key={player.id}>{player.name}</li>
                })
            }
        </ul>
    );
}


export default TeamPlayers;