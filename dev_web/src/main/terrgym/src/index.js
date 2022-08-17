import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import WorkoutApp from './workoutApp';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <WorkoutApp />
  </React.StrictMode>
);
