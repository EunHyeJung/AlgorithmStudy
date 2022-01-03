/*
* @source https://leetcode.com/problems/design-hashmap/submissions/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.03
*/
class MyHashMap {
    private final int MAX_SIZE = 1000001;
    private int[] data;
    private boolean[] chk;

    public MyHashMap() {
        this.data = new int[MAX_SIZE];
        this.chk = new boolean[MAX_SIZE];
    }

    public void put(int key, int value) {
        this.chk[key] = true;
        this.data[key] = value;
    }

    public int get(int key) {
        return this.chk[key] ? this.data[key] : -1;
    }

    public void remove(int key) {
        this.data[key] = -1;
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
