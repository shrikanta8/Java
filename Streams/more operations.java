import java.util.*;

public class Main
{
	public static void main(String[] args) {
	   
		List<String> names = Arrays.asList("e","r","a","d");
		
		//uppercase
		List<String> result = names.stream().map(String::toUpperCase).toList();
		
		//sorting
		List<String> ascSortedNames=names.stream().sorted().toList();
		
		List<String> descSortedNames=names.stream().sorted(Collections.reverseOrder()).toList();
		
		//3rd highest val
    //Optional is used to avoid null-related bugs (NullPointerException)
		Optional<String> thirdHighestVal=names.stream()
		                                .distinct()
		                                .sorted(Collections.reverseOrder())
		                                .skip(2)
		                                .findFirst();
		                                
		  System.out.println(thirdHighestVal.orElse("not present"));
		  
		  
		 //max min 
		 String minVal = names.stream().
		                min(String::compareTo)
		                .get(); //exception if names is empty
		                
		 String maxVal = names.stream()
		                    .max(String::compareTo)
		                    .orElse("list is empty!!");
		                
		 System.out.println(minVal);
	}
}
