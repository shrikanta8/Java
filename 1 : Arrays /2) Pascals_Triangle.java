import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Solution sol = new Solution();
		List<List<Integer> > arr = sol.generate(5);
		
		for(List<Integer> rows: arr){
		    for(int ele:rows){
		        System.out.print(ele + " ");
		    }
		    System.out.println();
		}
	}
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();

        List<Integer> firstRow=new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow); 

        for(int rows=1;rows<numRows;rows++){
            List<Integer> preRow=result.get(rows-1);
            List<Integer> currRow= new ArrayList<>();
            currRow.add(1);

            for(int i=1;i<rows;i++){
                currRow.add(preRow.get(i-1)+preRow.get(i));
            }

            currRow.add(1);
            result.add(currRow);
        }

        return result;
    }
}
