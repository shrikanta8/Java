class LFUCache {

    int min;
    int capacity;
    Map<Integer, Integer> keyToCount;
    Map<Integer, Integer> keyToVal;
    Map<Integer, LinkedHashSet<Integer> > countToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        min = 1;
        keyToVal = new HashMap<>();
        keyToCount  = new HashMap<>();
        countToKeys = new HashMap<>();
    }
    
    public int get(int key) {
        if(!keyToVal.containsKey(key)){
            return -1;
        }

        int count = keyToCount.get(key);
        countToKeys.get(count).remove(key);

        if(count == min && countToKeys.get(min).size()==0){
            min++;
        }

        updateCount(key,count+1);
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if(keyToVal.containsKey(key)){
            keyToVal.put(key,value);
            get(key);
            return;
        }

        if(capacity == keyToVal.size()){
            evict( countToKeys.get(min).iterator().next() );
        }
         
        min = 1;
        updateCount(key,min);
        keyToVal.put(key,value);
    }

    public void updateCount(int key, int newCount){
        keyToCount.put(key,newCount);
        if(!countToKeys.containsKey(newCount)){
            countToKeys.put(newCount, new LinkedHashSet<>());
        }
        countToKeys.get(newCount).add(key);
    }

    public void evict(int key){
        countToKeys.get(min).remove(key);
        keyToVal.remove(key);
        keyToCount.remove(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
