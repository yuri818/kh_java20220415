import React from "react";

function ShoesDetail(props) {
  const shoe = props.shoe;
  return (
    <div className="col-md-4">
      <img
        src={process.env.PUBLIC_URL + "/images/" + shoe.img}
        width="80%"
        height="70%"
      />
      <h4>{shoe.title}</h4>
      <p>{shoe.content}</p>
      <p>{shoe.price}원</p>
      <button className="btn btn-danger">주문하기</button>
    </div>
  );
}

export default ShoesDetail;
