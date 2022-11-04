
document.addEventListener('DOMContentLoaded', () => {



    const userInfo = document.querySelectorAll('div');

    userInfo.forEach( () => {

    
    div.addEventListener('keyup', (event) => {
        btn.forEach();
    });


    } );


    // listArea에 새 div 추가
    const list = document.querySelectorAll('#list');



    let memCnt = 0;

    // 이벤트 핸들러........?? 회원가입할 때 입력
    const addMem = () => {

        if(input.value.trim()==='') {
            alert('내용을 입력해주세요.');
            return;
        };

        const userid = document.querySelector('#userID');
        const pw = document.querySelector('#pw');
        const repw = document.querySelector('#repw');
        const userName = document.querySelector('#userName');
    
        const btn = document.querySelector('#submitBtn');

        const newDiv = document.querySelector('div');
        const input = document.querySelector('input');

        newDiv.appendChild(btn);

        const list = {
            index : '순번(index)',
            userid : '아이디',
            pw : '비밀번호',
            userName : '이름',
        }


        const index = memCnt++;

        newDiv.setAttribute('index', index);



    }

    // 멤버 리스트 출력 - 배열인데....표 안에 들어가야함

    // 회원 정보 수정

    // 멤버 삭제
    const removeMem = () => {


    }

    // 등록?
    submitBtn.addEventListener('submit', addMem);

});


