import React from "react";
import { useState } from "react";
import Toolbar from "./Toolbar";

function Mainpage(props){

    // 상위 컴포넌트에서 관리되는 data
    const [isLogin, setIsLogin] = useState(false);

    const onClickLogin = () => {
        setIsLogin(true);
    }

    const onClickLogout = () => {
        setIsLogin(false);
    }

    // 하위 컴포넌트 호출
    return (

        <div>
            <Toolbar
                isLogin={isLogin}
                onClickLogin={onClickLogin}
                onClickLogout={onClickLogout}
            />

            <h3>안녕하세요. 메인 인덱스 페이지입니다.</h3>

        </div>
    )

}

export default Mainpage;