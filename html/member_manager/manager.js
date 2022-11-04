
// 등록된 게시물 관리를 위한 인덱스 부여
let memCnt = 0;

document.addEventListener('DOMContentLoaded', () => {

    // 버튼 누르면 등록
    const submit = document.querySelector('#submitBtn');

    // 이벤트 생성
    submit.addEventListener('click', (event) => {
        const userid = document.querySelector('#userID');
        const pw = document.querySelector('#pw');
        const repw = document.querySelector('#repw');
        const userName = document.querySelector('#userName');

        // 메시지 관리를 위한 객체 생성
        const idMsg = document.querySelector('#idMsg');
        const pw2Msg = document.querySelector('#pw2Msg');
        const nameMsg = document.querySelector('#nameMsg');


        // id 공백 체크
        if(userid.value.trim()===''){
            idMsg.textContent = '아이디는 비울 수 없습니다.';
            return;
        } else {
            idMsg.textContent = '';
        }

        // pw 일치여부 체크
        if(pw.value!=repw.value){
            pw2Msg.textContent = '비밀번호가 일치하지 않습니다.';
            return;
        } else {
            pw2Msg.textContent = '';
        }

        // 이름 공백 체크
        if(userName.value.trim()===''){
            nameMsg.textContent = '이름은 비울 수 없습니다.';
            return;
        } else {
            nameMsg.textContent = '';
        }


        // 회원 정보 리스트에 추가
        const list = document.querySelector('#list'); // 객체 생성
        let tr = document.createElement('tr'); // 새로운 요소(추가되는 리스트) 생성
        tr.setAttribute('id', memCnt ); // 추가할 때 인덱스 부여

        tr.innerHTML = `<td>${memCnt}</td>
                        <td>${userid.value}</td>
                        <td>${pw.value}</td>
                        <td>${userName.value}</td>
                        <td><input type="button" value="삭제" id="removeMem-${memCnt}"></td>`;
                        // 삭제 버튼 생성(동적 추가)

        list.appendChild(tr); // 리스트에 새로운 행(회원 정보) 추가

        // 리스트에서 삭제
        const removeBtn = document.querySelector(`#removeMem-${memCnt++}`);
        removeBtn.addEventListener('click', () => {
            if(window.confirm('정말로 삭제하시겠습니까?')){
                tr.remove();
            }
        });

    });


});