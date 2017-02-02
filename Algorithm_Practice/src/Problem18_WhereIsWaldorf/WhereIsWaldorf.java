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
		int testCase = sc.nextInt(); // 테스트 케이스 입력받음
		
		System.out.println();
		
		inputGrid_row = sc.nextInt(); // 그리드의 행 개수 입력받음
		inputGrid_column = sc.nextInt(); // 그리드의 열 개수 입력받음
		
		inputGrid_temp = new String[inputGrid_row];
		inputGrid = new String[inputGrid_row]; // inputGrid 생성
		
		for(i = 0; i < inputGrid_temp.length; i++)
		{
			inputGrid_temp[i] = sc.next(); // 그리드에 인풋 입력받음
			inputGrid[i] = inputGrid_temp[i].toLowerCase(); // 모두 소문자로 변환
		}
		sc.nextLine(); // 위의 sc.next()에서 입력받은 엔터키를 입력받기 위해
		
		int wordNum = sc.nextInt(); // 단어의 개수 입력
		sc.nextLine(); // 엔터키 입력을 위해
		
		String[] inputWord_temp = new String[wordNum];
		String[] inputWord = new String[wordNum];
		
		// 단어 입력
		for(i = 0; i < wordNum; i++)
		{
			inputWord_temp[i] = sc.next(); 
			inputWord[i] = inputWord_temp[i].toLowerCase(); // 모두 소문자로 변환
		}

		// 모든 그리드를 돌면서 시작
		for(i = 0; i < inputGrid.length; i++)
			for(j = 0; j < inputGrid[i].length(); j++)
				for(int k = 0; k < inputWord.length; k++)
				{
					if(findMatching(inputWord[k], i, j, inputGrid_row, inputGrid_column, inputGrid))
					{
						System.out.printf("%d %d 입니다.", i+1, j+1);
						System.out.println();
					}
				}

		System.out.println("종료");
	} // end of main method
	
	static boolean findMatching(String inputWord, int start_i, int start_j, int inputGrid_row, int inputGrid_column, String[] inputGrid)
	{
		int dir;
		int k = 0; // 입력 단어의 위치를 계속해서 탐색할 변수
		
		for(dir = 0; dir < 8; dir++) // 해당 문자에 대해 모든 방향 탐색. 총 8개의 방향
		{
			int i = start_i;
			int j = start_j;
			k = 0;
			
			// 그리드를 탐색하며 매칭을 확인
			while(k < inputWord.length() && i >=0 && i < inputGrid_row && j >=0 && j < inputGrid_column 
					&& inputGrid[i].charAt(j) == inputWord.charAt(k))
			{
				i = i + di[dir];
				j = j + dj[dir];
				k++;
			}
			
			if(k == inputWord.length())
			{
				System.out.print("단어를 찾았습니다. 단어는 " + inputWord + "이며 위치는 ");
				return true;
			}
		}
		return false;
	}
}
