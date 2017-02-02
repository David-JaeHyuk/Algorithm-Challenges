package Problem21_AutomatedJudgeScript;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AutomatedJudgeScript 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int n;
		int run = 0;
		Scanner sc = new Scanner(System.in);		
		
		while((n = sc.nextInt()) != 0)
		{
			sc.nextLine(); // 엔터키 입력을 위해
			run++; //run 한 개 증가
			
			String result = "Accepted";
			int i, j;
			
			String[] inputA = new String[n]; // 각 케이스 마다 사용자가 제출한 n개의 문자열 입력 정보
			
			for(i = 0; i < inputA.length; i++)
				inputA[i] = sc.nextLine();
			
			int m = sc.nextInt();
			sc.nextLine();
			
			int[] parsingNumA = new int[m];
			int[] parsingNumB = new int[n];
			
			String[] inputB = new String[m]; // 각 케이스 마다 실제 경진대회의 정답 m개의 문자열에 대한 인풋 정보
			
			for(i = 0; i < inputB.length; i++)
				inputB[i] = sc.nextLine();
			
			Queue<Character> qA; 
			Queue<Character> qB;
			
			LinkedList<Queue<Character>> listA = new LinkedList<Queue<Character>>(); // 사용자가 제출한 정답 정보에 대한 라인들의 큐 정보를 담을 리스트
			LinkedList<Queue<Character>> listB = new LinkedList<Queue<Character>>(); // 실제 정답의 정보에 대한 라인들의 큐 정보를 담을 리스트
			
			// 문자열 입력받은 것들을 하나하나 파싱하되, 파싱해서 숫자면 인큐, 숫자가 아니면 버림. 파싱할때마다 parsingNum++
			for(i = 0; i < inputA.length; i++) // inputA의 첫번째 데이터 파싱
			{
				qA = new LinkedList<Character>();
				for(j = 0; j < inputA[i].length(); j++)
				{
					if(inputA[i].charAt(j) >= '0' && inputA[i].charAt(j) <= '9') // 숫자라면
						qA.offer(inputA[i].charAt(j)); // 해당 숫자를 큐에 넣는다
					parsingNumA[i]++;
				}
				listA.add(qA); // 해당 q를 i번째 LinkedList에 넣는다.
				//qA.clear(); // 인풋 A의 다음 문자열에 대한 숫자들을 파싱하기 위해 qA를 비운다.	
			}
			
			// 인풋 B에 대해서도 마찬가지로 수행
			for(i = 0; i < inputB.length; i++) // inputA의 첫번째 데이터 파싱
			{
				qB = new LinkedList<Character>();
				for(j = 0; j < inputB[i].length(); j++)
				{
					if(inputB[i].charAt(j) >= '0' && inputB[i].charAt(j) <= '9') // 숫자라면
						qB.offer(inputB[i].charAt(j)); // 해당 숫자를 큐에 넣는다
					parsingNumB[i]++;
				}
				listB.add(qB); // 해당 q를 i번째 LinkedList에 넣는다.
				//qB.clear(); // 인풋 B의 다음 문자열에 대한 숫자들을 파싱하기 위해 qA를 비운다.	
			}
			
			/*
			Iterator<Character> itr;
			
			//qA에 데이터가 잘 들어갔는지 테스트
			for(i = 0; i < listA.size(); i++)
			{
				itr = listA.get(i).iterator();
				while(itr.hasNext())
					System.out.print(itr.next());	
				System.out.println();
			}
			
			//qB에 데이터가 잘 들어갔는지 테스트
			for(i = 0; i < listB.size(); i++)
			{
				itr = listB.get(i).iterator();
				while(itr.hasNext())
					System.out.print(itr.next());	
				System.out.println();
			}
			*/
			
			// 결과 출력
			// parsingNumA와 parsingNumB가 같으면서 qA와 qB가 같다면 완전히 동일
			// parsingNumA와 parsingNumB가 다르면서 qA와 qB가 같다면 presentation error
			for(i = 0; i < inputA.length; i++)
			{
				if(parsingNumA[i] == parsingNumB[i] && listA.get(i).equals(listB.get(i)))
				{
					if(listA.get(i).isEmpty()) // 파싱 넘버가 똑같고 큐도 같은데 큐가 비어있는 경우는 문장에 숫자가 하나도 입력되지 않되
						//문자열의 길이는 똑같은 경우이다. 
						result = "Presentation Error";
					else
						continue; // 완전히 일치하므로 패스
				}
					
					
				else if(listA.get(i).equals(listB.get(i)))
					result = "Presentation Error";
			
				else
					result = "Wrong Answer";
					
			}
			System.out.println("Run #" + run + ": " + result);
		}	
	}

}
