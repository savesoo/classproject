import React from "react";
import { useState } from "react";

// 단어를 state로 관리하는 배열에 추가
function WordInput({addWord}){

    const [text, setText] = useState('');

    const handleAddWord = () => {
        addWord(text);
        setText('');
    }

    return (
        <div>
            <input 
                value={text} 
                onChange={(event)=> setText(event.target.value)} 
            />
            <button onClick={handleAddWord}>단어 추가</button>
        </div>
    );

};

export default WordInput;