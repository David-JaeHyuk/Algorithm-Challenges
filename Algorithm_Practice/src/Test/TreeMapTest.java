package Test;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeMap<String, String> tMap = new TreeMap<String, String>();
		TreeMap<Integer, String> tMap2 = new TreeMap<Integer, String>();
		TreeSet<String> tSet = new TreeSet<String>();
		
		tSet.add("13:00 14:01 Lectures");
		tSet.add("13:00 14:00 Lectures");
		tSet.add("14:00 15:00 Lectures");
		
		Iterator<String> itrSet = tSet.iterator();
		while(itrSet.hasNext())
			System.out.println(itrSet.next());
		
		/* String Ŭ������ TreeMap�� ������ ��, �տ� �ִ� ���ڿ��� ���ڰ� ���� �� Ȥ�� ���ĺ� ö�� ������ ������� Ȯ��*/
//		tMap.put("13:00 14:01 Lectures", "ù��°");
//		tMap.put("13:00 14:00 Lectures", "�ι�°");
		
		
		/* String Ŭ������ TreeMap�� ������ ��, ���ĺ� ���� ������ ���� ����ǰ�, ���ڰ� �켱������ ���´�. */
//		tMap.put("abz", "ù��°");
//		tMap.put("ab", "�ι�°");
		
		/*
		tMap2.put(3, "����°");
		tMap2.put(2, "�ι�°");
		tMap2.put(4, "�׹�°");
		tMap2.put(1, "ù��°");
		*/
		
		/*
		NavigableSet<String> navi = tMap.navigableKeySet();
		Iterator<String> itr = navi.iterator();
		while(itr.hasNext())
			System.out.println(tMap.get(itr.next()));
		*/
	}

}
