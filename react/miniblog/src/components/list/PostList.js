import React from 'react';
import styled from "styled-components";
import PostListItem from "./PostListItem";

// & : 현재 처리하는 div 가리킴
// last-child를 제외한(:not) 현 div(&) 안쪽(>)의 모든(*) 자식태그 선택해서 속성 부여
const Wrapper = styled.div`
    display: flex;
    flex-direction: cloumn;
    align-items: flex-start;
    justify-content: center;
    
    & > * {
        :not(:last-child) {
         margin-bottom: 16px;
        }
    }
`;

// view 페이지로 post를 전달
// 리스트 형태의 posts 받음, 클릭하면 다른 페이지로 이동해야하므로 함수 추가
function PostList({posts, onClickItem}) {
    return (
        <Wrapper>
            {posts.map( post => {
                return (
                    <PostListItem key={post.id}
                                  post={post}
                                  onClick={()=>{onClickItem(post)}}
                    />
                )
            })}
        </Wrapper>
    );
}

export default PostList;