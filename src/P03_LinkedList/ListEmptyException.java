package P03_LinkedList;

public class ListEmptyException extends Exception {

    private static final long serialVersionUID = 1L;

    public String getMessage() {
        return "List contains no Elements";
    }

}
