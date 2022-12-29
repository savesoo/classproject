import React from "react";

// 상위 컴포넌트에서 data 전달받아 출력하는 컴포넌트
function Details({item}){
    
    if(!item) {
        return(
            <div>선택된 상품이 없습니다.</div>
        )
    }

    return (
        <div>
            <h3>상품 번호 : {item.ino}</h3>
            <h3>상품 이름 : {item.name}</h3>
            <h3>상품 가격 : {item.price}</h3>
        </div>
    )
}

export default Details;