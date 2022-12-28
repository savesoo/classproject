import React from "react";
import { useContext } from "react";
import ThemeContext from "./ThemeContext";

function MainContent(props){

    // const color = props.color;
    // ThemeContext에서 공유하는 data를 훅을 이용해 받아옴 {}
    const {theme, toggleTheme} = useContext(ThemeContext);

    // theme에 따라 배경색 변경(흑백)
    return (
        <div style={{
            width: "100vw",
            height: "100vh",
            padding: "1.5rem",
            backgroundColor: theme == 'light' ? "white" : "black",
            color: theme == 'light' ? "black" : "white"
            }}>

            <p>안녕하세요. 테마 변경이 가능한 웹사이트 DOL 입니다!</p>
            <button onClick={toggleTheme}>테마 변경</button>

        </div>
    )
}

export default MainContent;