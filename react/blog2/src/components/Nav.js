import React, {useState} from 'react';

function Nav({nav}) {

    const [text, setText] = useState('');

    const handleClick = () =>{
        setText('');
    }

    return (
        <nav>
            <ul>
                {nav.taps.map( (taps, index) =>
                    <li key={index}><a href={taps.linkUrl}>{taps.name}</a></li>
                )}
            </ul>

            <div>
                <input type="text" value={text} onChange={(event)=>setText(event.target.value)}></input>
                <button onClick={handleClick}>검색</button>
            </div>
        </nav>
    );
}

export default Nav;