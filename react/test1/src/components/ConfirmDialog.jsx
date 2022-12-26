import React from "react";


function Button(props){
    return (
        <button className={`bg-${props.color}`}>
            <b>
                {props.children}
            </b>
        </button>
    )
}


function ConfirmDialog(props){
    return (
        <div>
            <p>내용을 읽고 확인 버튼을 눌러 주세요.</p>
            <Button color="green">확인</Button>
        </div>
    )
}

export default ConfirmDialog;