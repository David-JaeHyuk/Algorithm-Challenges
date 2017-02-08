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
		sc.nextLine(); // ����Ű �Է��� ����
		
		while(testCase > 0)
		{
			testCase--;
			ArrayList<String> input = new ArrayList<String>();
			TreeMap<String, Float> output = new TreeMap<String, Float>();
			
			int[] feeTable = new int[24];
			
			// �ð��� ��� ���̺� ���� �Է�
			for(int i = 0; i < feeTable.length; i++)
				feeTable[i] = sc.nextInt();
			
			sc.nextLine();// ����Ű �Է��� ����
			
			// ���� ����(������ȣ�� ��¥���� �� ���ⱸ�� km����) �Է�
			while(true)
			{
				String inputString = sc.nextLine();
				if(inputString.equals("")) // ����Ű�� �Է� �� �Է� ����
					break;
				else	
					input.add(inputString);
			}
			
			// �Էµ� ���� ������ ���� => ���� ������ ��ȣ���� �پ ���ĵ� ����.
			Collections.sort(input); 
			
			/*
			Iterator<String> itr = input.iterator();
			
			while(itr.hasNext())
				System.out.println(itr.next());
			*/
			
			String month = null;
			
			// ��ݰ� ���ϰ� �ʿ� �����ϱ�
			for(int i = 0; i < input.size(); i++)
			{
				String[] data1 = null;
				String[] data2 = null;
				float fee = 0.0f;
				
				if(i+1 != input.size())
				{
					data1 = parsingData(input.get(i)); // ������ �Ľ�
					data2 = parsingData(input.get(i+1)); // ������ �Ľ�
					
					if(!data1[0].equals(data2[0])) // ������ �� ������ ������ȣ�� �ٸ��ٸ� �н� => ����Ű �ϳ��� Ȥ�� exitŰ �ϳ��� �Էµ� �����
						continue;
					
					else if(data1[0].equals(data2[0]) && data1[5].equals(data2[5])) // ������ȣ�� ������, �Ȱ��� enter �Ǵ� exit���
						continue;
					
					else if(!data1[1].equals(data2[1])) // ���� �����ӿ��� �ұ��ϰ� '��(month)'�� �ٸ��ٸ� �н�
						continue;
					
					else
					{
						if(!output.containsKey(data1[0])) // ���� ù�� �̿����� 2�޷� + ���� ���� ��� �ΰ�
						{
							output.put(data1[0], 3.0f); // data1[0]�� ���� �ѹ��� �ǹ�
							month = data1[1];
						}
						
						else if(output.containsKey(data1[0])) // ���� ù�� �̿��� �ƴϰ� ����Ƚ���� �߰��� ��Ȳ�̶�� 
						{
							float beforeFee = output.get(data1[0]);
							output.put(data1[0], beforeFee + 1.0f);
						}
						
						if(output.containsKey(data1[0]) &&!month.equals(data1[1])) // ���� ������Ʈ �Ǵ� ��Ȳ�̶��
						{
							month = data1[1];
							float beforeFee = output.get(data1[0]);
							output.put(data1[0], beforeFee + 2.0f);
						}
						
						int hour = Integer.parseInt(data1[3]); // �ð� ������ �Ľ�
//						System.out.print("hour : " + hour + ", �ش� �ð��뿡 km�� ��� : " + feeTable[hour]);
						fee = ((Integer.parseInt(data2[6]) - Integer.parseInt(data1[6])) * feeTable[hour]) / 100.0f; // �޷������� �����ֱ� ���� ������ 100 
//						System.out.println(", ��� : " + fee);
						
						float beforeFee = output.get(data1[0]); // �ش� ���� �ѹ��� ���� ��ݰ� �̾Ƴ���
						output.put(data1[0], fee + beforeFee);
					}
				}
					
				
			} // end of �Ľ� �� ��ݰ� �ʿ� �����ϴ� ��ƾ
			
			// �ƿ�ǲ ���
			for(String key : output.keySet())
				System.out.println(String.format("���� : %s, ��� : $%.2f", key, output.get(key)));
		}

	} //end of main
	
	static String[] parsingData(String str)
	{
		String[] values = str.split(":|\\s"); // ':' ��ȣ�� '�����̽���' ��ȣ�� �������� �����͸� �Ľ�
		return values;
	}
}
