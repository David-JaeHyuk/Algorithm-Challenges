package Problem28_LongestNap;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LongestNap
{
	String[] input;
	String[] sortedInput;
	TreeMap<String, String> tMap = new TreeMap<String, String>();
	TreeSet<String> intputTreeSet = new TreeSet<String>();
	int day;
	
	
	// key가 중복될 수 없다.
	
	public LongestNap(String[] input, int day)
	{
		this.input = input;
		this.day = day;
		sortedInput = new String[input.length];
	}
	
	private String[] parsingData(String str)
	{
		String[] values = str.split(":|\\s"); // ':' 기호나 '스페이스바' 기호를 기준으로 데이터를 파싱
		return values;
	}
	
	private String getLastTime(String[] values)
	{
		String lastTime = "";
		
		for(int i = 2; i < 4; i++)
			lastTime += values[i]; 
		
		return lastTime;
	}
	
	private String getStartTime(String[] values)
	{
		String startTime = "";
		
		for(int i = 0; i < 2; i++)
			startTime += values[i]; 
		
		return startTime;
	}
	
	void inputDataSaveIntoTreeSet() // 인풋 데이터를 트리셋에 저장함으로서 데이터를 정렬한다.
	{
		for(int i = 0; i < input.length; i++)
			intputTreeSet.add(input[i]);
	}
	
	void getTreeMap()
	{
		Iterator<String> itrSet = intputTreeSet.iterator();
		
		while(itrSet.hasNext())
		{
			System.out.println("몇번 호출?");
			String[] valuesPre = parsingData(itrSet.next());
			String str_lastTimePre = getLastTime(valuesPre);
			int lastTimePre = Integer.parseInt(str_lastTimePre);
			
			if(itrSet.hasNext())
			{
				String[] valuesNext = parsingData(itrSet.next());
				String str_startTimeNext = getStartTime(valuesNext);
				int startTimeNext = Integer.parseInt(str_startTimeNext);
				
				int TimeDiff = startTimeNext - lastTimePre;
				System.out.println(TimeDiff);
			}

		}
	}
	
	void printOutput()
	{
		
		
	}
	
	void routine()
	{
		inputDataSaveIntoTreeSet();
		getTreeMap();
		printOutput();
	}
	

	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int day = 0;
		
		while(sc.hasNextInt())
		{
			day++;
			int totalScheduleNum = sc.nextInt(); // 총 스케쥴 갯수 입력받음
			sc.nextLine(); // 엔터키 입력 방지를 위해
			String[] input = new String[totalScheduleNum];
			
			for(int i = 0; i < totalScheduleNum; i++)
				input[i] = sc.nextLine();
			
			LongestNap longestNap = new LongestNap(input, day);
			longestNap.routine();
		}
	
		System.out.println("Ctrl+Z 버튼으로 프로그램이 종료되었습니다");
	}

}
