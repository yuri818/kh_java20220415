import React from "react";
import { useParams } from "react-router-dom";

function ShoesPage(props) {
  const { id, name } = useParams();
  console.log(id + ", " + name);
  return <div>신발 상품 소개 페이지</div>;
}

export default ShoesPage;
