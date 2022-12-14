
let replyList;
let editModal;

// 댓글 리스트 출력 영역  캐스팅
$(document).ready( function (){

    // 캐스팅(문서객체 생성)
    replyList = $('#replyList');

    // 댓글 작성 버튼 + 이벤트 등록
    $('#btn_reply').click(insertReply);

    // 댓글 수정 버튼 + 이벤트 등록
    $('#btn_edit').click(editReply);

    editModal = new bootstrap.Modal('#replyEditModal');

    // 댓글 리스트 버튼에 이벤트 등록, 동적으로 생성되는 Tag에 이벤트 연결
    $('#replyList').on('click', '.edit', showEditModal);
    $('#replyList').on('click', '.del', deleteReply);

    // 페이지가 로드되면 리스트 출력
    setList();

});


// 페이지 로드 이후에 비동기 통신 실행 함수
function setList(){

    // 비동기 통신 : 댓글 리스트
    $.ajax({
        url : '/reply/'+bno, //
        type : 'get',
        async : true,
        dataType : "json",
        timeout : 10000,
        success : function (data){ // 이때 data는 list(js object)

            console.log('response', data);

            // 반복문
            $.each(data, (index, reply)=>{

                // 새로운 tr 생성해 replyIndex 영역에 추가
                let html = '<td class="col-2">'+reply.replyer+'</td>'
                html+= '<td class="col">'+reply.reply+'</td>'
                html+= '<td class="col-2">'+reply.replyDate+'</td>'
                html+= '<td class="col-2">' +
                    '<a href="javascript:" class="badge bg-warning text-decoration-none edit">수정</a>' +
                    '<a href="javascript:" class="badge bg-danger text-decoration-none del">삭제</a> ' +
                    '</td>'

                /* '<a href="javascript:showEditModal('+reply.rno+')" class="badge bg-warning text-decoration-none">수정</a>' +
                 '<a href="javascript:deleteReply('+reply.rno+')" class="badge bg-danger text-decoration-none">삭제</a> ' +*/

                // 부모 태그에 요소 추가
                $('<tr></tr>').html(html).addClass('fs-6 text-center').attr('tr-index', reply.rno).appendTo(replyList);

            })

        },
        error : function (request,status,error){
            console.log(error);
        }
    });

}


// 버튼 누르면 작성(입력)
function insertReply(){

    // 서버로 전송할 payload(데이터) 객체 형태로 생성
    const payload = {
        bno : bno,
        reply : $('#reply').val(),
        replyer : $('#replyer').val()
    }

    console.log("payload >>> " + payload);

    $.ajax({
        url: '/reply',
        type: 'post',
        data: JSON.stringify(payload),
        dataType: "json",
        contentType: "application/json", // 전달되는 데이터가 JSON!
        success: function (data) {

            console.log('response', data);

            const reply = data;

            // replyList 영역에 새로운 tr을 추가
            let html = '<td class="col-2">'+reply.replyer+'</td>'
            html+= '<td class="col">'+reply.reply+'</td>'
            html+= '<td class="col-2">'+reply.replyDate+'</td>'
            html+= '<td class="col-2">' +
                '<a href="javascript:" class="badge bg-warning text-decoration-none edit">수정</a>' +
                '<a href="javascript:" class="badge bg-danger text-decoration-none del">삭제</a> ' +
                '</td>'

            // 부모 태그에 요소 추가
            $('<tr></tr>').html(html).addClass('fs-6 text-center').attr('tr-index', reply.rno).appendTo(replyList);

            // 작성이 완료되고 공백처리
            $('#reply').val('');
            $('#replyer').val('');

        },
        error : function (request,status,error){
            console.log(error);
        }
    });


}


// 버튼 누르면 삭제
function deleteReply(e){

    // a 기본 기능 제거
    e.preventDefault();

    if(!confirm('정말로 삭제하시겠습니까?')){
        return;
    }

    // rno 구하기
    // 이벤트 발생 위치(버튼)을 감싼 td -> td를 감싼 tr -> tr이 가진 속성값 tr-index 가져옴
    const  rno = $(this).parent('td').parent('tr').attr('tr-index');

    console.log('rno >>> ' + rno);

    $.ajax({
        url: '/reply/'+rno,
        type: 'delete',
        success: function (data) {

            console.log('delete->response : ', data);

            if(data==1){

                // 화면에서 tr-index == 해당 rno 인 행을 삭제
                // 삭제 대상 행 캐스팅
                $('tr[tr-index="'+rno+'"]').remove();
                alert('삭제되었습니다!');

            } else {
                alert('삭제할 대상이 존재하지 않습니다.');
            }
        },
        error : function (request,status,error){
            console.log(error);
        }
    });

}


// 수정창 띄우기
function showEditModal(e){

    // a 기본 기능 제거
    e.preventDefault();

    // 모달에서 보여주는 show 함수
    editModal.show();

    //const editTD = $('tr[tr-index="'+rno+'"]>td'); // tr안에 있는 td를 모두 select
    const editTD = $(this).parent('td').parent('tr').children('td');
    const  rno = $(this).parent('td').parent('tr').attr('tr-index');
    // 이벤트 발생 위치(버튼)을 감싼 td -> td를 감싼 tr -> tr이 가진 속성값 tr-index 가져옴

    //editTD[0].textContent='변경된 데이터'
    // $(editTD).eq(0).text()

    console.log($(editTD).eq(0).text()); // 작성자
    console.log($(editTD).eq(1).text()); // 내용
    console.log($(editTD).eq(2).text()); // 등록일

    // 저장된 각 데이터를 get
    $('#erno').val(rno);
    $('#ereplyer').val($(editTD).eq(0).text());
    $('#ereply').val($(editTD).eq(1).text());
    $('#ereplydate').val($(editTD).eq(2).text());

}


// 수정한 데이터 반영
function editReply(){
    // 서버로 전송할 payload(데이터) 객체 형태로 생성
    // put -> 전체 데이터의 변경! 모든 데이터를 서버로 전송, 값이 없는 경우 기본값으로 저장
    const payload = {
        bno : bno,
        rno : $('#erno').val(),
        reply : $('#ereply').val(),
        replyer : $('#ereplyer').val(),
        replyDate : $('#ereplydate').val()
    }

    console.log(payload);

    $.ajax({
        url: '/reply/'+payload.rno,
        type: 'put',
        contentType: "application/json",
        data: JSON.stringify(payload),
        dataType: "json",
        success: function (data) {

            console.log('put->response', data);

            // 입력받은 reply를 set
            const editTD = $('tr[tr-index="'+payload.rno+'"]>td');
            $(editTD).eq(1).text(payload.reply);

            /*const editTD = $('tr[tr-index="'+payload.rno+'"]');
            editTD.children('td:eq(1)').text(payload.reply);*/

            editModal.hide(); // 닫기

        },
        error : function (request,status,error){
            console.log(error);
        }
    });

}