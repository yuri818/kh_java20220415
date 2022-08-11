import './app.css';
import "bootstrap/dist/css/bootstrap.min.css"

function App() {
  return (
    <div className="title">
      onClick={() => {
        console.log("onClick Event");
      }}
      <h1>Hello:)</h1>
    </div>
  );
}

export default App;
