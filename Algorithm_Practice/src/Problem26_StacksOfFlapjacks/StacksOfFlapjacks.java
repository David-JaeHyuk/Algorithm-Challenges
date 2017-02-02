package Problem26_StacksOfFlapjacks;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StacksOfFlapjacks 
{
	int arr[];
	Queue<Integer> output_q = new LinkedList<Integer>();
	
	public StacksOfFlapjacks(int[] arr)
	{
		this.arr = arr;
	}
	
	void flip(int idx)
	{
//		System.out.println("flip �� idx : " + idx);
		Stack<Integer> flipStack = new Stack<Integer>();
		
		for(int i = arr.length -idx; i >= 0; i--)
				flipStack.push(arr[i]);
		
		for(int i = arr.length - idx; i >= 0; i--)
				arr[i] = flipStack.pop();
	}
	
	int getMaxValueInBoundIdx(int seat)
	{
		int maxIdx = 0;
		
		for(int i = 0; i <= seat; i++)
		{
			if(arr[i] > arr[maxIdx])
				maxIdx = i;
		}
//		System.out.println("maxIdx �� : " + maxIdx);
		return maxIdx;	
	}
	
	void routine()
	{
		// arr�� ���� ���� �ڸ��� üũ. üũ�Ͽ� arr �� ���� ū ���� ��� (���� ���� - 1) �ڸ� üũ.
		// ���� �� �ڸ��� �ι�°�� ū ���� ���� ��� �ι�°�� ���� ū ���� arr�� ���� ���ʿ� �� �� ���� ����ؼ� flip.
		// �ι�°�� ���� ū ���� ���� ���ʿ� ������, �ٽ� �ش� idx(�� ���� ���� -1)�� ���� flip 
		// �� ������ arr�� ���ĵ� ������ �ݺ�
		for(int seat = arr.length-1; seat >=0; seat--)
		{
//			System.out.println("###### seat for�� ����. seat ���� " + seat);
			int maxInBoundIdx = getMaxValueInBoundIdx(seat); // seat �ڽ��� �����Ͽ� ���� ū ���� �־�� �� �ڸ�
			int maxValue = arr[maxInBoundIdx];
			// �ش� �ڸ��� ���� ū ���� ���ٸ�
			if(arr[seat] != maxValue)
			{
				// ���� ū ���� ���� �տ� ������ ������ ����ؼ� flip. flip �ϴ� �������� �ش� idx�� output�� ����
				for(int i = arr.length - seat; arr[0] != maxValue ; i++)
				{
//					System.out.println("�����ڸ��� ���� ū ���� ���� ��Ȳ��. ���� seat : " + seat);
					flip(i);
					output_q.add(i);
//					System.out.println("** �ƿ�ǲ�� ����, �ش� �� : " + i);
//					maxInBoundIdx = getMaxValueInBoundIdx(seat); // ���� ū ���� �־�� �� �ڸ�
				}
				
				flip(arr.length-seat); // �ش� �ڸ��� ���� ū ���� ���� 	
				output_q.add(arr.length-seat);
				
//				int output = arr.length-seat;
//				System.out.println("** �ƿ�ǲ�� ����, �ش� �� : " + output);

			}
			else // �ش� �ڸ��� ���� ū ���� �ִٸ� ���� �ڸ� Ž��
			{
				if(seat == 0)
					output_q.add(0);
//				System.out.println("�ش��ڸ��� �����Ƿ� �ش� seat �н�. �н��� �� seat���� " + seat);
				continue;
			}
		}
		
		printOutput();
	}
	
	void printOutput()
	{
		Iterator<Integer> it = output_q.iterator();
		
		while(it.hasNext())
			System.out.print(it.next() + " ");
	}
	
	void printArr(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] != 0)
				System.out.print(arr[i] + " ");
		}
		
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���̸� �Է��ϼ��� : ");
		int arrSize = sc.nextInt();
		
		int[] arr = new int[arrSize];
		
		String a = null;
		for(int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();

		StacksOfFlapjacks thisInstance = new StacksOfFlapjacks(arr);

		thisInstance.routine();
	}

}
