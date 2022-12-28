import React from "react";
import { useCallback } from "react";
import { useState } from "react";
import MainContent from "./MainContent";
import ThemeContext from "./ThemeContext";

function DarkOrLight(props){

    const [theme, setTheme] = useState('light');

    const toggleTheme = useCallback(() => {
        if(theme == 'light'){
            setTheme("dark");
        } else if(theme == 'dark'){
            setTheme("light");
        }
    }, [theme]);

    // context와 공유하고자 하는 데이터
    return (

        <ThemeContext.Provider value={{theme, toggleTheme}}>
            <MainContent/>
        </ThemeContext.Provider>
    )
}

export default DarkOrLight;