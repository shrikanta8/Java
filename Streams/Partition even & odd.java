import java.util.*;
import java.util.stream.Collectors;

public class Main
{
	public static void main(String[] args) {
	   
		List<Integer> nums = Arrays.asList(3,1,2,4,2,0);
		
		Map<Boolean,List<Integer>> map = nums.stream()
		                                    .collect(Collectors.partitioningBy(n->n%2==0));
		                
		 System.out.println(map);
	}
}
