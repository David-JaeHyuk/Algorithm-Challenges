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
		
		/* String 클래스를 TreeMap에 저장할 때, 앞에 있는 문자열의 숫자가 작은 순 혹은 알파벳 철자 순으로 저장됨을 확인*/
//		tMap.put("13:00 14:01 Lectures", "첫번째");
//		tMap.put("13:00 14:00 Lectures", "두번째");
		
		
		/* String 클래스를 TreeMap에 저장할 때, 알파벳 작은 순으로 먼저 저장되고, 숫자가 우선순위를 갖는다. */
//		tMap.put("abz", "첫번째");
//		tMap.put("ab", "두번째");
		
		/*
		tMap2.put(3, "세번째");
		tMap2.put(2, "두번째");
		tMap2.put(4, "네번째");
		tMap2.put(1, "첫번째");
		*/
		
		/*
		NavigableSet<String> navi = tMap.navigableKeySet();
		Iterator<String> itr = navi.iterator();
		while(itr.hasNext())
			System.out.println(tMap.get(itr.next()));
		*/
	}

}
