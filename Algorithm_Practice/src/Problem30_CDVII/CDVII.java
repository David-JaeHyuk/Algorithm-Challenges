package Problem30_CDVII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class CDVII 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine(); // 엔터키 입력을 위해
		
		while(testCase > 0)
		{
			testCase--;
			ArrayList<String> input = new ArrayList<String>();
			TreeMap<String, Float> output = new TreeMap<String, Float>();
			
			int[] feeTable = new int[24];
			
			// 시간별 요금 테이블 정보 입력
			for(int i = 0; i < feeTable.length; i++)
				feeTable[i] = sc.nextInt();
			
			sc.nextLine();// 엔터키 입력을 위해
			
			// 사진 정보(차량번호와 날짜정보 및 입출구와 km정보) 입력
			while(true)
			{
				String inputString = sc.nextLine();
				if(inputString.equals("")) // 엔터키만 입력 시 입력 종료
					break;
				else	
					input.add(inputString);
			}
			
			// 입력된 사진 정보를 정렬 => 같은 차량의 번호들은 붙어서 정렬될 것임.
			Collections.sort(input); 
			
			/*
			Iterator<String> itr = input.iterator();
			
			while(itr.hasNext())
				System.out.println(itr.next());
			*/
			
			String month = null;
			
			// 요금값 구하고 맵에 저장하기
			for(int i = 0; i < input.size(); i++)
			{
				String[] data1 = null;
				String[] data2 = null;
				float fee = 0.0f;
				
				if(i+1 != input.size())
				{
					data1 = parsingData(input.get(i)); // 데이터 파싱
					data2 = parsingData(input.get(i+1)); // 데이터 파싱
					
					if(!data1[0].equals(data2[0])) // 인접한 두 라인이 차량번호가 다르다면 패스 => 엔터키 하나만 혹은 exit키 하나만 입력된 경우임
						continue;
					
					else if(data1[0].equals(data2[0]) && data1[5].equals(data2[5])) // 차량번호가 같지만, 똑같이 enter 또는 exit라면
						continue;
					
					else if(!data1[1].equals(data2[1])) // 같은 차량임에도 불구하고 '월(month)'이 다르다면 패스
						continue;
					
					else
					{
						if(!output.containsKey(data1[0])) // 최초 첫달 이용으로 2달러 + 최초 주행 요금 부과
						{
							output.put(data1[0], 3.0f); // data1[0]는 차량 넘버를 의미
							month = data1[1];
						}
						
						else if(output.containsKey(data1[0])) // 최초 첫달 이용이 아니고 주행횟수가 추가된 상황이라면 
						{
							float beforeFee = output.get(data1[0]);
							output.put(data1[0], beforeFee + 1.0f);
						}
						
						if(output.containsKey(data1[0]) &&!month.equals(data1[1])) // 달이 업데이트 되는 상황이라면
						{
							month = data1[1];
							float beforeFee = output.get(data1[0]);
							output.put(data1[0], beforeFee + 2.0f);
						}
						
						int hour = Integer.parseInt(data1[3]); // 시간 데이터 파싱
//						System.out.print("hour : " + hour + ", 해당 시간대에 km당 요금 : " + feeTable[hour]);
						fee = ((Integer.parseInt(data2[6]) - Integer.parseInt(data1[6])) * feeTable[hour]) / 100.0f; // 달러단위로 맞춰주기 위해 나누기 100 
//						System.out.println(", 요금 : " + fee);
						
						float beforeFee = output.get(data1[0]); // 해당 차량 넘버의 이전 요금값 뽑아내기
						output.put(data1[0], fee + beforeFee);
					}
				}
					
				
			} // end of 파싱 및 요금값 맵에 저장하는 루틴
			
			// 아웃풋 출력
			for(String key : output.keySet())
				System.out.println(String.format("차량 : %s, 요금 : $%.2f", key, output.get(key)));
		}

	} //end of main
	
	static String[] parsingData(String str)
	{
		String[] values = str.split(":|\\s"); // ':' 기호나 '스페이스바' 기호를 기준으로 데이터를 파싱
		return values;
	}
}
