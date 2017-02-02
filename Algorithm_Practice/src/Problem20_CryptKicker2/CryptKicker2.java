package Problem20_CryptKicker2;

import java.util.HashMap;
import java.util.Scanner;

public class CryptKicker2 
{
	static final String plainText = "the quick brown fox jumps over the lazy dog"; 
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		//필요한 변수들
		String[] input = new String[100]; // 입력된 각 줄의 문장들을 저장할 String 배열
		HashMap<Character, Character> map = new HashMap<Character, Character>(); //각각의 암호가 매핑될 해쉬맵. 
		// ==> 이거 쓰면 안된다. 나중에 뽑아낼 때 책의 정답에서는 매핑된 배열을 순차적으로 인덱스 넘버에 따라 출력하지만 
		// 여기서는 인덱스넘버가 아닌 키값에 대한 value를 출력하기 때문에 ==> 그게 아니고!!
		// 인버스 매핑 조건을 탐색을 못한다. ==> No! 사용해도 된다. 
		
//		char[] mapping = new char[26];
//		char[] inverseMapping = new char[26];
		
//		map.put(' ', ' ');
		
		int i = 0, j = 0;
		boolean isThereMatching = false;
		
		while(true) // 인풋값 입력
		{
			input[i] = sc.nextLine();
			if(input[i].equals(""))
				break;
			i++;
		}
		
		for(i = 0; i < input.length ; i++)
		{
			if(input[i].length() != plainText.length()) // 길이가 같은 라인을 찾아냄
				continue;
			// 한 문자가 서로 다른 두 문자에 매핑되어서는 안된다 
			// 서로 다른 두 문자가 한 문자에 매핑되어서는 안된다
			// 즉 1:1 매핑이어야 한다.
			// => 이미 매핑되어 있는데, 또 다른 값으로 매핑하려고 하면(이 때 같은 값이면 상관없구..) 패스
			
			for(j = 0; j < plainText.length(); j++)
			{
				// 해당 키를 포함하고 있는데, 55번째 라인에서 현재 값을 또 매핑하려 한다면
				if(map.containsKey(input[i].charAt(j)) && map.get(input[i].charAt(j)) != plainText.charAt(j)) 
//				|| map.containsValue(input[i].charAt(j)) && map.get(input[i].charAt(j)) != plainText.charAt(j))
					// ==>최종적으로 해쉬맵을 사용한다면 이부분(51번째 라인)은 필요가 없는듯..? 
					break;
					
				else
					map.put(input[i].charAt(j), plainText.charAt(j)); // 매핑
			}
			if(j == plainText.length()) // 해당 i에 대해 정상적으로 모두 매핑되었다면
			{
				isThereMatching = true;
				break;
			}
		}
		
		if(isThereMatching)
		{
			for(i = 0; i < input.length; i++)
			{
				if(input[i] != null)
				{
					for(j = 0; j < input[i].length(); j++)
						System.out.print(map.get(input[i].charAt(j)));
					System.out.println();
				}
			}			
		}
		else
			System.out.println("No solution.");
		
		
		
	} // end of main
}
