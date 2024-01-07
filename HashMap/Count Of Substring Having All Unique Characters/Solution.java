import java.util.*;

public class Main {

	public static int solution(String str) {
		// write your code here
		
		HashMap<Character, Integer> map = new HashMap<>();
		int ans=0;
		int release=0;
		for(int acquire=0; acquire<str.length; acquire++){
		    Character curr_char = str.charAt(acquire); 
		    while(acquire<release && map.containsKey(curr_char)){
		        Character releasedCharacter = str.charAt(release);
		        map.remove(releasedCharacter);
		        released++;
		        
		    }
		    map.put(curr_char,1);
		    ans+=(acquire-release+1);
		    
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
