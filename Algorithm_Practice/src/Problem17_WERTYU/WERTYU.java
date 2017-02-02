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
						if(j !=0) // j�� 0�϶��� Array ���� ��������.
							output.append(Keyboard.keys[i].charAt(j-1)); // Ű���忡�� �ش� ������ �ٷ� ���ʿ� �ִ� ���ڸ� output�� �߰�  
					}
				}
			}
		}
		
		String strOutput = output.toString();
		System.out.println(strOutput);
	}
}
