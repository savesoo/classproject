import React from "react";
import { useRef } from "react";

function TextInputButton(props){

    const inputEl = useRef(null);

    const onButtonClick = () => {

        // current는 연결된 객체 input을 가리킴
        inputEl.current.focus();
        inputEl.current.value='new Message'; // value값 지정 가능

    }

    // 클릭시 처리될 이벤트
    // input과 연결(마운트)한 것!
    return(
        <div>
            <input ref={inputEl} type="text" />
            <button onClick={onButtonClick}>클릭!</button>
        </div>
    )

}

export default TextInputButton;