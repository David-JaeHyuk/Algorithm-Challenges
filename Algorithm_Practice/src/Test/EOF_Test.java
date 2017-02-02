package Test;

import java.util.Scanner;

public class EOF_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) // Ctrl + Z 를 누르면 종료된다.
		{
//			String a = sc.nextLine();
			int a = sc.nextInt();
			System.out.println("아웃풋 테스트 : " + a);
			
			
		}
		
		System.out.println("Ctrl+Z 버튼이 눌려서 입력스트림이 종료됩니다.");
			 
	}

}
