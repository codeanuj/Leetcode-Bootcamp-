import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		// write your code here
		HashMap<Integer, Integer> map = new HashMap();
		map.put(0,0);
		int count = 0;
		int sum=0;
		
		for(int i=0; i<arr.length; i++){
		    sum+=arr[i];
		    if(map.containsKey(sum)){
		        count+=map.get(sum);
		        map.put(sum, map.get(sum)+1);
		    }else{
		        map.put(sum, 1);
		    }
		}



		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));

	}

}
