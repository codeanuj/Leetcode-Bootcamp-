import java.util.*;

public class Main {

	public static int solution(String str, int k) {
		// write your code here
		HashMap<Character, Integer> map = new HashMap<>();
		int distinct = 0;
		int release = 0;
		int result=0;
		
		for(int acquire=0; acquire<str.length(); acquire++){
		    Character acquiredCharacter = str.charAt(acquire);
		    if(map.containsKey(acquiredCharacter)){
		        map.put(acquiredCharacter, map.get(acquiredCharacter)+1);
		    }else{
		        map.put(acquiredCharacter, 1);
		        distinct+=1;
		    }
		    
		    while(release<=acquire && distinct>k){
		        Character discardCharacter = str.charAt(release);
		        map.put(discardCharacter, map.get(discardCharacter)-1);
		        release+=1;
		        
		        if(map.get(discardCharacter)==0){
		            map.remove(discardCharater);
		            distict-=1;
		        }
		    }
		    result+=(acquire-release+1);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
