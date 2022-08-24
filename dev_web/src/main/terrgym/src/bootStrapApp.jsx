import "./app.css";
import React, { useState } from "react";
import { Container, Nav, Navbar } from "react-bootstrap";
import { Link, Route, Routes, useNavigate } from "react-router-dom";
import styled from "styled-components";
import ShoesPage from "./components/pages/ShoesPage";
import goods from "./shoesData.js";

let BtnColor = styled.button`
  background: ${(props) => props.bgc};
  color: ${(props) => (props.bgc === "yellow" ? "black" : "white")};
  padding: 7px;
  margin: 5px;
  border-radius: 5px;
`;
function BootStrapApp(props) {
  // 변수 선언 위치, 함수 선언 위치
  // 상태 관리를 위해 제공되는 훅[hook](16.8버전 후에 지원: 이전 함수로는 state관리가 불가)
  // 기존 클래스에서 this의 이슈로 에러가 발생함 - 미숙 - 관리자 입장 문제임
  let [shoes, setShoes] = useState(goods);
  let navigate = useNavigate(); // 함수형 프로그래밍지향 - 클래스가 아닌 훅으로 처리함
  return (
    <>
      {/* 헤더 영역 시작 */}
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="#home">YRDepartmentStore</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link
              onClick={() => {
                navigate("/");
              }}
            >
              Home
            </Nav.Link>
            <Nav.Link
              onClick={() => {
                navigate("/shoes");
              }}
            >
              신발
            </Nav.Link>
            <Nav.Link href="#pricing">노트북/핸드폰</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      {/* 헤더 영역  끝 */}
      <div className="main-bg"></div>
      <Routes>
        <Route path="/" element={<div>홈페이지 입니다.</div>} />
        <Route path="/shoes" element={<ShoesPage shoes={shoes} />} />
      </Routes>
    </>
  );
}

export default BootStrapApp;

/* 
  리액트에서는 싱글페이지 어플리케이션으로 구현할것
  따라서 a태그를 사용하여 페이지 URL이 변경되지 않도록 하면서
  화면전환이 이루어지도록 처리함

  이전 페이지이동 
  history.go: history.go(-1); 이전페이지 이동 history.go(1);다음페이지로 이동
  리액트에서는 useNavigate훅을 이용해서 처리함
*/
