package Problem32_Football;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/*
 *  �ش� ������Ʈ�� ������ ��ɵ� 
 *  1) �ҹ��ڸ� �Է��Ѵٸ� �빮�ڷ� ��������ִ� �޼ҵ�
 *  2) Ŭ������ �ν��Ͻ����� ���ϵ�, Comparable<T>�� �����ϴ� compareTo<T>�� ���Ӱ� ������ ��� ����
 *  3) TreeSet Ȱ���Ͽ� 2)���� ������ ���Լ��� ����Ͽ� TreeSet�� �����͸� �����ϴ� ��� �����Ǿ�����
 *  
 */


class Team implements Comparable<Team>
{
	String name = null;
	int totalScore = 0; // ���� ����
	int totalGameNum = 0; // �� ���� ġ�� Ƚ��
	int winGameNum = 0; // ���� �̱� Ƚ��
	int tieGameNum = 0; // ���� ��� Ƚ��
	int lostGameNum = 0; // ���� �� Ƚ��
	int goalDifference = 0; // ��������� ��
	int gainGoalNum = 0; // ������
	int lostGoalNum = 0; // ������
	
	public Team(String name)
	{
		// ��ҹ��ڸ� ���Ͻ��� ��
		this.name = name;
	}

	@Override
	public int compareTo(Team obj) 
	{
//		System.out.println("compareTo�Լ� ȣ��");
		// TODO Auto-generated method stub
		if(obj.totalScore > totalScore)
		{
//			System.out.println("����(p)�� �ٸ� ��� �߻�. �ش� �̸��� ���� " + obj.totalScore + ", " + totalScore);
			return 1;
		}
			
		else if(obj.totalScore < totalScore)
		{
//			System.out.println("����(p)�� �ٸ� ��� �߻�. �ش� �̸��� ���� " + obj.totalScore + ", " + totalScore);
			return -1;
		}
			
		else // ������ ���� �����
		{
			
			if(obj.winGameNum > winGameNum)
				return 1;
			else if(obj.winGameNum < winGameNum)
				return -1;
			else // ������ ������ �̱� Ƚ���� ���� �����
			{
				if(obj.goalDifference > goalDifference)
					return 1;
				else if(obj.goalDifference < goalDifference)
					return -1;
				else // ������ ������ �̱�Ƚ���� ����, �� ������� ���� �����
				{
					if(obj.gainGoalNum > gainGoalNum)
						return 1;
					else if(obj.gainGoalNum < gainGoalNum)
						return -1;
					else // ����, �̱�Ƚ��, �� ������� ������, �ٵ����� Ƚ���� ���� �����
					{
						if(obj.totalGameNum < totalGameNum)
							return 1;
						else if(obj.totalGameNum > totalGameNum)
							return -1;
						
						else // ����, �̱� Ƚ��, �� �����, �ٵ����� Ƚ���� ������, ���Ӽ����� ���ٸ� name�� �������������� ����
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
								else // i�� ���鼭 �� ��ü�� �� ������ �켱������ ���ٸ� (�̷� ���� �ȳ���. �ڱ� �ڽ������� ���϶��� �̷� ��찡 �����Ƿ�)
								{
									if(i == (lengthShorterOne.length() -1)) // ª�� ���ڿ��� ������ Ž���� �Դٸ�
									{
//										System.out.println("���ڿ� ���� ������� ��. �ش� �̸��� ���� " + Obj + ", " + This);
										
										if(lengthShorterOne == Obj)
											return 1;
										else
											return -1;
									}
									else // ���� ���ڿ��� ������ ���� �ʾҴٸ� �ϳ��� ���ϸ鼭 ����ؼ� Ž��
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
	
	// �Էµ� ���ڰ� �ҹ��ڶ�� �빮�ڷ� �����ִ� �޼ҵ�
	private String changeHighCaseToLowCase(String str)
	{
		StringBuffer stb = new StringBuffer();
		
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) >= 97 && str.charAt(i) <=122) // �Էµ� ���ڰ� �ҹ��ڶ�� �빮�ڷ� ����
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
		sc.nextLine(); // ����Ű �Է��� ����
		
		// �׽�Ʈ���̽�(�� ��ʸ�Ʈ ��ȸ���� �ݺ�)
		while(tournamentNum > 0)
		{
			tournamentNum--;
			
			TreeSet<Team> outputTreeSet = new TreeSet<Team>();
			
			String tournamentName = sc.nextLine();
			int totalTeamNum = sc.nextInt();
			sc.nextLine(); // ����Ű �Է��� ����
			
			Team[] team = new Team[totalTeamNum];
			
			// ���� ������ �ʱ�ȭ
			for(int i = 0; i < totalTeamNum; i++)
				team[i] = new Team(sc.nextLine());

			
			// �� ġ�� ���� Ƚ�� �Է¹���
			int totalGameNumber = sc.nextInt();
			sc.nextLine(); // ����Ű �Է�
			
			String[] gameDescription = new String[totalGameNumber];
			
			// �� ���� ������� ���� ���� �Է¹ް� �ش� ���� ���� ������ ����
			for(int i = 0; i < totalGameNumber; i++)
			{
				gameDescription[i] = sc.nextLine();
				String[] values = parsingData(gameDescription[i]);
				
				/* �Ľ� ���� Ȯ��
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
				
				// ���� ���� �̱� ���
				if(leftTeamScore > rightTeamScore)
				{
					for(int j = 0; j < totalTeamNum; j++)
					{
						// �¸��� ���� ���� ���� �߰�
						if(team[j].name.equals(leftTeam)) // ���� ���� �˻��Ͽ� �������� �¸����� ���� ���� ������ �߰�
						{
							team[j].totalScore += 3; // ���� 3�� �߰�
							team[j].totalGameNum += 1; // ���� ġ�� Ƚ�� 1 �߰�
							team[j].gainGoalNum += leftTeamScore; // �����Ͽ� ������ ��Ƚ�� �߰�
							team[j].lostGoalNum += rightTeamScore; // �����Ͽ� ������ Ƚ�� �߰�
							team[j].winGameNum += 1; // ���ӿ��� �̱� ��� �� �߰�
						}
						// ���� ���� ���� ���� �߰�
						if(team[j].name.equals(rightTeam)) // ������ ���� �˻��Ͽ� ���������� ������ ���� ���� �������� �߰�
						{
							team[j].totalGameNum += 1; // ���� ġ�� Ƚ�� 1 �߰�
							team[j].gainGoalNum += rightTeamScore; // �����Ͽ� ������ �� Ƚ�� �߰�
							team[j].lostGoalNum += leftTeamScore; // �����Ͽ� ������ Ƚ�� �߰�
							team[j].lostGameNum += 1; // �����Ͽ� ���� ��� �� �߰�
						}
					}
				}
				else if(leftTeamScore < rightTeamScore) // ������ ���� �̱� ���
				{
					for(int j = 0; j < totalTeamNum; j++)
					{
						// �¸��� ���� ���� ���� �߰�
						if(team[j].name.equals(rightTeam)) // ������ ���� �˻��Ͽ� ���������� �¸����� ���� ���� ������ �߰�
						{
							team[j].totalScore += 3; // ���� 3�� �߰�
							team[j].totalGameNum += 1; // ���� ġ�� Ƚ�� 1 �߰�
							team[j].gainGoalNum += rightTeamScore; // �����Ͽ� ������ ��Ƚ�� �߰�
							team[j].lostGoalNum += leftTeamScore; // �����Ͽ� ������ Ƚ�� �߰�
							team[j].winGameNum += 1; // ���ӿ��� �̱� ��� �� �߰�
						}
						// ���� ���� ���� ���� �߰�
						if(team[j].name.equals(leftTeam)) // ���� ���� �˻��Ͽ� �������� ������ ���� ���� �������� �߰�
						{
							team[j].totalGameNum += 1; // ���� ġ�� Ƚ�� 1 �߰�
							team[j].gainGoalNum += leftTeamScore; // �����Ͽ� ������ �� Ƚ�� �߰�
							team[j].lostGoalNum += rightTeamScore; // �����Ͽ� ������ Ƚ�� �߰�
							team[j].lostGameNum += 1; // �����Ͽ� ���� ��� �� �߰�
						}
					}
				}
				else // ������ ���
				{
					// ������ ��� 
					for(int j = 0; j < totalTeamNum; j++)
					{
						// ���� ���� ���� ���� �߰�
						if(team[j].name.equals(leftTeam)) // ���� ���� �˻��Ͽ� ������ ��쿡 ���� ������ �߰�
						{
							team[j].totalScore += 1; // ���� 1�� �߰�
							team[j].totalGameNum += 1; // ���� ġ�� Ƚ�� 1 �߰�
							team[j].gainGoalNum += leftTeamScore; // �����Ͽ� ������ ��Ƚ�� �߰�
							team[j].lostGoalNum += rightTeamScore; // �����Ͽ� ������ Ƚ�� �߰�
							team[j].tieGameNum += 1; // ���ӿ��� �̱� ��� �� �߰�
						}
						// ������ ���� ���� ���� �߰�
						if(team[j].name.equals(rightTeam)) // ������ ���� �˻��Ͽ� ������ ��쿡 ���� �������� �߰�
						{
							team[j].totalScore += 1; // ���� 1�� �߰�
							team[j].totalGameNum += 1; // ���� ġ�� Ƚ�� 1 �߰�
							team[j].gainGoalNum += rightTeamScore; // �����Ͽ� ������ �� Ƚ�� �߰�
							team[j].lostGoalNum += leftTeamScore; // �����Ͽ� ������ Ƚ�� �߰�
							team[j].tieGameNum += 1; // �����Ͽ� ���� ��� �� �߰�
						}
					}
				}
				
				
			} // end of �� ���� ������� ���� ���� �Է¹ް� �ش� ���� ���� ������ ����
			
			// ���鿡 ���� ������ ��� ������ �� �� ���� ���� ������� ����
			for(int i = 0; i < totalTeamNum; i++)
				team[i].goalDifference = team[i].gainGoalNum - team[i].lostGoalNum;
			
			// ������ ���� ������ ������ ���� �����ϱ�
			//(TreeSet�� Team Ŭ������ �Է� �� ���� ������ ������ ���� ������ Team Ŭ������ ���ǵǾ�����)
			
			
			
			for(int i = 0; i < totalTeamNum; i++)
			{
//				System.out.println("Ʈ���¿� ������ ����");
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
		
		
		

	} // end of Main �Լ�
	
	static String[] parsingData(String str)
	{
		String[] values = str.split("#|@"); // ':' ��ȣ�� '�����̽���' ��ȣ�� �������� �����͸� �Ľ�
		return values;
	}

}
