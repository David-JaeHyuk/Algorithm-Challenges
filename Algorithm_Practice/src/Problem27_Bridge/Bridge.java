package Problem27_Bridge;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Bridge 
{
	LinkedList<Integer> firstSide;
	LinkedList<Integer> oppositeSide;
	int totalTime = 0;
	
	public Bridge(LinkedList<Integer> peopleSpeed)
	{
		firstSide = peopleSpeed;
		oppositeSide = new LinkedList<Integer>();
	}
	
	void firstMoving()
	{
		Collections.sort(firstSide);
		
		int a = firstSide.get(0);
		int b = firstSide.get(1);
		
		if(a > b)
			totalTime += a;
		else
			totalTime += b;
		
		System.out.print(firstSide.peek() + " ");
		oppositeSide.add(firstSide.poll());
		System.out.println(firstSide.peek());
		oppositeSide.add(firstSide.poll());

		/*
		// 처음에 가장 속도가 빠른 사람 2명부터 반대편으로 건너감
		System.out.println("건너간 뒤 반대편 사람");
		while(!oppositeSide.isEmpty())
			System.out.println(oppositeSide.poll());
		
		System.out.println("건너간 뒤 현재 위치 사람");
		while(!firstSide.isEmpty())
			System.out.println(firstSide.poll());
			*/
	}
	
	void moveFromFirstSideToOppisiteSide()
	{
		Collections.sort(firstSide);
		Collections.reverse(firstSide);
		int a = firstSide.get(0);
		int b = firstSide.get(1);
		
		if(a > b)
			totalTime += a;
		else
			totalTime += b;
		
		// 첫번째 측면에 있는 가장 큰 사람들 2명을 반대편 측면 가장 마지막에 추가
		System.out.print(firstSide.peek() + " ");
		oppositeSide.add(firstSide.poll()); 
		System.out.println(firstSide.peek());
		oppositeSide.add(firstSide.poll());
	}
	
	void moveFromOppositeToFirstSide()
	{
		Collections.sort(oppositeSide); // 제일 작은놈이 다시 반대로 이동하는 루틴
		totalTime += oppositeSide.get(0);
		
		System.out.println(oppositeSide.peek());
		firstSide.add(oppositeSide.poll()); // 반대편에서 첫번째 위치로 이동
	}
	
	void routine()
	{
		firstMoving();
		while(!firstSide.isEmpty())
		{
			moveFromOppositeToFirstSide();
			moveFromFirstSideToOppisiteSide();	
		}
		
		System.out.println(totalTime);
		
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int peopleNum = sc.nextInt();
		
		LinkedList<Integer> peopleSpeed = new LinkedList<Integer>();
		
//		Integer[] peopleSpeed = new Integer[peopleNum];
		
		for(int i = 0; i < peopleNum; i++)
			peopleSpeed.offer(sc.nextInt());
		

		
		Bridge test = new Bridge(peopleSpeed);
		test.routine();
	}

}
