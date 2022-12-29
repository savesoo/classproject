import React from "react";

// 상위 컴포넌트에서 배열을 받아 List 출력
// 클릭 이벤트에 적용할 핸들러 받아서 적용
// [{ino: 1, name: '상품1', price: 3000}, {ino: 2, name: '상품2', price: 28000'}]
// changeItem : ino 받아 선택 상품의 state 변경 역할
function Displays({arr, changeItem}){

    return (
        <div>
            <ul>
                { arr.map( item => <li key={item.ino} onClick={() => changeItem(item.ino)}>{item.name}</li>) }
            </ul>
        </div>
    );
}

export default Displays;