import React from "react";

function Mailbox(props){

    /*
    {unreadMessage : [{}, {}, {}, {}, {}, {}, {}] }
    */

    // props.unreadMessage => [] 배열 형태

    const unreadMessage = props.unreadMessage;

    return (
        <div>
            <h1> Mail Box </h1>

            { unreadMessage.length > 0 &&
            <h3>현재 {unreadMessage.length}개의 읽지 않은 메시지가 있습니다.</h3> }
            
        </div>
    )
}

export default Mailbox;