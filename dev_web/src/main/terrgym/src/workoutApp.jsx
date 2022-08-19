import React, { useState } from 'react';
import Workouts from './components/Workouts';
import "./app.css";

function WorkoutApp() {
  const [items, setItems] = useState([
    {id: 1, name:"벤치프레스", count: 0},
    {id: 2, name:"스쿼트", count: 0},
    {id: 3, name:"랫풀다운", count: 0},
  ]);

  const handleDecrement = (e) => {
  };

  const handleIncrement = (workout) => {
    console.log(`workout: ${workout.name}, ${workout.count}`);
    // 사용자가 선택한 로우의 인덱스 값을 알아낸다
    const index = items.indexOf(workout); // 0,1,2를 넘겨준다  -1은 end of file의 의미
    // 이벤트가 발동된 인덱스를 값으로 count변수에 접근한 뒤 1씩 증가
    items[index].count += 1;
    //items[0].count++과 같다
    // 위에서 count가 1증가된 정보로 업데이트가 되어야 하므로 spread구문을 이용해서 복사
    // 상태를 관리하는 useState훅을 사용하면 한개씩도 가능하고 객체도 가능,  또한 배열도 가능함
    // useState훅을 사용하면 효율적인 처리가 가능하다. 상태가 변한 경우에만 새로 처리를 함
    // - 훨씬 효과적인 화면처리가능, 메모리 사용도 줄어든다
    setItems([...items]); // 이건 원본에 최종적으로 업데이트 해주는 것!!
  };

  const handleDelete = (e) => {

  };
  return (
      <Workouts // 
        workouts={items} // 태그의 속성으로 값을 넘길 수 있다 - props활용하기
        onIncrement={handleIncrement}
      />
  );
}

export default WorkoutApp;

//rsf : function으로 자동완성
// 결론적으로 부모태그에서 하위태그로는 항상 언제든지 props를 통해서 값을 전달할 수 있다
// 다만 매번 파일마다 props를 전달해야 하므로 피로도가 높다- 그래서 리덕스가 출현
// 이벤트 처리도 위임하거나 전달이 가능하다
// 자바스크립트에서는 함수도 객체이기 때문이다
// ajax가 엇ㅂ어도 리액트에서는 그런 효과를 처리 가능함