import React from "react";

function UserStatus(props) {

    return (
        <div>
            현재 사용자는 <b>
            {props.isLogin ? '로그인' : '비로그인'}</b> 상태입니다.
        </div>
    )
}

export default UserStatus;