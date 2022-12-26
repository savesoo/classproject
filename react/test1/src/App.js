import logo from './logo.svg';
import './App.css';
import Comment from './components/Comment';

const comment = {
  user : {
    userName: 'Judas',
    imgUrl : 'https://www.google.com/url?sa=i&url=https%3A%2F%2Ftwitter.com%2Fsoultreestarlig%2Fstatus%2F1565143733041250304&psig=AOvVaw0JWrxbTjvyda4v2uq6mXRC&ust=1672130894888000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCODgm5XzlvwCFQAAAAAdAAAAABAE'
  },
  content : 'jejus!',
  replydate : '2022-12-25'
}

function App(){
  return (
    <Comment user={comment.user} content={comment.content} replydate={comment.replydate}/>
  ); 
}


/*function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}*/

export default App;
