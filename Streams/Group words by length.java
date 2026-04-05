import java.util.*;
import java.util.stream.Collectors;

public class Main
{
	public static void main(String[] args) {
	   
		List<String> names = Arrays.asList("radhe","shyam","ram","sita","hanuman");
		
		Map<Integer,List<String>> map = names.stream()
		                            .collect(Collectors.groupingBy(String::length));
		                
		 System.out.println(map);
	}
}
