package P01_Brackets;

import java.util.ArrayList;

/**
 * Implementation of a stack based on ArrayLists
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 */
class Stack<Object> extends ArrayList<Object>{

    /**
     * Pushed a Object onto the stack
     * @param item The item to be pushed onto the stack
     */
    void push(Object item) {
        add(item);
    }

    /**
     * Removes and returns the object currently on top of the stack
     * @return the object on top of the stack
     */
    Object pop() {
        Object returnObject = top();
        remove(size()-1);
        return returnObject;
    }

    /**
     * Returnes the object on top of the stack but leaves it in place
     * @return the object on top of the stack
     */
    Object top() {
        trimToSize();
        return get(size()-1);
    }
}
