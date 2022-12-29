import React from 'react';

function Article({title, postdate, imgUrl, contents}) {

    return (

        <>
            <article>
                <h2 style={{textAlign:"center"}}>{title}</h2>
                <p style={{textAlign:"right"}}>{postdate}</p>
                <img src={imgUrl}/>
                <p className="lh-180">{contents}</p>
            </article>
        </>

    );
}

export default Article;