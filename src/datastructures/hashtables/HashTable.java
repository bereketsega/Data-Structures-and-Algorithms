package datastructures.hashtables;

/**
 * Implementation of hash table using chaining to resolve collisions.
 * 
 * @author Bereket Sega
 */
public class HashTable <S>{
    
    private int CAPACITY = 10;     // initialize with default size
    private HashEntry<S>[] bucket; // entries storage
    private int size;              // number of elements in the table 

    /**
     * HashTable constructor initialize bucket with initial size
     */
    HashTable() {
        bucket = new HashEntry[CAPACITY];
        size = 0;
    }

    /**
     * HashTable constructor initialize bucket with a size
     * @param size the number of elements in the table
     */
    HashTable(int size) {
        CAPACITY = size;
        bucket = new HashEntry[size];
        this.size = 0;
    }
    
    /**
     * inserts an entry to the hash table
     * @param key key of the entry
     * @param val value of the entry
     */
    public void put(String key, S val) {
        // resize if table capacity exceeds 2/3
        if ((2.0/3)*(CAPACITY) <= size) {
            CAPACITY *= 2;
            HashEntry<S>[] newBucket = new HashEntry[CAPACITY];
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != null) {
                    int index = hash(bucket[i].key);
                    insert(index, bucket[i], newBucket);
                }
            }
            bucket = newBucket;
        }

        // generate index for the new entry
        int index = hash(key);
        // create new entry
        HashEntry<S> newItem = new HashEntry<>(key, val);
        // insert to the table
        insert(index, newItem, bucket);
        size++;
    }

    /**
     * inserts an entry into a bucket
     * @param index index of the entry
     * @param entry key,value pair of element
     * @param bucket entry storage
     */
    private void insert(int index, HashEntry<S> entry, HashEntry<S>[] bucket) {
        // case : index is taken by another entry
        if (bucket[index] != null) {
            // traverse the linkedlist until null
            HashEntry<S> curr = bucket[index];
            while (curr.next != null) {
                curr = curr.next;
            }
            // insert the new entry
            curr.next = entry;
        }
        // case: the index is free
        else {
            // insert the new entry
            bucket[index] = entry;
        }
    }

    /**
     * removes an entry from the table
     * @param key key of the entry
     */
    public void remove(String key) {
        // element DNE
        if (size == 0) {
            return;
        }
        // key DNE
        if (get(key) == null) {
            System.out.println("Key DNE");
            return;
        }
        // resize if table capacity is below 1/6
        if (size <= (1.0/6)*(CAPACITY)) {
            CAPACITY /= 2;
            HashEntry<S>[] newBucket = new HashEntry[CAPACITY];
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != null) {
                    int index = hash(bucket[i].key);
                    insert(index, bucket[i], newBucket);
                }
            }
            bucket = newBucket;
        }

        // index of entry to be removed
        int removeIndex = hash(key);
        HashEntry<S> curr = bucket[removeIndex];  // to traverse 

        // case: key is the first entry at removeIndex
        if (curr.key == key) {
            bucket[removeIndex] = curr.next;
            size--;
            return;
        }
        // case: key is linked with array entry
        while (curr.next.key != key && curr.next != null) {
            curr = curr.next;
        }
        if (curr.next.key == key) {
            curr.next = curr.next.next;
            size--;
        }
    }

    /**
     * replaces the value of a given key
     * @param key key of the entry
     * @param val new value of the entry
     */
    public void replace(String key, S val) {
        // check if key exist
        int keyIndex = hash(key);
        if (bucket[keyIndex] == null) {
            System.out.println("Key DNE");
            return;
        }
        
        HashEntry<S> curr = bucket[keyIndex];
        // case: key is the first entry at keyIndex
        if (curr.key == key) {
            bucket[keyIndex].val = val;
            return;
        }
        // case: key is linked with array entry
        while (curr.key != key && curr.next != null) {
            curr = curr.next;
        }
        if (curr.key == key) {
            curr.val = val;
        }
    }

    /**
     * generates an index for an entry
     * @param key key of the entry
     * @return index of the entry
     */
    private int hash(String key) {
        int hashCode = key.hashCode();
        int index = (hashCode & 0x7fffffff) % CAPACITY;
        return  index;
    }

    public Object get(String key) {
        // generate the index for key
        int index = hash(key);
        // case: entry exist in the index
        if (bucket[index] != null) {
            HashEntry<S> curr = bucket[index];
            // find entry with same key
            while (curr.key != key && curr.next != null) {
                curr = curr.next;
            }
            if (curr.key == key) {
                return curr.val;
            }
        }
        return null;
    }

    /**
     * displays all of the keys in the table
     */
    public void keys() {
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != null) {
                // traverse same index
                HashEntry<S> curr = bucket[i];
                // find entry with same key
                while (curr != null) {
                    System.out.println(curr.key);
                    curr = curr.next;
                }
            }
        }
    }

    /**
     * displays all of the value in the table
     */
    public void values() {
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != null) {
                // traverse same index
                HashEntry<S> curr = bucket[i];
                // find entry with same key
                while (curr != null) {
                    System.out.println(curr.val);
                    curr = curr.next;
                }
            }
        }
    }

    /**
     * returns the number of elements in the table
     * @return number of elements in the table
     */
    public int size() {
        return size;
    }

    /**
     * checks if the table is empty or not
     * @return true if table is empty else false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    // Test
    public static void main(String[] args) {
        HashTable<Integer> ht = new HashTable<>(16);
        ht.put("a", 1);
        ht.put("b", 23);
        ht.put("c", 35);
        ht.put("d", 4);
        ht.put("e", 6);

        ht.replace("a", 11);
        ht.remove("c");
        System.out.println(ht.get("a"));
        System.out.println(ht.get("c"));
        System.out.println(ht.size());
    }
}

class HashEntry <T>{
    
    String key;
    T val;
    HashEntry<T> next;

    /**
     * HashEntry constructor sets key and value
     * @param key key of the entry
     * @param val value of the entry
     */
    HashEntry(String key, T val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}
