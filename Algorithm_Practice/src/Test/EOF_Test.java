package Test;

import java.util.Scanner;

public class EOF_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) // Ctrl + Z �� ������ ����ȴ�.
		{
//			String a = sc.nextLine();
			int a = sc.nextInt();
			System.out.println("�ƿ�ǲ �׽�Ʈ : " + a);
			
			
		}
		
		System.out.println("Ctrl+Z ��ư�� ������ �Է½�Ʈ���� ����˴ϴ�.");
			 
	}

}
