import React from 'react';
import Workout from './Workout';

function Workouts(props) {
  console.log(props); // 객체로 받는 경우
  console.log(props.workouts); // 배열
  
  const handleDecrement = (e) => {
    
  };

  const handleIncrement = (workout) => {
    props.onIncrement(workout);
  };

  const handleDelete = (e) => {

  };

  return (
    <div className='workouts'>
      <ul>
{
  /* 스크립트 쓸 수 있다 */
  props.workouts.map(workout => (
    <Workout //
      key={workout.id} // 
      onIncrement={handleIncrement}
      workout={workout} //
    />
  ))
}
      </ul>
    </div>
  );
}

export default Workouts;