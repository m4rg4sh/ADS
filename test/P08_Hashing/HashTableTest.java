package P08_Hashing;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class HashTableTest {
    @Test
    public void shouldReportSizeCorrectly(){
        HashTable<String, Integer> table = new HashTable<>();
        assertEquals(0,table.size());
        assertEquals(true,table.isEmpty());
        table.add("one",1);
        assertEquals(1,table.size());
        assertEquals(false,table.isEmpty());
        table = createFullHashTable();
        assertEquals(7,table.size());
        assertEquals(false,table.isEmpty());
        table.remove("one");
        table.remove("seven");
        table.remove("four");
        table.remove("two");
        assertEquals(3,table.size());
        assertEquals(false,table.isEmpty());
    }

    @Test
    public void shouldAddAndRetrieveValuesCorrectly(){
        HashTable<String, Integer> table = createFullHashTable();
        assertEquals((Integer)1,table.remove("one"));
        assertEquals((Integer)2,table.remove("two"));
        assertEquals((Integer)3,table.remove("three"));
        assertEquals((Integer)4,table.remove("four"));
        assertEquals((Integer)5,table.remove("five"));
        assertEquals((Integer)6,table.remove("six"));
        assertEquals((Integer)7,table.remove("seven"));
    }

    @Test
    public void shouldRemoveValuesCorrectly(){
        HashTable<String, Integer> table = createFullHashTable();
        table.remove("one");
        assertEquals(false,table.containsKey("one"));
        table.remove("two");
        assertEquals(false,table.containsKey("two"));
        table.remove("three");
        assertEquals(false,table.containsKey("three"));
        table.remove("four");
        assertEquals(false,table.containsKey("four"));
        table.remove("five");
        assertEquals(false,table.containsKey("five"));
        table.remove("six");
        assertEquals(false,table.containsKey("six"));
        table.remove("seven");
        assertEquals(false,table.containsKey("seven"));
    }

    @Test
    public void shouldFindEntriesByValue(){
        HashTable<String, Integer> table = createFullHashTable();
        assertEquals(true,table.containsValue(1));
        assertEquals(true,table.containsValue(2));
        assertEquals(true,table.containsValue(3));
        assertEquals(true,table.containsValue(4));
        assertEquals(true,table.containsValue(5));
        assertEquals(true,table.containsValue(6));
        assertEquals(true,table.containsValue(7));
        assertEquals(false,table.containsValue(8));
    }

    private HashTable<String, Integer> createFullHashTable() {
        HashTable<String,Integer> table = new HashTable<>(10);
        table.add("one",1);
        table.add("two",2);
        table.add("three",3);
        table.add("four",4);
        table.add("five",5);
        table.add("six",6);
        table.add("seven",7);
        return table;
    }

    private HashTable<String, Integer> createSmallHashTable() {
        HashTable<String,Integer> table = new HashTable<>(4);
        table.add("one",1);
        table.add("two",2);
        return table;
    }

    @Test
    public void shouldEnlargeTable(){
        HashTable<String, Integer> table = createSmallHashTable();
        table.add("three",3); //the loadfactor should be reached here TODO use a spy to check this
        table.add("four",4);
        table.add("five",5); //exception if the table hasn't been enlarged
    }

    @Test
    public void shouldRehashTableCorrectly(){
        HashTable<String, Integer> table = createSmallHashTable();
        table.add("three",3);
        table.add("four",4);
        table.add("five",5);
        table.add("six",6);
        assertEquals((Integer)1,table.remove("one"));
        assertEquals((Integer)2,table.remove("two"));
        assertEquals((Integer)3,table.remove("three"));
        assertEquals((Integer)4,table.remove("four"));
        assertEquals((Integer)5,table.remove("five"));
        assertEquals((Integer)6,table.remove("six"));
    }

    @Test
    public void shouldChangeLoadFactorCorrectly(){
        HashTable<String, Integer> table = createFullHashTable();
        table.setLoadFactorForResize(0.5);
        //TODO use spy to check if a rehashing occured
    }
}
