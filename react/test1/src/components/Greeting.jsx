import React from "react";

function UserGreeting(props){
    
    return(
        <h1>다시 오셨군요!</h1>
    )
}

function GuestGreeting(props){

    return(
        <h1>회원 가입을 해주세요!</h1>
    )
}

function Greeting(props){

    // 전달 받은 값
    const isLogin = props.isLogin;
    
    /*if(isLogin){
        return <UserGreeting />
    }

    return <GuestGreeting />*/


    // 삼항 연산자로 처리 가능!
    return (
        <div>
            {isLogin ? <UserGreeting/> : <GuestGreeting/> }
        </div>
    )
}


export default Greeting;