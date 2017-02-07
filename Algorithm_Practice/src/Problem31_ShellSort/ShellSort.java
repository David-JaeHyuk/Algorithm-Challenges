package Problem31_ShellSort;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ShellSort 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		while(testCase > 0)
		{
			testCase--;
			LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
			ArrayList<String> list1 = new ArrayList<String>();
			ArrayList<String> list2 = new ArrayList<String>();
			
			int n = sc.nextInt(); // 2n은 반복해서 입력받을 값
			sc.nextLine(); // 엔터키 입력을 위해
			
			// 각 인풋을 입
			for(int i = 0; i < n; i++)
				list1.add(sc.nextLine());
			
			for(int i = 0; i < n; i++)
				list2.add(sc.nextLine());
			
			// 각 인풋을 넘버링
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
				{
					if(list1.get(i).equals(list2.get(j)))
						map.put(list1.get(i), j);
				}
			}

//			for( String key : map.keySet() )
//	            System.out.println( String.format("키 : %s, 값 : %s", key, map.get(key)) );
			
			// 초항이 스택의 맨 밑, 등차가 1인 연속된 등차수열의 끝 값을 검색.
	        int curNum = 0;
	        
	        int beforeNum = map.get(list1.get(list1.size()-1));
//	        System.out.println("first before is " + beforeNum);
	        
			for(int i = map.size()-2; i >=0; i--)
			{
				curNum = map.get(list1.get(i));
			
				if(Math.abs(beforeNum - curNum) != 1)
				{
//					System.out.println("스킵한 값 : " + list1.get(i));
					continue;
				}
				beforeNum = curNum;
			}
			
//			System.out.println("수열의 가장 끝 값 : " + beforeNum);
			
			for(int i = beforeNum-1; i >=0; i--)
				System.out.println(list2.get(i));
					
		}
	
	}
}
