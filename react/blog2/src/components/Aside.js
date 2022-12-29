import React from 'react';

function Aside({category, recentPost}) {


    if(!recentPost) {
        <div>최근 작성된 글이 없습니다.</div>
    }

    return (
        <aside>
            <h4>카테고리</h4>
            <ul>
                {category.map( (ctgy, index) =>
                    <li key={index}><a href={ctgy.linkUrl}>{ctgy.name}</a></li>
                )}
            </ul>

            <h4>최근 게시물</h4>
            <ul>
                {recentPost.map( (recent, index) =>
                    <li key={index}><a href={recent.linkUrl}>{recent.name}</a></li>
                )}
            </ul>
        </aside>
    );
}

export default Aside;