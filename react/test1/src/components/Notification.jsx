import React from "react";

const styles = {
    wrapper : {
        margin : 8,
        padding : 8,
        display : 'flex',
        flexDirection : 'row',
        border : '1px solid gray',
        borderRadius : 16
    },
    messegeText : {
        color : 'blue',
        fontSize : 24
    }
}

class Notification extends React.Component {

    constructor(props){
        super(props);
        this.state = { checked : false };
    }

    // 함수 overwriting
    componentDidMount(){
        const checkedVal = this.state.checked;
        console.log(' >>> componentDidMount() call >>> ', checkedVal);
        this.setState({ checked : true }); // state 변경 -> 재렌더링
    }

    // 재렌더링시 실행
    componentDidUpdate(){
        const checkedVal = this.state.checked;
        console.log(' >>> componentDidUpdate() call >>> ', checkedVal);
    }

    // 화면에서 사라질 때 처리
    componentWillUnmount(){
        const checkedVal = this.state.checked;
        console.log(' >>> componentWillUnmount() call >>> ', checkedVal);
    }


    // 전달해줄 값
    render(){
        return(
            <div style={styles.wrapper}>
                <span style={styles.messegeText}> {this.props.message} </span>
            </div>
        )
    }
}


export default Notification;