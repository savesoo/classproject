import React from 'react';
import Aside from "./Aside";
import Article from "./Article";

function Wrapper({postList, category, recentPost}) {

    return (
        <div id="wrap">
            <section>
                {postList.map((post, index)=>{
                    return <Article key={index}
                                    title={post.title}
                                    postdate={post.postdate}
                                    imgUrl={post.imgUrl}
                                    contents={post.contents}
                    />
                })}
            </section>
            <Aside category={category} recentPost={recentPost}/>
        </div>
    );
}

export default Wrapper;