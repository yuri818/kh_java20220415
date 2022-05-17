package com.day20;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest_1 {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("D:\\git_20220415\\kh_java20220415\\dev_java\\src\\com\\day20\\log.txt");
			fw.write(65); //A
			fw.write(97); //a
		} catch (FileNotFoundException fe) {
			System.out.println("해당 파일을 찾을 수 없습니다.");
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		} catch (Exception e) {
			// 예외가 발생했을 때 에러상황을 기록해두는 stack메모리 영역에 있는
			//에러 메시지를 라인번호와 함께 출력해주는 메소드 입니다. - 기억
			//주의: 절대로 print메소드 안에서 사용하지 말것.
			e.printStackTrace(); //에러발생시 좀 더 자세한 힌트문을 수집할 때 사용함
		} finally {
			//예외가 발생하든 발생하지 않던지 간에 반드시 처리해야 하는 코드를 작성함
			try {
				//입출력의 경우 악의적인 목적으로 접근하여 외부에 노출될 수 있으므로
				//사용한 객체는 반드시 닫아야 하는 컨벤션이 있다.
				fw.close(); //사용한 자원을 닫아줘야 한다. 반드시 - 권장사항
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} //end of finally

	}///////end of main

}//////////end of FileTest_1
