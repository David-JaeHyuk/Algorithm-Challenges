package Problem19_CommonPermutation;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class CommonPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Character> output = new LinkedList<Character>(); // �ƿ�ǲ�� ������ ����Ʈ.
		LinkedList<Integer> indexList = new LinkedList<Integer>(); // �ι�° ���ڿ��� �˻��� ������ �ε����� ������ ����Ʈ
		
		Scanner sc = new Scanner(System.in);
		
		String firstWord;
		String secondWord;
		int i, j;
		
		firstWord = sc.nextLine();
		secondWord = sc.nextLine();
		
		for(i = 0; i < firstWord.length(); i++) // ù��° �ܾ��� ���� ���ڿ� ���Ͽ�
			for(j = 0; j < secondWord.length(); j++) // �ι�° �ܾ ��� �˻�
			{
				if(firstWord.charAt(i) == secondWord.charAt(j))
				{
					// �ι�° �ܾ��� j�� �ش��ϴ� �ε����� �̹� �˻��� ���ڶ�� �ش� ���ڴ� Ʈ���� ���� �ʰ� ��� �ι�° �ܾ� �˻�
					if(indexList.contains(j))
						continue;
					else
					{
						output.add(firstWord.charAt(i));// ������ ���ڸ� Ʈ���� �ֱ�
						indexList.add(j); // �ش� �ε����� ���� Ʈ���� ���� �ʾҴٸ� ���� �˻��Ǿ��ٰ� ǥ��
						break; // �˻������� ù��° �ܾ��� i��° �ε����� �ִ� �ܾ ���� �ι�° ���ڿ� �˻��� �н�
					}
				}
			}
		
		Collections.sort(output);
//		Iterator<Integer> itr = list.iterator();
		Iterator<Character> itr = output.iterator();
		
		while(itr.hasNext())
			System.out.print(itr.next());
		
	}

}
