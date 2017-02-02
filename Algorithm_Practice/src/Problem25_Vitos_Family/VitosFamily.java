package Problem25_Vitos_Family;

import java.util.Scanner;

public class VitosFamily 
{
	int[] arr;
	int average;
	int output;
	
	public VitosFamily(int[] arr)
	{
		this.arr = arr;
	}
	
	int getAverage()
	{
		int sum = 0, average = 0;
		for(int i = 0; i < arr.length; i++)
			sum += arr[i];
		
		average = sum/arr.length;
		return average;
	}
	
	void routine()
	{
		int[] eachLength = new int[arr.length];
		average = getAverage();
		for(int i = 0; i < arr.length; i++)
			eachLength[i] = Math.abs(arr[i] - average);
		
		for(int j = 0; j < arr.length; j++)
			output += eachLength[j];
			
		System.out.println(output);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int totalHouse = sc.nextInt();
		int[] houseArr = new int[totalHouse];
		
		for(int i = 0; i < houseArr.length; i++)
			houseArr[i] = sc.nextInt();
		
		VitosFamily vitos = new VitosFamily(houseArr);
		vitos.routine();
		
	}

}
