class Solution {
    public String minWindow(String s, String t) {
        int  sLength = s.length(), tLength = t.length();
        if(sLength < tLength){
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();

        for(char ch:t.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        int count = 0;
        int startInd = 0, endInd = Integer.MAX_VALUE, minLen = 0, st=0;

        for(int i=0;i<sLength;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch) && map.get(ch) > 0){
                count++;
            }
            map.put(ch, map.getOrDefault(ch,0) - 1 );

            if(count == tLength){
                while(true){
                    char chStart = s.charAt(st);
                    if(map.containsKey(chStart) && map.get(chStart)==0){
                        break;
                    }
                    map.put(s.charAt(st), map.getOrDefault(s.charAt(st),0)+1);
                    st++;
                }

                if(endInd - startInd > i - st){
                    endInd = i;
                    startInd = st;
                }

                count--;
                map.put(s.charAt(st), map.getOrDefault(s.charAt(st),0)+1);
                st++;

            }

        }
        return endInd == Integer.MAX_VALUE ? "" : s.substring(startInd, endInd+1);
    }
}
