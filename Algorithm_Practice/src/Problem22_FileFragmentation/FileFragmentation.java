package Problem22_FileFragmentation;

import java.util.LinkedList;
import java.util.Scanner;

public class FileFragmentation 
{
	static int N = 0;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String[] inputStr = new String[144*2]; // 문제 조건에서 파일의 갯수는 144개 이하라고 하였으므로 인풋값은 288개까지만 허용 가능
		
		int totalInputSum = 0, outputLength = 0;
		int testCase = 0;
		int inputNum = 0;
		
		testCase = sc.nextInt();
		sc.nextLine(); // 위에서 테스트 케이스 숫자 입력 시 엔터값 입력을 위해
		sc.nextLine(); // 개행을 위한 엔터값 입력을 위해(복사 붙여넣기로 입력)
		
		// input 값을 입력받음
		while(true) 
		{
			inputStr[inputNum] = sc.nextLine();
			if(inputStr[inputNum].equals(""))
				break;
			inputNum++;
		}
		
		// 각 inputStr의 모든 길이의 합을 구함
		for(int i = 0; inputStr[i] != null; i++)
			totalInputSum += inputStr[i].length();
		
		N = inputNum/2; // N은 출력이 나와야 하는 갯수
		outputLength = totalInputSum/N; //outputLength는 출력이 될 길이(문제 조건에 의해 무조건 이 길이대로 아웃풋이 나와야함)

		// 탐색 시작
		int searchScope = -1;
		for(int i = 0; inputStr[i] != null; i++)
			searchScope++;
		
		System.out.println(searchOutput(inputStr, outputLength, N, searchScope));
	}

	// 아웃풋을 찾기
	static String searchOutput(String[] inputStr, int outputLength, int N, int searchScope)
	{
		LinkedList<String[]> saveList = new LinkedList<String[]>();
		
		String [] eachOutputPerI; // 각 인풋마다 조합을 이룰 string 배열
		
		//모든 inputStr에 대해 outputLength를 만들 수 있는 모든 조합을 구하여 리스트에 넣는다.
		for(int i = 0; i < searchScope; i++)
		{
			eachOutputPerI = new String[searchScope]; // (인풋 개수-1개) 만큼 할당(자기 자신과는 조합이 없으므로)
			for(int j = 0; j < searchScope; j++) // 
			{
				if(i != j) // 입력 자기 자신과의 합은 말이 되지 않으므로.
				{
					eachOutputPerI[j] = inputStr[i].concat(inputStr[j]);
					if(eachOutputPerI[j].length() != outputLength) // 만들어낸 아웃풋이 출력에 나올 길이와 같지 않다면 다시 null로 초기화
					{
						eachOutputPerI[j] = null;
						continue;
					}
				}
					
			}
			saveList.add(eachOutputPerI); // 길이가 outputLength와 같은 녀석들은 저장되어 들어감. 아닌 녀석들은 null로 들어가 있을 것임
			// 총 inputStr의 길이 만큼 리스트에 계속해서 add.
		} // end of for i
		
		/*
		Iterator<String[]> itr = saveList.iterator();
		
		while(itr.hasNext())
		{
			String [] test = itr.next();
			for(int i = 0; i < test.length; i++)
				System.out.print(test[i] + " ");
			System.out.println();
		}
		*/
		System.out.println("list 길이 : " + saveList.size());
		String output = "No";
		
		//탐색.
		for(int i  = 0; i < saveList.size() -1; i++) // 리스트의 0번째부터 탐색 시작
		{
			String[] listStr = saveList.get(i);
			
			for(int j = 0; j < listStr.length; j++)
			{
				int count = 1;
			
				if(listStr[j] != null && searchSameComponent(saveList, i+1, listStr[j], count)) // 두번째 인자가 리스트의 넘버
				{
					output = listStr[j];
					return output;	
				}		
			}
		}
		return output; // 모두 탐색했는데 위에 j for문에서 return되지 않았으면 없는거다. No를 리턴 
	}
	
	// 링크스리스트 내에 저장된 모든 String들을 검색. 재귀 활용.
	static boolean searchSameComponent(LinkedList<String[]> saveList, int curListIdx, String str, int count) // 최초 curIdx는 1, str은 위에서 포문으로 돌아가는 값
	{
		String[] curStr;
		if(count == N) // N만큼 해당 str이 있다면 리턴
			return true;
		
			curStr = saveList.get(curListIdx);

			for(int i = 0; i < curStr.length; i++)
			{
				if(curStr[i] != null && curStr[i].equals(str))
				{
					count++;
					System.out.println("현재 str은 " + str + "이고 count++됨. 현재 count : " + count);
					if(searchSameComponent(saveList, curListIdx+1, str, count));
						return true;
				}
			}
			return false; // 반복문 다 돌려봤는데 없으면 없는거임
	}
}
