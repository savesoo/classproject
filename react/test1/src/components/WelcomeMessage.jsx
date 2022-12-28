import React from "react";
import FancyBorder from "./FancyBorder";

function WelcomeMessage(props){

    return (

        // 안쪽에 FancyBorder를 이용해 출력
        <FancyBorder color="red">
            <h1>안녕하세요.</h1>
            <p>Thank you for visiting our website!</p>
        </FancyBorder>
    )
}

export default WelcomeMessage;
