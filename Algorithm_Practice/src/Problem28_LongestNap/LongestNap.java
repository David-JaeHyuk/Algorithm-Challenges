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
	
	
	// key�� �ߺ��� �� ����.
	
	public LongestNap(String[] input, int day)
	{
		this.input = input;
		this.day = day;
		sortedInput = new String[input.length];
	}
	
	private String[] parsingData(String str)
	{
		String[] values = str.split(":|\\s"); // ':' ��ȣ�� '�����̽���' ��ȣ�� �������� �����͸� �Ľ�
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
	
	void inputDataSaveIntoTreeSet() // ��ǲ �����͸� Ʈ���¿� ���������μ� �����͸� �����Ѵ�.
	{
		for(int i = 0; i < input.length; i++)
			intputTreeSet.add(input[i]);
	}
	
	void getTreeMap()
	{
		Iterator<String> itrSet = intputTreeSet.iterator();
		
		while(itrSet.hasNext())
		{
			System.out.println("��� ȣ��?");
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
			int totalScheduleNum = sc.nextInt(); // �� ������ ���� �Է¹���
			sc.nextLine(); // ����Ű �Է� ������ ����
			String[] input = new String[totalScheduleNum];
			
			for(int i = 0; i < totalScheduleNum; i++)
				input[i] = sc.nextLine();
			
			LongestNap longestNap = new LongestNap(input, day);
			longestNap.routine();
		}
	
		System.out.println("Ctrl+Z ��ư���� ���α׷��� ����Ǿ����ϴ�");
	}

}
