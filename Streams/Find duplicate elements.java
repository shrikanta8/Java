
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class Main
{
	public static void main(String[] args) {
	    List<Integer> list = Arrays.asList(2,4,1,4,1);
	    
	   // (Using Set)
	    Set<Integer> seen = new HashSet<>();
	    
	    Set<Integer> result = list.stream()
	                            .filter(e -> !seen.add(e))
	                            .collect(Collectors.toSet());
	             
	             
	             
	    // using stream       
        List<Integer> duplicates = list.stream()
                                .collect(Collectors.groupingBy(
                                        Function.identity(),
                                        Collectors.counting()
                                ))
                                .entrySet()
                                .stream()
                                .filter(e -> e.getValue() > 1)
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toList());
                                
		System.out.println(duplicates);
	}
}

