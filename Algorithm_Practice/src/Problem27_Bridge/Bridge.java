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
		// ó���� ���� �ӵ��� ���� ��� 2����� �ݴ������� �ǳʰ�
		System.out.println("�ǳʰ� �� �ݴ��� ���");
		while(!oppositeSide.isEmpty())
			System.out.println(oppositeSide.poll());
		
		System.out.println("�ǳʰ� �� ���� ��ġ ���");
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
		
		// ù��° ���鿡 �ִ� ���� ū ����� 2���� �ݴ��� ���� ���� �������� �߰�
		System.out.print(firstSide.peek() + " ");
		oppositeSide.add(firstSide.poll()); 
		System.out.println(firstSide.peek());
		oppositeSide.add(firstSide.poll());
	}
	
	void moveFromOppositeToFirstSide()
	{
		Collections.sort(oppositeSide); // ���� �������� �ٽ� �ݴ�� �̵��ϴ� ��ƾ
		totalTime += oppositeSide.get(0);
		
		System.out.println(oppositeSide.peek());
		firstSide.add(oppositeSide.poll()); // �ݴ����� ù��° ��ġ�� �̵�
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
