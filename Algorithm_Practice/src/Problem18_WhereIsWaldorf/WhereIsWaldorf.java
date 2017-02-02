package Problem18_WhereIsWaldorf;

import java.util.Scanner;

public class WhereIsWaldorf {
	
	static int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};//{-1, -1, -1, 0, 1, 1, 1, 0};//
	static int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};//{-1, 0, 1, 1, 1, 0 , -1, -1};//

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] inputGrid_temp;
		String[] inputGrid;

		int inputGrid_row;
		int inputGrid_column;
		Scanner sc = new Scanner(System.in);
		
		int i, j, a, b;
		int testCase = sc.nextInt(); // �׽�Ʈ ���̽� �Է¹���
		
		System.out.println();
		
		inputGrid_row = sc.nextInt(); // �׸����� �� ���� �Է¹���
		inputGrid_column = sc.nextInt(); // �׸����� �� ���� �Է¹���
		
		inputGrid_temp = new String[inputGrid_row];
		inputGrid = new String[inputGrid_row]; // inputGrid ����
		
		for(i = 0; i < inputGrid_temp.length; i++)
		{
			inputGrid_temp[i] = sc.next(); // �׸��忡 ��ǲ �Է¹���
			inputGrid[i] = inputGrid_temp[i].toLowerCase(); // ��� �ҹ��ڷ� ��ȯ
		}
		sc.nextLine(); // ���� sc.next()���� �Է¹��� ����Ű�� �Է¹ޱ� ����
		
		int wordNum = sc.nextInt(); // �ܾ��� ���� �Է�
		sc.nextLine(); // ����Ű �Է��� ����
		
		String[] inputWord_temp = new String[wordNum];
		String[] inputWord = new String[wordNum];
		
		// �ܾ� �Է�
		for(i = 0; i < wordNum; i++)
		{
			inputWord_temp[i] = sc.next(); 
			inputWord[i] = inputWord_temp[i].toLowerCase(); // ��� �ҹ��ڷ� ��ȯ
		}

		// ��� �׸��带 ���鼭 ����
		for(i = 0; i < inputGrid.length; i++)
			for(j = 0; j < inputGrid[i].length(); j++)
				for(int k = 0; k < inputWord.length; k++)
				{
					if(findMatching(inputWord[k], i, j, inputGrid_row, inputGrid_column, inputGrid))
					{
						System.out.printf("%d %d �Դϴ�.", i+1, j+1);
						System.out.println();
					}
				}

		System.out.println("����");
	} // end of main method
	
	static boolean findMatching(String inputWord, int start_i, int start_j, int inputGrid_row, int inputGrid_column, String[] inputGrid)
	{
		int dir;
		int k = 0; // �Է� �ܾ��� ��ġ�� ����ؼ� Ž���� ����
		
		for(dir = 0; dir < 8; dir++) // �ش� ���ڿ� ���� ��� ���� Ž��. �� 8���� ����
		{
			int i = start_i;
			int j = start_j;
			k = 0;
			
			// �׸��带 Ž���ϸ� ��Ī�� Ȯ��
			while(k < inputWord.length() && i >=0 && i < inputGrid_row && j >=0 && j < inputGrid_column 
					&& inputGrid[i].charAt(j) == inputWord.charAt(k))
			{
				i = i + di[dir];
				j = j + dj[dir];
				k++;
			}
			
			if(k == inputWord.length())
			{
				System.out.print("�ܾ ã�ҽ��ϴ�. �ܾ�� " + inputWord + "�̸� ��ġ�� ");
				return true;
			}
		}
		return false;
	}
}
