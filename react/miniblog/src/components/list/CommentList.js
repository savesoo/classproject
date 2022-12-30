import React from 'react';
import styled from "styled-components";
import CommentListItem from "./CommentListItem";

// & : 현재 처리하는 div 가리킴
// last-child를 제외한(:not) 현 div(&) 안쪽(>)의 모든(*) 자식태그 선택해서 속성 부여
const Wrapper = styled.div`
     display: flex;
     flex-direction: column;
     align-items: flex-start;
     justify-content: center;
     
     & > * {
         :not(:last-child) {
            margin-bottom: 16px;
         }
     }
`;

// 리스트 형태의 comments 받음
function CommentList({comments}) {
    return (
        <Wrapper>
            {comments.map(comment => {
                return (
                    <CommentListItem key={comment.id}
                                     comment={comment}
                    />
                )
            })}
        </Wrapper>
    );
}

export default CommentList;