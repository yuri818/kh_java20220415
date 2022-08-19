import React, { useState } from 'react';

function Workout(props) {
  console.log(props.workout.name + props.workout.count);
  // 상태를 관리해 본다 - 바닐라스크립트로 처리
  const state = {
    count: 0,
  };
  // 바닐라스크립트에서 함수는 객체이다
  const handleDecrement = (e) => {
  };

  const handleIncrement = (workout) => {
    props.onIncrement(props.workout);
  };

  const handleDelete = (e) => {

  };

  return (
    <>
      <li className="workout">
        <span className="workout-name">{props.workout.name}</span>
        <span className='workout-count'>{props.workout.count}</span>
        <button className='wo-button workout-increase' onClick={handleIncrement}>
          <i className='fas fa-plus-square'></i>
        </button>
        <button className='wo-button workout-decrease' onClick={handleDecrement}>
          <i className='fas fa-minus-square'></i>
        </button>
        <button className='wo-button workout-delete' onClick={handleDelete}>
          <i className='fas fa-trash'></i>
        </button>
      </li>
    </>
  );
}

export default Workout;