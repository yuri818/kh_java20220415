import React, { useState } from 'react';

function Workout(props) {
  const [name, setName] = useState("레그프레스");
  const [count, setCount] = useState(3);
  // 상태를 관리해 본다 - 바닐라스크립트로 처리
  const state = {
    count: 0,
  }
  return (
    <>
      <li className="workout">
        <span className="workout-name">{name}</span>
        <span className='workout-count'>{count}</span>
        <button className='wo-button workout-increase'>
          <i className='fas fa-plus-square'></i>
        </button>
        <button className='wo-button workout-decrease'>
          <i className='fas fa-minus-square'></i>
        </button>
        <button className='wo-button workout-delete'>
          <i className='fas fa-trash'></i>
        </button>
      </li>
    </>
  );
}

export default Workout;