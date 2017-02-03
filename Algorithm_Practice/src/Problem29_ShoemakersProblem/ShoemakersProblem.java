package Problem29_ShoemakersProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShoemakersProblem 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer[]> inputList = null;
		
		int tastCase = sc.nextInt();

		sc.nextLine();
		System.out.println();
		
		// 테스트 케이스만큼 반복
		for(int i = 0; i < tastCase; i++)
		{
			int workNumber = sc.nextInt();
			int[] output = new int[workNumber];
			
			inputList = new ArrayList<Integer[]>();
			
			// 인풋 데이터 입력
			for(int j = 0; j < workNumber; j++)
			{
				Integer[] line = new Integer[2];
				line[0] = sc.nextInt();
				line[1] = sc.nextInt();
				inputList.add(line);
				output[j] = j; // 아웃풋 데이터를 초기화
			}
			
			// 버블정렬을 통해서 우선순위가 높은 일부터 처리
			for(int m = 0; m < inputList.size()-1; m++)
				for(int k = 0; k < (inputList.size()-m)-1; k++)
				{
					Integer[] first = inputList.get(k);
					Integer[] second = inputList.get(k+1);
					
					int ad = first[0]*second[1];
					int bc = first[1]*second[0];
					
					if(ad > bc)
					{
						// 아웃풋 인덱스 스왑
						int temp = output[k];
						output[k] = output[k+1];
						output[k+1] = temp;
						
						// ArrayList 스왑
						Collections.swap(inputList, k, k+1);
					}
					else if(ad == bc)
					{
						// 인덱스 사전 편찬 순서대로 아웃풋을 저장하기 위한 루틴
						if(output[k] > output[k+1])
						{
							// 아웃풋 인덱스 스왑
							int temp = output[k];
							output[k] = output[k+1];
							output[k+1] = temp;
						}
					}	
				}
		
			// 아웃풋 출력
			for(int z = 0; z < output.length; z++)
			{
				output[z]++; // 위에서 output의 인덱스를 0부터 시작했으므로, 문제에서 원하는 답으로 지정하기 위해 1씩 더해줌
				System.out.print(output[z] + " ");
			}
				
			System.out.println();
			System.out.println();
				
		}
	} // end of main

}
