package Test;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		int sum = 0;
		System.out.println("�߰� �ܰ��Դϴ�");
		for(int i = 0; i < 10; i++)
			sum += i;
		String c = sc.nextLine();
		System.out.println("�� �޾Ҿ��");
		System.out.println("first input:" + a);
//		System.out.println("myInt : " + myInt);
		System.out.println("second input:" + c);
		System.out.println(sum);
	}

}
