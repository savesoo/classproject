import React from "react";
import { useState } from "react";
import Details from "./Details";
import Displays from "./Displays";

// 컨트롤러 역할
// 하위 컴포넌트에 전달할 데이터 가짐
// state값을 가지고 이를 하위 컴포넌트에 전달
// state값 변경해주는 함수 하위 컴포넌트로 전달

const itemList = [
    {ino: 1, name: '셔츠', price: 30000},
    {ino: 2, name: '코트', price: 78000},
    {ino: 3, name: '목도리', price: 14000}, 
    {ino: 4, name: '가죽재킷', price: 44000}
];

const style = {
    wrapper : {
        padding:10,
        display:"flex",
        flexDirection:"row",
        justifyContent:"space-around"
    }
};


function Container(props){

    // 선택한 메뉴를 속성으로 저장 -> details로 data 전달
    // selectedItem : {ino: 4, name: '가죽재킷', price: 44000}
    const [selectedItem, setSelectedItem] = useState();

    const changeItem = (ino) => {
        // 상품 번호로 배열에서 상품 검색 -> 해당 객체 반환
        const item = itemList.find( item => item.ino === ino);
        // props로 선택한 상품의 값을 변경
        setSelectedItem(item);
    }

    return (
        <div style={style.wrapper}>
            <Displays arr={itemList} changeItem={changeItem} />
            <Details item={selectedItem} />
        </div>
    );
}

export default Container;