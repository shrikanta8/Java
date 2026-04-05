import java.util.*;
import java.util.stream.Collectors;

public class Main
{
	public static void main(String[] args) {
	    
		List<Integer> arr = Arrays.asList(1,2,4,1,2,5);
		
		List<Integer> result=arr.stream().filter(x -> x%2==0).collect(Collectors.toList());
// 		List<Integer> result=arr.stream().filter(x -> x%2==0).toList();
		
		System.out.println(result);
	}
}
