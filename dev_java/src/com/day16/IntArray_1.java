package com.day16;

public class IntArray_1 {
	// 부서번호를담을배열선언
	int deptnos[] = null;
	//디폴트 생성자 선언
	public IntArray_1() {
		//배열의 생성 - 방이 3개 만들어 진다.
		deptnos = new int[3]; //deptnos[0]=0, deptnos[1]=0, deptnos[2]=0
		//배열의 초기화를 담당하는 메소드 호출
		initArray();
		//위 메소드를 경유하면 0 0 0대신에 새로운 값이 10 20 30 으로 초기화됨
		arrayPrint();
	}
	//아래 메소드가 호출 되야 deptnos 1차 배열의 초기화가 된다.
	public void initArray() {
		deptnos[0] = 10; //deptnos[0]=10
		deptnos[1] = 20; //deptnos[1]=20
		deptnos[2] = 30; //deptnos[2]=20
	}//////////////end of initArray
	//배열의 원소의 갯수를 카운트 해줌
	public void arrayPrint() {
		for (int i = 0; i < deptnos.length; i++) {
			System.out.println(deptnos[i]);
		}
	}//////////////end of arryPrint

	public static void main(String[] args) {
		//배열을 초기화 하는 initArray 호출 또 초기화된 배열을 출력하는 arrayPrint 호출
		//모두 생성자에서 처리되었다
		//그래서 생성자 호출이 필요함
		new IntArray_1();
	}
}/////////////////end of main