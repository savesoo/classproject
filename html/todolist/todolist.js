
document.addEventListener('DOMContentLoaded', () => {

    // 문서 객체 생성
    const input = document.querySelector('#newTodo');
    const addBtn = document.querySelector('#addBtn');
    const todolist = document.querySelector('#todoList');

    let cnt = 0;

    // 이벤트 핸들러 함수
    const addTodo = () => { 

        //console.log(input.value) 
        if(input.value.trim()==='') {
            alert('내용을 입력해주세요!');
            return;
        }

        // 동적으로 추가할 Element 생성
        const newDiv = document.createElement('div');
        const checkBox = document.createElement('input');
        const todo = document.createElement('span');
        const btn = document.createElement('button');

        newDiv.appendChild(checkBox);
        newDiv.appendChild(todo);
        newDiv.appendChild(btn);

        // 속성 설정
        newDiv.style.padding = '10px';
        
        const key = cnt++;

        newDiv.setAttribute('data-key', key); // 필요한 데이터 생성

        checkBox.type = 'checkbox';
        todo.textContent = input.value;
        btn.textContent = '할일 삭제하기';

        // 이벤트 적용
        checkBox.addEventListener('change', (event) => {
            todo.style.textDecoration = event.target.checked ? 'line-through' : '';
        });

        btn.addEventListener('click', () => {
            removeTodo(key)
        });


        // todolist에 새로운 div 추가
        todolist.appendChild(newDiv);

        input.value = '';

    };

    const removeTodo = function(key){
        const delElement = document.querySelector(`div[data-key="${key}"]`);
        todolist.removeChild(delElement);
    };

    // 이벤트 연결
    addBtn.addEventListener('click', addTodo);

});