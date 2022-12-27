import React from "react";
import { useState } from "react";


// 화면에 만들 엘리먼트는 버튼이나, 이벤트는 더 상위 컴포넌트 핸들러에서 처리하도록 함!
// 단지 UI 생성 개념
function LoginButton(props){

    // 해당 컴포넌트에 props 통해 함수를 전달받고자 함
    return (
        <button onClick={props.onClick}>
            로그인
        </button>
    )
}

function LogoutButton(props){

    return (
        <button onClick={props.onClick}>
            로그아웃
        </button>
    )
}
// 내부의 props.onClick은 속성의 개념. onClick 말고 다른 함수명을 사용해도 OK



function LoginControl(props){

    const [isLogin, setIsLogin] = useState(false);

    // 핸들러 적용되는 부분
    const handleLoginClick = () =>{
        setIsLogin(true);
    }

    const handleLogoutClick = () =>{
        setIsLogin(false);
    }

    let button;

    if(isLogin){
        button = <LogoutButton onClick={handleLogoutClick}/>
    } else {
        button = <LoginButton onClick={handleLoginClick}/>
    }


    return (
        <>
        {button}
        </>
    )

}

export default LoginControl;