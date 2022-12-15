
let replyList;
let editModal;

// 댓글 리스트 출력 영역  캐스팅
document.addEventListener('DOMContentLoaded', () => {

    // 캐스팅(문서객체 생성)
    replyList = document.querySelector('#replyList');

    // 댓글 작성 버튼
    const btn_reply = document.querySelector("#btn_reply");

    // 댓글 수정 버튼
    const btn_edit = document.querySelector("#btn_edit");

    editModal = new bootstrap.Modal('#replyEditModal')


    // 버튼에 이벤트 등록
    btn_reply.addEventListener('click', insertReply);
    btn_edit.addEventListener('click', editReply);


    // 페이지가 로드되면 리스트 출력
    setList();

});



// 페이지 로드 이후에 비동기 통신 실행 함수
function setList(){

    // 비동기 통신 : 댓글 리스트
    axios.get('/reply/'+bno)
        .then(res =>{
            // 응답
            console.log('response', res.data)

            let list = res.data;

            // data 받으면 반복할 것
            list.forEach((reply, index) =>{
                // 새로운 tr 생성해 replyIndex 영역에 추가

                const newTR = document.createElement('tr');

                let html = '<td class="col-2">'+reply.replyer+'</td>'
                html+= '<td class="col">'+reply.reply+'</td>'
                html+= '<td class="col-2">'+reply.replyDate+'</td>'
                html+= '<td class="col-2">' +
                    '<a href="javascript:showEditModal('+reply.rno+')" class="badge bg-warning text-decoration-none">수정</a>' +
                    '<a href="javascript:deleteReply('+reply.rno+')" class="badge bg-danger text-decoration-none">삭제</a> ' +
                    '</td>'

                newTR.innerHTML=html; // $().html(html)
                newTR.setAttribute('class', 'fs-6 text-center');
                newTR.setAttribute('tr-index', reply.rno); // tr마다 rno값이 부여됨 -> 전달받은 번호의 tr를 캐스팅하기 위해

                // 부모 태그에 요소 추가
                replyList.appendChild(newTR);

            })

        })
        .catch(err => {
            // 에러 처리
            console.log(err)
        })

}


// 버튼 누르면 작성(입력)
function insertReply(){

    // 서버로 전송할 payload(데이터) JSON 객체 형태로 생성
    const payload = {
        bno : bno,
        reply : document.querySelector("#reply").value,
        replyer : document.querySelector("#replyer").value
    }

    console.log("payload >>> " + payload);

    axios.post('/reply', payload)
        .then(res => {

            console.log('post->response : ', res.data)

            const reply = res.data;

            // replyList 영역에 새로운 tr을 추가

            const newTR = document.createElement('tr');

            let html = '<td class="col-2">'+reply.replyer+'</td>'
            html+= '<td class="col">'+reply.reply+'</td>'
            html+= '<td class="col-2">'+reply.replyDate+'</td>'
            html+= '<td class="col-2">' +
                '<a href="javascript:showEditModal('+reply.rno+')" class="badge bg-warning text-decoration-none">수정</a>' +
                '<a href="javascript:deleteReply('+reply.rno+')" class="badge bg-danger text-decoration-none">삭제</a> ' +
                '</td>'

            newTR.innerHTML=html; // $().html(html)
            newTR.setAttribute('class', 'fs-6 text-center');
            newTR.setAttribute('tr-index', reply.rno); // tr마다 rno값이 부여됨 -> 전달받은 번호의 tr를 캐스팅하기 위해

            // 부모 태그에 요소 추가
            replyList.appendChild(newTR);

            // 작성이 완료되고 공백처리
            document.querySelector("#reply").value ='';
            document.querySelector("#replyer").value ='';

        })
        .catch(err => console.log(err))

}

// 버튼 누르면 삭제
function deleteReply(rno){

    if(!confirm('정말로 삭제하시겠습니까?')){
        return;
    }

    console.log('rno >>> ' + rno);

    axios.delete('/reply/'+rno)
        .then(res => {

            console.log('delete->response : ', res.data);

            // 비교 연산은 숫자 우선
            if(res.data==1){

                // 화면에서 tr-index == 해당 rno 인 행을 삭제
                // 삭제 대상 행 캐스팅
                const delTR = document.querySelector('tr[tr-index="'+rno+'"]');
                replyList.removeChild(delTR);
                alert('삭제되었습니다!');

            } else {
                alert('삭제할 대상이 존재하지 않습니다.');
            }

        })
        .catch(err => console.log(err))

}


// 수정창 띄우기
function showEditModal(rno){

    // 모달에서 보여주는 show 함수
    editModal.show();

    const editTD = document.querySelectorAll('tr[tr-index="'+rno+'"]>td'); // tr안에 있는 td를 모두 select

    //editTD[0].textContent='변경된 데이터'

    console.log(editTD[0].textContent) // 작성자
    console.log(editTD[1].textContent) // 내용
    console.log(editTD[2].textContent) // 등록일

    // 저장된 각 데이터를 get
    document.querySelector('#erno').value=rno;
    document.querySelector('#ereplyer').value=editTD[0].textContent;
    document.querySelector('#ereply').value=editTD[1].textContent;
    document.querySelector('#ereplydate').value=editTD[2].textContent;

}

// 수정한 데이터 반영
function editReply(rno){

    // 서버로 전송할 payload(데이터) 객체 형태로 생성
    // put -> 전체 데이터의 변경! 모든 데이터를 서버로 전송, 값이 없는 경우 기본값으로 저장
    const payload = {
        bno : bno,
        rno : document.querySelector('#erno').value,
        reply : document.querySelector("#ereply").value,
        replyer : document.querySelector("#ereplyer").value,
        replyDate : document.querySelector("#ereplydate").value
    }

    console.log(payload);

    axios.put('/reply/'+payload.rno, payload)
        .then(res =>{
            console.log('put->response', res.data);

            const editTD = document.querySelectorAll('tr[tr-index="'+payload.rno+'"]>td');
            editTD[1].textContent=payload.reply; // 입력받은 reply를 set

            editModal.hide(); // 닫기

        })
        .catch(err => console.log(err))

}