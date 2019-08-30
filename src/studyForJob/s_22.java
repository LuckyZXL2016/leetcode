package studyForJob;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU设计
 * 利用LinkedHashMap
 * Created by ZXL on 2019/8/30.
 */
public class s_22 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    s_22(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void push(int key, int value) {
        super.put(key,value);
    }

    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
