package P01_Brackets;

import java.util.ArrayList;

/**
 * Implementation of a stack based on ArrayLists
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 */
public class Stack<Object> extends ArrayList<Object>{

    public void push(Object value) {
        add(value);
    }

    public Object pop() {
        Object returnObject = top();
        remove(size()-1);
        return returnObject;
    }

    public Object top() {
        trimToSize();
        return get(size()-1);
    }
}
