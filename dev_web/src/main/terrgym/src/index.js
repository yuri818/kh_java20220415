import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import WorkoutApp from './workoutApp';
import App from "./app";
import "@fortawesome/fontawesome-free/js/all.js";

const root = ReactDOM.createRoot(document.getElementById('root5'));
root.render(
  <React.StrictMode>
    {/* 여기서 렌더링할 페이지를 조립해준다 */}
    <WorkoutApp />
    {/* <App /> */}
  </React.StrictMode>
);
