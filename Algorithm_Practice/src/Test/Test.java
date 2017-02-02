package Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Test{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		/*
		Integer[] arr = {4, 3, 2, 5, 9};
		
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
			*/
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>()
				{

					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return o2 - o1;
					}
					
				});
		
		pq.add(1);
		pq.add(15);
		pq.add(3);
		
		Iterator<Integer> it = pq.iterator();
		
		while(!pq.isEmpty())
			System.out.println(pq.poll());
	}
}
