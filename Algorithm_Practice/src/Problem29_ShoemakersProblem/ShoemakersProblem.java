package Problem29_ShoemakersProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShoemakersProblem 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer[]> inputList = null;
		
		int tastCase = sc.nextInt();

		sc.nextLine();
		System.out.println();
		
		// �׽�Ʈ ���̽���ŭ �ݺ�
		for(int i = 0; i < tastCase; i++)
		{
			int workNumber = sc.nextInt();
			int[] output = new int[workNumber];
			
			inputList = new ArrayList<Integer[]>();
			
			// ��ǲ ������ �Է�
			for(int j = 0; j < workNumber; j++)
			{
				Integer[] line = new Integer[2];
				line[0] = sc.nextInt();
				line[1] = sc.nextInt();
				inputList.add(line);
				output[j] = j; // �ƿ�ǲ �����͸� �ʱ�ȭ
			}
			
			// ���������� ���ؼ� �켱������ ���� �Ϻ��� ó��
			for(int m = 0; m < inputList.size()-1; m++)
				for(int k = 0; k < (inputList.size()-m)-1; k++)
				{
					Integer[] first = inputList.get(k);
					Integer[] second = inputList.get(k+1);
					
					int ad = first[0]*second[1];
					int bc = first[1]*second[0];
					
					if(ad > bc)
					{
						// �ƿ�ǲ �ε��� ����
						int temp = output[k];
						output[k] = output[k+1];
						output[k+1] = temp;
						
						// ArrayList ����
						Collections.swap(inputList, k, k+1);
					}
					else if(ad == bc)
					{
						// �ε��� ���� ���� ������� �ƿ�ǲ�� �����ϱ� ���� ��ƾ
						if(output[k] > output[k+1])
						{
							// �ƿ�ǲ �ε��� ����
							int temp = output[k];
							output[k] = output[k+1];
							output[k+1] = temp;
						}
					}	
				}
		
			// �ƿ�ǲ ���
			for(int z = 0; z < output.length; z++)
			{
				output[z]++; // ������ output�� �ε����� 0���� ���������Ƿ�, �������� ���ϴ� ������ �����ϱ� ���� 1�� ������
				System.out.print(output[z] + " ");
			}
				
			System.out.println();
			System.out.println();
				
		}
	} // end of main

}
