import React from "react";
import './app.css';
import "bootstrap/dist/css/bootstrap.min.css"

function App() {
  const name = "이순신";
  // 여기가 렌더링 되는 부분 : 화면을 선언한다
  return (
  //<React.Fragment>
  /* 
    리액트에서는 태그를 선언하여 사용함 - 멀티라인을 작성하려면 최외곽에 만드시 Fragment태그 붙인다 - 생략가능
    jsp => java+html
    리액트 UI안에는 html태그와 javascript혼용하여 쓸 수 있다.
  */
  <>
    <h1>Hello! {"name"}</h1>
    <h1>Hello! {name}</h1>
    {// 자바스크립트 코드를 작성할 수 있다.
      name && <h1>Hi!!! {name}</h1>
    }
    {
      ['🍡','🍧','🍰'].map((item, index) => (
        console.log(index),
        (<h1>{item}</h1>)
      ))
    }
  </>
  );
}

export default App;
