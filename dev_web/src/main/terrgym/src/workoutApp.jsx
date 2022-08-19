import React, { useState } from 'react';
import Workout from './components/Workout';
import "./app.css";

function WorkoutApp() {
  const [items, setItems] = useState([
    {id: 1, name:"벤치프레스", count: 0},
    {id: 2, name:"스쿼트", count: 0},
    {id: 3, name:"랫풀다운", count: 0},
  ]);
  return (
      <Workout />
  );
}

export default WorkoutApp;

//rsf : function으로 자동완성