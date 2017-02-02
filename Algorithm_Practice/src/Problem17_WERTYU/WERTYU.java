package Problem17_WERTYU;

import java.util.Scanner;

class Keyboard
{
	final static String [] keys = {
			"`1234567890-=",
			"QWERTYUIOP[]\\",
			"ASDFGHJKL;'",
			"ZXCVBNM,./"
	};
}

public class WERTYU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		StringBuilder output = new StringBuilder();
		
		for(int k = 0; k < input.length(); k ++)
		{
			if(input.charAt(k) == ' ')
			{
				output.append(' ');
				continue;
			}
			
			for(int i = 0; i < Keyboard.keys.length; i++)
			{
				for(int j = 0; j < Keyboard.keys[i].length(); j++)
				{	
					if(input.charAt(k) == Keyboard.keys[i].charAt(j))
					{
						if(j !=0) // j가 0일때는 Array 참조 에러난다.
							output.append(Keyboard.keys[i].charAt(j-1)); // 키보드에서 해당 문자의 바로 왼쪽에 있는 문자를 output에 추가  
					}
				}
			}
		}
		
		String strOutput = output.toString();
		System.out.println(strOutput);
	}
}
