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
		//�ʿ��� ������
		String[] input = new String[100]; // �Էµ� �� ���� ������� ������ String �迭
		HashMap<Character, Character> map = new HashMap<Character, Character>(); //������ ��ȣ�� ���ε� �ؽ���. 
		// ==> �̰� ���� �ȵȴ�. ���߿� �̾Ƴ� �� å�� ���信���� ���ε� �迭�� ���������� �ε��� �ѹ��� ���� ��������� 
		// ���⼭�� �ε����ѹ��� �ƴ� Ű���� ���� value�� ����ϱ� ������ ==> �װ� �ƴϰ�!!
		// �ι��� ���� ������ Ž���� ���Ѵ�. ==> No! ����ص� �ȴ�. 
		
//		char[] mapping = new char[26];
//		char[] inverseMapping = new char[26];
		
//		map.put(' ', ' ');
		
		int i = 0, j = 0;
		boolean isThereMatching = false;
		
		while(true) // ��ǲ�� �Է�
		{
			input[i] = sc.nextLine();
			if(input[i].equals(""))
				break;
			i++;
		}
		
		for(i = 0; i < input.length ; i++)
		{
			if(input[i].length() != plainText.length()) // ���̰� ���� ������ ã�Ƴ�
				continue;
			// �� ���ڰ� ���� �ٸ� �� ���ڿ� ���εǾ�� �ȵȴ� 
			// ���� �ٸ� �� ���ڰ� �� ���ڿ� ���εǾ�� �ȵȴ�
			// �� 1:1 �����̾�� �Ѵ�.
			// => �̹� ���εǾ� �ִµ�, �� �ٸ� ������ �����Ϸ��� �ϸ�(�� �� ���� ���̸� �������..) �н�
			
			for(j = 0; j < plainText.length(); j++)
			{
				// �ش� Ű�� �����ϰ� �ִµ�, 55��° ���ο��� ���� ���� �� �����Ϸ� �Ѵٸ�
				if(map.containsKey(input[i].charAt(j)) && map.get(input[i].charAt(j)) != plainText.charAt(j)) 
//				|| map.containsValue(input[i].charAt(j)) && map.get(input[i].charAt(j)) != plainText.charAt(j))
					// ==>���������� �ؽ����� ����Ѵٸ� �̺κ�(51��° ����)�� �ʿ䰡 ���µ�..? 
					break;
					
				else
					map.put(input[i].charAt(j), plainText.charAt(j)); // ����
			}
			if(j == plainText.length()) // �ش� i�� ���� ���������� ��� ���εǾ��ٸ�
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
