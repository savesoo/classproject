import React from "react";
import { useState } from "react";

function Counter(props){

    //var count = 0;

    const [count, setCount] = useState(0);
    // 0 = count 변수의 초기값
    // setCount = state 값 변경해주는 함수, 실행시 재렌더링

    return(
        <div>
            <p> 총 {count}번 클릭했습니다. </p>
            <button onClick={() => setCount(count+1)}>
            Click
            </button>
        </div>

    )
}

export default Counter;