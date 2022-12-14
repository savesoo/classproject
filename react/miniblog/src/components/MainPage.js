import React from 'react';
import styled from "styled-components";

// 컴포넌트 생성 -> 대문자!
const Wrapper = styled.div`
    padding: 1em;
    background-color: gray;
    display: flex;
    flex-direction: row;
    align-items: flex-start;
`;

const Block = styled.div`
    padding: ${props => props.padding};
    border: 1px solid black;
    border-radius: 1rem;
    background-color: ${props => props.backColor};
    color: white;
    font-size: 2rem;
    font-weight: bold;
    text-align: center;
`;

const Title = styled.h1`
    font-size: 150%;
    color: white;
    text-align: center;
`;

const Button = styled.button`
    color: ${props => props.dark ? "white" : "black"};
    background-color : ${props => props.dark ? "black" : "white"};
    border : 3px solid black;
    margin: 10px;
    padding: 5px;
`;

// 기존 속성에 스타일 추가
const RoundedButton = styled(Button)`
    border-radius: 5px;
`;

const blockItems = [
    {label: "아메리카노", padding: "1rem", backColor: "yellow"},
    {label: "홍차", padding: "1rem", backColor: "red"},
    {label: "우유", padding: "1rem", backColor: "green"},
]

function MainPage(props) {
    return (
        <>
            <Wrapper>
                <Title>
                    Hello!
                </Title>

                <Button>ButtonA</Button>
                <Button dark>ButtonB</Button>
                <RoundedButton>ButtonC</RoundedButton>

                {blockItems.map( (item, index) => {
                    return(
                        <Block
                            padding={item.padding}
                            backColor={item.backColor}
                        >
                            {item.label}
                        </Block>
                    )
                })}

            </Wrapper>
        </>
    );
}

export default MainPage;