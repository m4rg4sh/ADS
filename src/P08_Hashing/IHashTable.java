package P08_Hashing;

import java.util.Iterator;
import java.util.Map;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public interface IHashTable<K,V> {
    int size();
    boolean isEmpty();
    void add(K key,V value);
    boolean containsValue(V value);
    V remove(K key);
    Iterator<V> iterator();
    void setLoadFactorForResize(double loadFactor);
}
