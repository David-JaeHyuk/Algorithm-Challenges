package Test;

import java.util.StringTokenizer;

public class TokenizerAndSplitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "10:00 12:00 Lectures";
//		String str2 = "남자, ,서울 강남구";
		String[] values = str.split(":|\\s");
		
		for(int x = 0; x < values.length; x++)
			System.out.println("문자(열) " + x + "의 값 : " + values[x]);
		
//		int test = Integer.parseInt(values[0]) + 1;
//		System.out.println(test);
		
		StringTokenizer tokens = new StringTokenizer(str, ":");
		for(int x = 1; tokens.hasMoreElements(); x++)
			System.out.println("토크나이저 문자열 " + x + " : " + tokens.nextToken());
		
	}
	
	

}
