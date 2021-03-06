package P08_Hashing;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 *
 *     Sources:
 *     - java.util.Hashtable for the Entry&lt;K,V&gt; structure.
 *     - Saake/Sattler for general thing and the lazy deletion idea.
 */
public class HashTable<K,V> implements IHashTable<K,V> {
    private static final boolean DEFAULT_PROBING_METHOD = true;
    private static final int DEFAULT_CAPACITY = 11;
    private static final double DEFAULT_LOADFACTOR = 0.6;
    private static final int PROBING_THRESHOLD = 25;

    private Entry<K,V> table[];
    private int size;
    private boolean useLinearProbing;
    private double loadFactor;

    public HashTable (int initialCapacity, boolean useLinearProbing){
        table = new Entry[initialCapacity];
        this.useLinearProbing = useLinearProbing;
        loadFactor = DEFAULT_LOADFACTOR;
        size = 0;
    }

    public HashTable (int initialCapacity){
        this(initialCapacity,DEFAULT_PROBING_METHOD);
    }

    public HashTable (boolean probingMethod){
        this(DEFAULT_CAPACITY,probingMethod);
    }

    public HashTable(){
        this(DEFAULT_CAPACITY,DEFAULT_PROBING_METHOD);
    }

    /**
     * @return amount of elements in the hashtable.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return true if table is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * adds a element to the hashtable.
     * if an element with the same key already exists, the value gets overwritten.
     * @param key the key.
     * @param value the corresponding value.
     */
    @Override
    public void add(K key, V value) {
        int index = getNextAvailablePosition(key);
        if (table[index] == null || table[index].isDeleted()){
            size++;
        }
        table[index] = new Entry<>(key,value);
        checkLoadLimit();
    }

    /**
     * Returns true if the value is present in the table
     * @param value the value to search
     * @return true if it exists in the table
     */
    @Override
    public boolean containsValue(V value) {
        for (int i = 0;i < table.length;i++) {
            if (table[i] != null && !table[i].isDeleted() && table[i].getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if the key is present in the table.
     * @param key the key to search
     * @return true if it exiss in the table
     */
    public boolean containsKey(K key){
        try{
            getIndexOfKey(key);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    /**
     * Removes an element from the table if it exists.
     * @param key the key to remove.
     * @return the value of the element.
     * @throws NoSuchElementException if the key is not present in the table.
     */
    @Override
    public V remove(K key) throws NoSuchElementException {
        Integer index = getIndexOfKey(key);
        if (index == null) throw new NoSuchElementException();

        table[index].delete();
        size--;

        return table[index].getValue();
    }

    /**
     * @return an iterator for the table
     */
    @Override
    public Iterator<V> iterator() {
        return new HashTableIterator<V>();
    }

    /**
     * sets the loadfactor to the given value.
     * @param loadFactor the new loadfactor.
     */
    @Override
    public void setLoadFactorForResize(double loadFactor) {
        this.loadFactor = loadFactor;
        checkLoadLimit();
    }

    /**
     * calculates the index for a given key.
     * @param key the key to calculate the index for
     * @return the index
     */
    private int calculateIndex(K key){
        return (key.hashCode() & 0x7FFFFFFF) % table.length;
    }

    /**
     * starts the rehashing process if the current loadfactor is above the threshold.
     */
    private void checkLoadLimit(){
        if (size/table.length >= loadFactor) {
            rehash();
        }
    }

    /**
     * Returns the index where a given key is stored.
     * @param key the key to search
     * @return the index where the key is stored or null if it isn't present.
     */
    private Integer getIndexOfKey(K key) throws NoSuchElementException{
        Integer index = calculateIndex(key);
        int counter = 1;
        while (table[index] != null && table[index].getKey() != key) {
            index = getNextIndex(index);
            if (counter++ >= PROBING_THRESHOLD){
                throw new IllegalStateException("Maximum number of probings exceeded");
            }
        }
        if (table[index] == null || table[index].isDeleted()) {
            throw new NoSuchElementException();
        }
        return index;

    }

    /**
     * Returns the index where the given key should be stored. If the same key already exists
     * the corresponding key is returned.
     * @param key the key that should be stored.
     * @return the correct index for the key.
     */
    private int getNextAvailablePosition(K key) {
        int index = calculateIndex(key);
        int counter = 1;
            while (table[index] != null && !table[index].isDeleted() && table[index].getKey() != key) {
                index = getNextIndex(index);
                if (counter++ >= PROBING_THRESHOLD){
                    throw new IllegalStateException("Maximum number of probings exceeded");
                }
        }
        return index;
    }

    /**
     * calls the correct probing method to skip to the next index
     * @param index the current index.
     * @return the next index.
     */
    private int getNextIndex(int index) {
        if (useLinearProbing) {
            return getNextLinearIndex(index);
        } else {
            return getNextQuadraticIndex(index);
        }
    }

    private int getNextLinearIndex(int index) {
        if (++index < table.length) {
            return index;
        } else {
            return 0;
        }
    }

    private int getNextQuadraticIndex(int index) {
        //TODO implement getNextQuadraticIndex
        return index;
    }

    private void rehash() {
        Entry<K, V> oldTable[] = table;
        table = new Entry[nextTableSize()];
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null && !oldTable[i].isDeleted()) {
                add(oldTable[i].getKey(), oldTable[i].getValue());
            }
        }
    }

    private int nextTableSize(){
        for(int possibleSize : QuadraticProbe.QUADRATIC_PROBING_HASH_TABLE_SIZE_LIST){
            if (possibleSize > size && possibleSize*loadFactor > size){
                return possibleSize;
            }
        }
        throw new IllegalStateException("Maximum table size reached");
    }

    private class HashTableIterator<T> implements Iterator<V> {
        private int position;

        public HashTableIterator(){
            position = 0;
        }

        @Override
        public boolean hasNext() {
            try {
                findNextNonEmptyField();
                 return true;
            }
            catch (NoSuchElementException e){
                return false;
            }
        }

        @Override
        public V next() throws NoSuchElementException{
            position = findNextNonEmptyField();
            return table[position++].getValue();
        }


        private int findNextNonEmptyField() throws NoSuchElementException {
            boolean found = false;
            int searchposition = position;
            while (searchposition < table.length && found == false){
                if (table[searchposition] != null && !table[searchposition].isDeleted()) {
                    found = true;
                } else {
                    searchposition++;
                }
            }
            if (found == false) {
                throw new NoSuchElementException("No more elements");
            }
            return searchposition;
        }
    }
}