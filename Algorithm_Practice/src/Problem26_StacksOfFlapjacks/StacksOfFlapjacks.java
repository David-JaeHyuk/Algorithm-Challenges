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
//		System.out.println("flip 시 idx : " + idx);
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
//		System.out.println("maxIdx 값 : " + maxIdx);
		return maxIdx;	
	}
	
	void routine()
	{
		// arr의 가장 뒷쪽 자리를 체크. 체크하여 arr 중 가장 큰 값일 경우 (가장 뒷쪽 - 1) 자리 체크.
		// 만일 그 자리에 두번째로 큰 값이 없을 경우 두번째로 가장 큰 값이 arr의 가장 앞쪽에 올 때 까지 계속해서 flip.
		// 두번째로 가장 큰 값이 가장 앞쪽에 왔으면, 다시 해당 idx(즉 가장 뒷쪽 -1)에 대해 flip 
		// 위 과정을 arr가 정렬될 떄까지 반복
		for(int seat = arr.length-1; seat >=0; seat--)
		{
//			System.out.println("###### seat for문 시작. seat 값은 " + seat);
			int maxInBoundIdx = getMaxValueInBoundIdx(seat); // seat 자신을 포함하여 가장 큰 값이 있어야 할 자리
			int maxValue = arr[maxInBoundIdx];
			// 해당 자리에 가장 큰 값이 없다면
			if(arr[seat] != maxValue)
			{
				// 가장 큰 값을 가장 앞에 가져올 때까지 계속해서 flip. flip 하는 과정에서 해당 idx를 output에 저장
				for(int i = arr.length - seat; arr[0] != maxValue ; i++)
				{
//					System.out.println("해장자리에 가장 큰 값이 없는 상황임. 현재 seat : " + seat);
					flip(i);
					output_q.add(i);
//					System.out.println("** 아웃풋에 저장, 해당 값 : " + i);
//					maxInBoundIdx = getMaxValueInBoundIdx(seat); // 가장 큰 값이 있어야 할 자리
				}
				
				flip(arr.length-seat); // 해당 자리에 가장 큰 값을 넣음 	
				output_q.add(arr.length-seat);
				
//				int output = arr.length-seat;
//				System.out.println("** 아웃풋에 저장, 해당 값 : " + output);

			}
			else // 해당 자리에 가장 큰 값이 있다면 다음 자리 탐색
			{
				if(seat == 0)
					output_q.add(0);
//				System.out.println("해당자리에 있으므로 해당 seat 패스. 패스할 때 seat값은 " + seat);
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
		System.out.print("팬케익 높이를 입력하세요 : ");
		int arrSize = sc.nextInt();
		
		int[] arr = new int[arrSize];
		
		String a = null;
		for(int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();

		StacksOfFlapjacks thisInstance = new StacksOfFlapjacks(arr);

		thisInstance.routine();
	}

}
