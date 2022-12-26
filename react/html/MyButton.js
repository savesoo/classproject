
// 함수형 컴포넌트 -> 엘리먼트 반환(DOM)
function MyButton(prop){

    //state. 컴포넌트는 직접 값을 변경하지 않고 set 메소드를 이용해 처리함
    const [isClicked, setIsClicked] = React.useState(false);

    return React.createElement(
        'button',
        { onClick : () => {setIsClicked(!isClicked)} }, // 속성 정의
        isClicked ? '클릭한 상태' : '클릭하세요' // button Element의 child
    );

}

const domContainer = document.querySelector('#root');
ReactDOM.render(React.createElement(MyButton), domContainer);