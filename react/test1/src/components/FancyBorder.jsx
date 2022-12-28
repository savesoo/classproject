import React from "react";

function FancyBorder(props){

    // 컨테이너 역할 -> children을 전부 가져와 표시함
    return(
        <div className={'border-'+props.color}>
            {props.children}
        </div>
    )
}

export default FancyBorder;