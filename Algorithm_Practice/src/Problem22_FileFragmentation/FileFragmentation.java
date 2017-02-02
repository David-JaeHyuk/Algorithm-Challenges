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
		
		String[] inputStr = new String[144*2]; // ���� ���ǿ��� ������ ������ 144�� ���϶�� �Ͽ����Ƿ� ��ǲ���� 288�������� ��� ����
		
		int totalInputSum = 0, outputLength = 0;
		int testCase = 0;
		int inputNum = 0;
		
		testCase = sc.nextInt();
		sc.nextLine(); // ������ �׽�Ʈ ���̽� ���� �Է� �� ���Ͱ� �Է��� ����
		sc.nextLine(); // ������ ���� ���Ͱ� �Է��� ����(���� �ٿ��ֱ�� �Է�)
		
		// input ���� �Է¹���
		while(true) 
		{
			inputStr[inputNum] = sc.nextLine();
			if(inputStr[inputNum].equals(""))
				break;
			inputNum++;
		}
		
		// �� inputStr�� ��� ������ ���� ����
		for(int i = 0; inputStr[i] != null; i++)
			totalInputSum += inputStr[i].length();
		
		N = inputNum/2; // N�� ����� ���;� �ϴ� ����
		outputLength = totalInputSum/N; //outputLength�� ����� �� ����(���� ���ǿ� ���� ������ �� ���̴�� �ƿ�ǲ�� ���;���)

		// Ž�� ����
		int searchScope = -1;
		for(int i = 0; inputStr[i] != null; i++)
			searchScope++;
		
		System.out.println(searchOutput(inputStr, outputLength, N, searchScope));
	}

	// �ƿ�ǲ�� ã��
	static String searchOutput(String[] inputStr, int outputLength, int N, int searchScope)
	{
		LinkedList<String[]> saveList = new LinkedList<String[]>();
		
		String [] eachOutputPerI; // �� ��ǲ���� ������ �̷� string �迭
		
		//��� inputStr�� ���� outputLength�� ���� �� �ִ� ��� ������ ���Ͽ� ����Ʈ�� �ִ´�.
		for(int i = 0; i < searchScope; i++)
		{
			eachOutputPerI = new String[searchScope]; // (��ǲ ����-1��) ��ŭ �Ҵ�(�ڱ� �ڽŰ��� ������ �����Ƿ�)
			for(int j = 0; j < searchScope; j++) // 
			{
				if(i != j) // �Է� �ڱ� �ڽŰ��� ���� ���� ���� �����Ƿ�.
				{
					eachOutputPerI[j] = inputStr[i].concat(inputStr[j]);
					if(eachOutputPerI[j].length() != outputLength) // ���� �ƿ�ǲ�� ��¿� ���� ���̿� ���� �ʴٸ� �ٽ� null�� �ʱ�ȭ
					{
						eachOutputPerI[j] = null;
						continue;
					}
				}
					
			}
			saveList.add(eachOutputPerI); // ���̰� outputLength�� ���� �༮���� ����Ǿ� ��. �ƴ� �༮���� null�� �� ���� ����
			// �� inputStr�� ���� ��ŭ ����Ʈ�� ����ؼ� add.
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
		System.out.println("list ���� : " + saveList.size());
		String output = "No";
		
		//Ž��.
		for(int i  = 0; i < saveList.size() -1; i++) // ����Ʈ�� 0��°���� Ž�� ����
		{
			String[] listStr = saveList.get(i);
			
			for(int j = 0; j < listStr.length; j++)
			{
				int count = 1;
			
				if(listStr[j] != null && searchSameComponent(saveList, i+1, listStr[j], count)) // �ι�° ���ڰ� ����Ʈ�� �ѹ�
				{
					output = listStr[j];
					return output;	
				}		
			}
		}
		return output; // ��� Ž���ߴµ� ���� j for������ return���� �ʾ����� ���°Ŵ�. No�� ���� 
	}
	
	// ��ũ������Ʈ ���� ����� ��� String���� �˻�. ��� Ȱ��.
	static boolean searchSameComponent(LinkedList<String[]> saveList, int curListIdx, String str, int count) // ���� curIdx�� 1, str�� ������ �������� ���ư��� ��
	{
		String[] curStr;
		if(count == N) // N��ŭ �ش� str�� �ִٸ� ����
			return true;
		
			curStr = saveList.get(curListIdx);

			for(int i = 0; i < curStr.length; i++)
			{
				if(curStr[i] != null && curStr[i].equals(str))
				{
					count++;
					System.out.println("���� str�� " + str + "�̰� count++��. ���� count : " + count);
					if(searchSameComponent(saveList, curListIdx+1, str, count));
						return true;
				}
			}
			return false; // �ݺ��� �� �����ôµ� ������ ���°���
	}
}
