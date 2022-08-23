import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import BootStrapApp from './bootStrapApp';
import WorkoutApp from './workoutApp';
import App from "./app";
import "@fortawesome/fontawesome-free/js/all.js";
import { BrowserRouter } from 'react-router-dom';

const root = ReactDOM.createRoot(document.getElementById('root5'));
root.render(
  <React.StrictMode>
    {/* 여기서 렌더링할 페이지를 조립해준다 */}
    <BrowserRouter>
      <BootStrapApp />
    </BrowserRouter>
    {/* <WorkoutApp /> */}
    {/* <App /> */}
  </React.StrictMode>
);
