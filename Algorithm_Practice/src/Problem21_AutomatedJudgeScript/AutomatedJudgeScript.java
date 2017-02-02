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
			sc.nextLine(); // ����Ű �Է��� ����
			run++; //run �� �� ����
			
			String result = "Accepted";
			int i, j;
			
			String[] inputA = new String[n]; // �� ���̽� ���� ����ڰ� ������ n���� ���ڿ� �Է� ����
			
			for(i = 0; i < inputA.length; i++)
				inputA[i] = sc.nextLine();
			
			int m = sc.nextInt();
			sc.nextLine();
			
			int[] parsingNumA = new int[m];
			int[] parsingNumB = new int[n];
			
			String[] inputB = new String[m]; // �� ���̽� ���� ���� ������ȸ�� ���� m���� ���ڿ��� ���� ��ǲ ����
			
			for(i = 0; i < inputB.length; i++)
				inputB[i] = sc.nextLine();
			
			Queue<Character> qA; 
			Queue<Character> qB;
			
			LinkedList<Queue<Character>> listA = new LinkedList<Queue<Character>>(); // ����ڰ� ������ ���� ������ ���� ���ε��� ť ������ ���� ����Ʈ
			LinkedList<Queue<Character>> listB = new LinkedList<Queue<Character>>(); // ���� ������ ������ ���� ���ε��� ť ������ ���� ����Ʈ
			
			// ���ڿ� �Է¹��� �͵��� �ϳ��ϳ� �Ľ��ϵ�, �Ľ��ؼ� ���ڸ� ��ť, ���ڰ� �ƴϸ� ����. �Ľ��Ҷ����� parsingNum++
			for(i = 0; i < inputA.length; i++) // inputA�� ù��° ������ �Ľ�
			{
				qA = new LinkedList<Character>();
				for(j = 0; j < inputA[i].length(); j++)
				{
					if(inputA[i].charAt(j) >= '0' && inputA[i].charAt(j) <= '9') // ���ڶ��
						qA.offer(inputA[i].charAt(j)); // �ش� ���ڸ� ť�� �ִ´�
					parsingNumA[i]++;
				}
				listA.add(qA); // �ش� q�� i��° LinkedList�� �ִ´�.
				//qA.clear(); // ��ǲ A�� ���� ���ڿ��� ���� ���ڵ��� �Ľ��ϱ� ���� qA�� ����.	
			}
			
			// ��ǲ B�� ���ؼ��� ���������� ����
			for(i = 0; i < inputB.length; i++) // inputA�� ù��° ������ �Ľ�
			{
				qB = new LinkedList<Character>();
				for(j = 0; j < inputB[i].length(); j++)
				{
					if(inputB[i].charAt(j) >= '0' && inputB[i].charAt(j) <= '9') // ���ڶ��
						qB.offer(inputB[i].charAt(j)); // �ش� ���ڸ� ť�� �ִ´�
					parsingNumB[i]++;
				}
				listB.add(qB); // �ش� q�� i��° LinkedList�� �ִ´�.
				//qB.clear(); // ��ǲ B�� ���� ���ڿ��� ���� ���ڵ��� �Ľ��ϱ� ���� qA�� ����.	
			}
			
			/*
			Iterator<Character> itr;
			
			//qA�� �����Ͱ� �� ������ �׽�Ʈ
			for(i = 0; i < listA.size(); i++)
			{
				itr = listA.get(i).iterator();
				while(itr.hasNext())
					System.out.print(itr.next());	
				System.out.println();
			}
			
			//qB�� �����Ͱ� �� ������ �׽�Ʈ
			for(i = 0; i < listB.size(); i++)
			{
				itr = listB.get(i).iterator();
				while(itr.hasNext())
					System.out.print(itr.next());	
				System.out.println();
			}
			*/
			
			// ��� ���
			// parsingNumA�� parsingNumB�� �����鼭 qA�� qB�� ���ٸ� ������ ����
			// parsingNumA�� parsingNumB�� �ٸ��鼭 qA�� qB�� ���ٸ� presentation error
			for(i = 0; i < inputA.length; i++)
			{
				if(parsingNumA[i] == parsingNumB[i] && listA.get(i).equals(listB.get(i)))
				{
					if(listA.get(i).isEmpty()) // �Ľ� �ѹ��� �Ȱ��� ť�� ������ ť�� ����ִ� ���� ���忡 ���ڰ� �ϳ��� �Էµ��� �ʵ�
						//���ڿ��� ���̴� �Ȱ��� ����̴�. 
						result = "Presentation Error";
					else
						continue; // ������ ��ġ�ϹǷ� �н�
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
