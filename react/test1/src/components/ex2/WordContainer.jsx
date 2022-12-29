import React from "react";
import { useState } from "react";
import WordInput from "./WordInput";
import WordList from "./WordList";

const style = {
    wrapper : {
        padding:10,
        display:"flex",
        flexDirection:"row",
        justifyContent:"space-around"
    }
};

function WordContainer(props){

    // word 데이터를 가지는 배열을 state로 관리
    const [words, setWords] = useState(['OPERA', 'SPRING', 'HEAVEN']);


    // 단어 추가
    const addWord = (word) => {
        // 배열에 단어 추가 + set
        //words.push(word);
        // ...words : 배열이 원래 가진 요소 불러옴 ['OPERA', 'SPRING', 'HEAVEN']
        setWords([...words, word]);
    }


    // 단어 삭제
    const removeWord = (word) => {
        // 배열에서 매개변수로 받은 요소 삭제 : ['OPERA', 'SPRING' ]
        // 배열.filter(true/false) -> 괄호 내부의 결과에 따라 새로운 배열 생성
        // 전달된 요소와 같은 요소를 제외하고 새로운 배열 생성하기 = 삭제 효과
        const filteredWords = words.filter( w => w !== word );
        setWords([...filteredWords]);
    };

    return (

        <div style={style.wrapper}>
            <WordInput addWord={addWord} />
            <WordList words={words} removeWord={removeWord} />
        </div>
    )


};

export default WordContainer;
