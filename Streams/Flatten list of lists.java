import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> nums = Arrays.asList(
                                Arrays.asList(3,12,1),
                                Arrays.asList(9,2)
                            );
                            
        List<Integer> result = nums.stream()
                                .flatMap(List::stream)
                                .toList();
                            
        System.out.println(result);
    }
}
