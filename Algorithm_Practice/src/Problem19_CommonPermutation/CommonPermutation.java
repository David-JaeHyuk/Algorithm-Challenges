package Problem19_CommonPermutation;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class CommonPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Character> output = new LinkedList<Character>(); // 아웃풋을 저장할 리스트.
		LinkedList<Integer> indexList = new LinkedList<Integer>(); // 두번째 문자열의 검색된 문자의 인덱스를 저장할 리스트
		
		Scanner sc = new Scanner(System.in);
		
		String firstWord;
		String secondWord;
		int i, j;
		
		firstWord = sc.nextLine();
		secondWord = sc.nextLine();
		
		for(i = 0; i < firstWord.length(); i++) // 첫번째 단어의 각각 문자에 대하여
			for(j = 0; j < secondWord.length(); j++) // 두번째 단어를 모두 검색
			{
				if(firstWord.charAt(i) == secondWord.charAt(j))
				{
					// 두번째 단어의 j에 해당하는 인덱스가 이미 검색된 문자라면 해당 문자는 트리에 넣지 않고 계속 두번째 단어 검색
					if(indexList.contains(j))
						continue;
					else
					{
						output.add(firstWord.charAt(i));// 동일한 문자를 트리에 넣기
						indexList.add(j); // 해당 인덱스가 아직 트리에 들어가지 않았다면 이제 검색되었다고 표시
						break; // 검색했으니 첫번째 단어의 i번째 인덱스에 있는 단어에 대한 두번째 문자열 검색은 패스
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
