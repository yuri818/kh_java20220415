package network.step1;
//기존에 있던 도메인 주소를 가지고 ip주소를 수집하는 클래스
import java.net.*; 
public class InetAddressEx { 
	public static void main(String[] args) 
			throws UnknownHostException { //예외가 발생할 수 있다. 런타임에러(실행버튼 눌렀을때 발생)
		InetAddress iaddr = 
				InetAddress.getLocalHost(); 
		System.out.printf("호스트 이름 : %s %n" , 
				iaddr.getHostName()); 
		System.out.printf("호스트 IP 주소 : %s %n" , 
				iaddr.getHostAddress()); 
		iaddr = InetAddress.getByName("www.google.com"); 
		//getByName메소드 안에 도메인 써주면 그 주소를 가지고 InetAddress객체가 생성
		System.out.printf("호스트 이름 : %s %n" , 
				iaddr.getHostName()); 
		System.out.printf("호스트 IP 주소 : %s %n" , 
				iaddr.getHostAddress()); 
		InetAddress sw[] = 
				InetAddress.getAllByName("www.daum.net"); 
		for (InetAddress temp_sw : sw) { 
			System.out.printf("호스트 이름 : %s , " , 
					temp_sw.getHostName()); 
			System.out.printf("호스트 IP 주소 : %s %n" , 
					temp_sw.getHostAddress()); 
		} 
	} 
} 

