package Problem28_LongestNap;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class LongestNap
{
	String[] input;
	TreeMap<Integer, String> tMap = new TreeMap<Integer, String>();
	TreeSet<String> intputTreeSet = new TreeSet<String>();
	int day;

	public LongestNap(String[] input, int day)
	{
		this.input = input;
		this.day = day;
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
		boolean firstFlag = true;
		int beforeLastTime = 0, timeDiff = 0;

		String str_beforeLastTime = "";
		
		while(itrSet.hasNext())
		{
			if(firstFlag)
			{
				String[] line = parsingData(itrSet.next());
				String str_firstLineLastTime = getLastTime(line);
				int firstLineLastTime = Integer.parseInt(str_firstLineLastTime);	
				
				if(itrSet.hasNext()) 
				{
					line = parsingData(itrSet.next());
					String str_secondLineStartTimeCur = getStartTime(line);
					int secondLineStartTimeCur = Integer.parseInt(str_secondLineStartTimeCur);
					
					timeDiff = secondLineStartTimeCur - firstLineLastTime;
					
					String str_secondLineLastTimeCur = getLastTime(line);
					beforeLastTime = Integer.parseInt(str_secondLineLastTimeCur);
					str_beforeLastTime = Integer.toString(beforeLastTime);
					
					tMap.put(timeDiff, str_secondLineLastTimeCur);
					
					firstFlag = false;
				}
				else // �������� �Ѱ��� �Էµ� ���
				{
					timeDiff = 1760 - firstLineLastTime;
					
					
					if(!tMap.containsKey(timeDiff)) // �ش� Ű�� �����ϰ� ���� �ʴٸ� ����. Ű�� �����ϰ� �ִٴ� ���� ������ �ð��� �����ϰ��ִٴ� ����.
						tMap.put(timeDiff, str_firstLineLastTime);
				}
				
			}
			else // �ι�° �� ���ĺ��� ó��
			{
				String[] line = parsingData(itrSet.next());
				String str_startTimeCur = getStartTime(line);
				int startTimeCur = Integer.parseInt(str_startTimeCur);
				
				timeDiff = startTimeCur - beforeLastTime;
				
				if(!tMap.containsKey(timeDiff)) // �ش� Ű�� �����ϰ� ���� �ʴٸ� ����. Ű�� �����ϰ� �ִٴ� ���� ������ �ð��� �����ϰ��ִٴ� ����.
					tMap.put(timeDiff, str_beforeLastTime);

				String str_lastTimeCur = getLastTime(line);
				beforeLastTime = Integer.parseInt(str_lastTimeCur); // ���� �ð� ������Ʈ
				str_beforeLastTime = Integer.toString(beforeLastTime);
				
				if(!itrSet.hasNext()) // �������� �̶��
				{
					String str_curLastTime = getLastTime(line);
					int curLastTime = Integer.parseInt(str_curLastTime);
					timeDiff = 1760 - curLastTime;
					
					if(!tMap.containsKey(timeDiff)) // �ش� Ű�� �����ϰ� ���� �ʴٸ� ����. Ű�� �����ϰ� �ִٴ� ���� ������ �ð��� �����ϰ��ִٴ� ����.
						tMap.put(timeDiff, str_curLastTime);
				}
			}
		}
		
	}
	
	void printOutput()
	{
//		String key = tMap.lastKey();
		
		Map.Entry<Integer, String> entry = tMap.lastEntry();
//		System.out.println("last entry ���� : " + entry.getKey() + ", " + entry.getValue());
		
		int hour = 0, minutes = 0;
		int key = entry.getKey();
		String value = entry.getValue();
		
		if(key < 100)
		{
			hour = key/60;
			minutes = key%60;
		}
		else
		{
			hour = key/100;
			minutes = key%100;
		}
		/*
		char[] temp1 = new char[2];
		char[] temp2 = new char[2];
		temp1[0] = value.charAt(0);
		temp1[1] = value.charAt(1);
		temp2[0] = value.charAt(2);
		temp2[1] = value.charAt(3);
		
		String a = new String(temp1);
		String b = new String(temp2);
		*/
		String a = value.substring(0, 2);
		String b = value.substring(2, 4);
		
		String startTime = a + ":" + b;
	
		if(hour != 0 && minutes != 0)
		{
			if(minutes == 60)
			{
				hour++;
				minutes = 0;
				System.out.println("Day #" + day + ": the longest nap starts at " + startTime + " and will last for " + hour + " hours and " + minutes + " minutes.");
			}
			else
				System.out.println("Day #" + day + ": the longest nap starts at " + startTime + " and will last for " + hour + " hours and " + minutes + " minutes.");
		}
			
		else if(hour == 0 && minutes != 0)
			System.out.println("Day #" + day + ": the longest nap starts at " + startTime + " and will last for " + minutes + " minutes.");
		
		/*
		Set<Map.Entry<Integer, String>> set1 = tMap.entrySet();
		Iterator<Map.Entry<Integer, String>> it1 = set1.iterator();
		
		while(it1.hasNext())
		{
			Map.Entry<Integer, String> e = it1.next();
			System.out.println("���ڴ� �ð� : " + e.getKey() + ", ���ڱ� ������ �ð� : " + e.getValue());
		}
		 */
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
