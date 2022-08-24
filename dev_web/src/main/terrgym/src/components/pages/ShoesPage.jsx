import React from "react";
import { useParams } from "react-router-dom";
import ShoesDetail from "./ShoesDetail";
// 자바스크립트는 싱글스레드(timeLine)이다. - forEach문 -> for문 처리
// 콜백 이슈

function ShoesPage(props) {
  const shoes = props.shoes;
  //console.log(shoes);
  const { id, name } = useParams();
  //console.log(id + ", " + name);
  return (
    <div className="container">
      <div className="row">
        {shoes.map((shoe, i) => (
          // i는 0부터 - 배열이니까! 여기서 key값이 식별자역할. 꼭 있어야함
          <ShoesDetail key={i} shoe={shoe} />
        ))}
      </div>
    </div>
  );
}

export default ShoesPage;
