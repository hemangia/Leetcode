package prog_705_designHashset;
class MyHashSet {
    //In this solution we are using double hashing technique where base structure is array of integer and for every index we are
    //maintaining second array.
    Integer[][] storage = new Integer[1000][] ;

    public MyHashSet() {

    }
    int hash1(int key){
        return key % 1000 ;
    }
    int hash2(int key){
        return key / 1000 ;
    }
    public void add(int key) {
        int val1 = hash1(key);
        if(storage[val1] == null){
            int val2 =  hash2(key);
            if(val1 == 0) { // This condition is for edge case if there are 1000000 numbers and for 1000000th item val1 = 1000000 % 1000 which is Zero 0
                storage[val1] = new Integer[1000+1] ; // but in zero index 1000000 / 1000 there are only items from 0 to 999
            }// in that case we will be storing additional 1 item in the 0th index only.
            else{
                storage[val1] = new Integer[1000] ;
            }

            storage[val1][val2] = key ;
        }
        else{
            int val2 =  hash2(key);
            storage[val1][val2] = key ;
        }
    }

    public void remove(int key) {
        int val1 = hash1(key);
        if(storage[val1] == null){
            return ;
        }
        int val2 =  hash2(key);
        storage[val1][val2] = null ;

    }

    public boolean contains(int key) {
        int val1 = hash1(key);
        if(storage[val1] == null){
            return false;
        }
        int val2 =  hash2(key);
        if(storage[val1][val2] != null){
            return true ;
        }
        return false ;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */