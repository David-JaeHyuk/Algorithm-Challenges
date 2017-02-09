package Problem32_Football;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/*
 *  해당 프로젝트에 구현된 기능들 
 *  1) 소문자를 입력한다면 대문자로 변경시켜주는 메소드
 *  2) 클래스에 인스턴스들을 비교하되, Comparable<T>를 구현하는 compareTo<T>를 새롭게 구현한 기능 있음
 *  3) TreeSet 활용하여 2)에서 구현한 비교함수를 사용하여 TreeSet에 데이터를 저장하는 기능 구현되어있음
 *  
 */


class Team implements Comparable<Team>
{
	String name = null;
	int totalScore = 0; // 게임 승점
	int totalGameNum = 0; // 총 게임 치른 횟수
	int winGameNum = 0; // 게임 이긴 횟수
	int tieGameNum = 0; // 게임 비긴 횟수
	int lostGameNum = 0; // 게임 진 횟수
	int goalDifference = 0; // 득실점간의 차
	int gainGoalNum = 0; // 득점수
	int lostGoalNum = 0; // 실점수
	
	public Team(String name)
	{
		// 대소문자를 통일시켜 줌
		this.name = name;
	}

	@Override
	public int compareTo(Team obj) 
	{
//		System.out.println("compareTo함수 호출");
		// TODO Auto-generated method stub
		if(obj.totalScore > totalScore)
		{
//			System.out.println("승점(p)이 다른 경우 발생. 해당 이름은 각각 " + obj.totalScore + ", " + totalScore);
			return 1;
		}
			
		else if(obj.totalScore < totalScore)
		{
//			System.out.println("승점(p)이 다른 경우 발생. 해당 이름은 각각 " + obj.totalScore + ", " + totalScore);
			return -1;
		}
			
		else // 승점이 같은 경우라면
		{
			
			if(obj.winGameNum > winGameNum)
				return 1;
			else if(obj.winGameNum < winGameNum)
				return -1;
			else // 승점이 같은데 이긴 횟수도 같은 경우라면
			{
				if(obj.goalDifference > goalDifference)
					return 1;
				else if(obj.goalDifference < goalDifference)
					return -1;
				else // 승점이 같은데 이긴횟수도 같고, 골 득실차도 같은 경우라면
				{
					if(obj.gainGoalNum > gainGoalNum)
						return 1;
					else if(obj.gainGoalNum < gainGoalNum)
						return -1;
					else // 승점, 이긴횟수, 골 득실차도 같은데, 다득점한 횟수도 같은 경우라면
					{
						if(obj.totalGameNum < totalGameNum)
							return 1;
						else if(obj.totalGameNum > totalGameNum)
							return -1;
						
						else // 승점, 이긴 횟수, 골 득실차, 다득점한 횟수가 같은데, 게임수까지 같다면 name의 사전편찬순으로 정렬
						{
							String Obj = changeHighCaseToLowCase(obj.name);
							String This = changeHighCaseToLowCase(name);
//							System.out.println("Obj : " + Obj + ", This : " + This);
							String lengthShorterOne = null;
							
							if(Obj.length() < This.length())
								lengthShorterOne = Obj;
							else if(Obj.length() > This.length())
								lengthShorterOne = This;
							
							else
								lengthShorterOne = This;

							for(int i = 0; i < lengthShorterOne.length(); i++)
							{
								if(Obj.charAt(i) < This.charAt(i))
									return 1;
								else if(Obj.charAt(i) > This.charAt(i))
									return -1;
								
								/*
								else // i가 돌면서 두 객체의 각 문자의 우선순위가 같다면 (이런 경우는 안나옴. 자기 자신팀과의 비교일때만 이런 경우가 나오므로)
								{
									if(i == (lengthShorterOne.length() -1)) // 짧은 문자열의 끝까지 탐색이 왔다면
									{
//										System.out.println("문자열 길이 같은경우 옴. 해당 이름은 각각 " + Obj + ", " + This);
										
										if(lengthShorterOne == Obj)
											return 1;
										else
											return -1;
									}
									else // 아직 문자열의 끝까지 오지 않았다면 하나씩 비교하면서 계속해서 탐색
										continue;
								}
								*/
								
							}
							
						}
						
					}
				}
			}
			return 0;
		}
	}
	
	// 입력된 문자가 소문자라면 대문자로 맞춰주는 메소드
	private String changeHighCaseToLowCase(String str)
	{
		StringBuffer stb = new StringBuffer();
		
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) >= 97 && str.charAt(i) <=122) // 입력된 문자가 소문자라면 대문자로 변경
				stb.append((char)(str.charAt(i)-32));
			else
				stb.append(str.charAt(i));
				
		}
		return stb.toString();
	}
	
}

public class Football 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int tournamentNum = sc.nextInt();
		sc.nextLine(); // 엔터키 입력을 위해
		
		// 테스트케이스(매 토너먼트 대회마다 반복)
		while(tournamentNum > 0)
		{
			tournamentNum--;
			
			TreeSet<Team> outputTreeSet = new TreeSet<Team>();
			
			String tournamentName = sc.nextLine();
			int totalTeamNum = sc.nextInt();
			sc.nextLine(); // 엔터키 입력을 위해
			
			Team[] team = new Team[totalTeamNum];
			
			// 각각 팀들을 초기화
			for(int i = 0; i < totalTeamNum; i++)
				team[i] = new Team(sc.nextLine());

			
			// 총 치른 게임 횟수 입력받음
			int totalGameNumber = sc.nextInt();
			sc.nextLine(); // 엔터키 입력
			
			String[] gameDescription = new String[totalGameNumber];
			
			// 각 게임 경기결과에 대한 것을 입력받고 해당 팀에 대한 정보를 저장
			for(int i = 0; i < totalGameNumber; i++)
			{
				gameDescription[i] = sc.nextLine();
				String[] values = parsingData(gameDescription[i]);
				
				/* 파싱 정보 확인
				for(int a = 0; a < values.length; a++)
				{
					System.out.print(values[a] +" ");
				}
				System.out.println();
				*/
				
				String leftTeam = values[0];
				String rightTeam = values[3];
				int leftTeamScore = Integer.parseInt(values[1]);
				int rightTeamScore = Integer.parseInt(values[2]);
				
				// 왼쪽 팀이 이긴 경우
				if(leftTeamScore > rightTeamScore)
				{
					for(int j = 0; j < totalTeamNum; j++)
					{
						// 승리한 팀에 대한 정보 추가
						if(team[j].name.equals(leftTeam)) // 왼쪽 팀을 검색하여 왼쪽팀이 승리했을 때에 대한 정보들 추가
						{
							team[j].totalScore += 3; // 승점 3점 추가
							team[j].totalGameNum += 1; // 게임 치른 횟수 1 추가
							team[j].gainGoalNum += leftTeamScore; // 게임하여 득점한 골횟수 추가
							team[j].lostGoalNum += rightTeamScore; // 게임하여 실점한 횟수 추가
							team[j].winGameNum += 1; // 게임에서 이긴 경기 수 추가
						}
						// 패한 팀에 대한 정보 추가
						if(team[j].name.equals(rightTeam)) // 오른쪽 팀을 검색하여 오른쪽팀은 패했을 때에 대한 정보들을 추가
						{
							team[j].totalGameNum += 1; // 게임 치른 횟수 1 추가
							team[j].gainGoalNum += rightTeamScore; // 게임하여 득점한 골 횟수 추가
							team[j].lostGoalNum += leftTeamScore; // 게임하여 실점한 횟수 추가
							team[j].lostGameNum += 1; // 게임하여 패한 경기 수 추가
						}
					}
				}
				else if(leftTeamScore < rightTeamScore) // 오른쪽 팀이 이긴 경우
				{
					for(int j = 0; j < totalTeamNum; j++)
					{
						// 승리한 팀에 대한 정보 추가
						if(team[j].name.equals(rightTeam)) // 오른쪽 팀을 검색하여 오른쪽팀이 승리했을 때에 대한 정보들 추가
						{
							team[j].totalScore += 3; // 승점 3점 추가
							team[j].totalGameNum += 1; // 게임 치른 횟수 1 추가
							team[j].gainGoalNum += rightTeamScore; // 게임하여 득점한 골횟수 추가
							team[j].lostGoalNum += leftTeamScore; // 게임하여 실점한 횟수 추가
							team[j].winGameNum += 1; // 게임에서 이긴 경기 수 추가
						}
						// 패한 팀에 대한 정보 추가
						if(team[j].name.equals(leftTeam)) // 왼쪽 팀을 검색하여 왼쪽팀이 패했을 때에 대한 정보들을 추가
						{
							team[j].totalGameNum += 1; // 게임 치른 횟수 1 추가
							team[j].gainGoalNum += leftTeamScore; // 게임하여 득점한 골 횟수 추가
							team[j].lostGoalNum += rightTeamScore; // 게임하여 실점한 횟수 추가
							team[j].lostGameNum += 1; // 게임하여 패한 경기 수 추가
						}
					}
				}
				else // 동점일 경우
				{
					// 동점일 경우 
					for(int j = 0; j < totalTeamNum; j++)
					{
						// 왼쪽 팀에 대한 정보 추가
						if(team[j].name.equals(leftTeam)) // 왼쪽 팀을 검색하여 동점인 경우에 대한 정보들 추가
						{
							team[j].totalScore += 1; // 승점 1점 추가
							team[j].totalGameNum += 1; // 게임 치른 횟수 1 추가
							team[j].gainGoalNum += leftTeamScore; // 게임하여 득점한 골횟수 추가
							team[j].lostGoalNum += rightTeamScore; // 게임하여 실점한 횟수 추가
							team[j].tieGameNum += 1; // 게임에서 이긴 경기 수 추가
						}
						// 오른쪽 팀에 대한 정보 추가
						if(team[j].name.equals(rightTeam)) // 오른쪽 팀을 검색하여 동점인 경우에 대한 정보들을 추가
						{
							team[j].totalScore += 1; // 승점 1점 추가
							team[j].totalGameNum += 1; // 게임 치른 횟수 1 추가
							team[j].gainGoalNum += rightTeamScore; // 게임하여 득점한 골 횟수 추가
							team[j].lostGoalNum += leftTeamScore; // 게임하여 실점한 횟수 추가
							team[j].tieGameNum += 1; // 게임하여 패한 경기 수 추가
						}
					}
				}
				
				
			} // end of 각 게임 경기결과에 대한 것을 입력받고 해당 팀에 대한 정보를 저장
			
			// 경기들에 대한 정보를 모두 저장한 뒤 각 팀에 대한 득실차를 저장
			for(int i = 0; i < totalTeamNum; i++)
				team[i].goalDifference = team[i].gainGoalNum - team[i].lostGoalNum;
			
			// 팀별로 문제 조건을 따르는 순위 정렬하기
			//(TreeSet에 Team 클래스를 입력 시 문제 조건을 따르는 정렬 조건이 Team 클래스에 정의되어있음)
			
			
			
			for(int i = 0; i < totalTeamNum; i++)
			{
//				System.out.println("트리셋에 데이터 저장");
				outputTreeSet.add(team[i]);
			}
				
			
			System.out.println(tournamentName);
			
			Iterator<Team> itr = outputTreeSet.iterator();
			int i = 0;
			while(itr.hasNext())
			{
				i++;
				Team outputTeam = itr.next();
				
				StringBuffer stb = new StringBuffer();
				stb.append(i+ ") ");
				stb.append(outputTeam.name + " ");
				stb.append(outputTeam.totalScore + "p, ");
				stb.append(outputTeam.totalGameNum + "g (" + outputTeam.winGameNum + "-" +
						outputTeam.tieGameNum + "-" + outputTeam.lostGameNum + "), ");
				stb.append(outputTeam.goalDifference + "gd (" + outputTeam.gainGoalNum + "-" + outputTeam.lostGoalNum + ")");
				
				System.out.println(stb.toString());
			}
			
			System.out.println();
		}// end of test case
		
		
		

	} // end of Main 함수
	
	static String[] parsingData(String str)
	{
		String[] values = str.split("#|@"); // ':' 기호나 '스페이스바' 기호를 기준으로 데이터를 파싱
		return values;
	}

}
