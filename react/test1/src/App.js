import logo from './logo.svg';
import './App.css';
import Comment from './components/Comment';
import Notification from './components/Notification';
import Counter from './components/Counter';
import TextInputButton from './components/TextInputButton';
import Accommodate from './components/Accommodate';
import Toggle from './components/Toggle';
import MyButton from './components/MyButton';
import ConfirmButton from './components/ConfirmButton';
import Greeting from './components/Greeting';
import LoginControl from './components/LoginControl';
import Mailbox from './components/Mailbox';
import UserStatus from './components/UserStatus';
import WarningBanner from './components/WarningBanner';
import Mainpage from './components/Mainpage';

let list = [{}, {}, {}, {}, {}, {}, {}];

function App(){
  return (
    <Mainpage />
  )
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
