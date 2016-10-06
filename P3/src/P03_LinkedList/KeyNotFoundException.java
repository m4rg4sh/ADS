package P03_LinkedList;

/**
 * Exception thrown if a certain key is not found in the list
 *
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
class KeyNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "List doesn't contain this value";
    }
}
