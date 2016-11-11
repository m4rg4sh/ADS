package P08_Hashing;


/**
 * This class represents an entry for the hashtable.
 *
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class Entry<K,V> {
    private K key;
    private V value;
    boolean deleted;

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
        deleted = false;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }

    public void delete(){
        deleted = true;
    }

    public boolean isDeleted(){
        return deleted;
    }
}
