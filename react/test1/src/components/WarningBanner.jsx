import React from "react";

function WarningBanner(props){

    // true => 위험, false => 화면에 출력하지 않는 처리
    if(!props.warning){
        return null;
    }

    return (
        <>
            <h1>경고!!!</h1>
        </>
    )
}


export default WarningBanner;