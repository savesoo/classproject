import React from "react";

function NumberList(props){

    const numbers = [11, 22, 33, 44, 55]

    // 배열의 map(callback이 반환하는 값) => 새로운 배열 생성
    const listItems = numbers.map((number, index) => <li key={index}>{number}</li>);

    /* 리액트의 엘리먼트 객체-> [{}, {}, {}, {}, {}] */

    return (
        <ul>
            {listItems}
        </ul>
    )
}

export default NumberList;