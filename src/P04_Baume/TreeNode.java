package P04_Baume;

/**
 * Knoten eines binären Baumes.
 *
 */
public final class TreeNode<E extends Comparable<E>> {

    private E element;
    private TreeNode<E> left;
    private TreeNode<E> right;

    /**
     * Erzeugt einen neuen Knoten mit dem gegebenen Element und ohne Nachfolger.
     *
     * @param element der Wert des Knotens
     */
    public TreeNode(E element) {
        this.element = element;
    }

    /**
     * Gibt eine String-Repräsentation dieses Knotens zurück.
     *
     * @return die String-Repräsentation des Knotens
     */
    @Override
    public String toString() {
        return (getClass().getName() + "["
                + "element=" + element
                + "]");
    }

    /**
     * Gibt das gespeicherte Element des Knotens zurück.
     *
     * @return der Wert des Knotens
     */
    public E getElement() {
        return element;
    }

    /**
     * Setzt das zu speichernde Element des Knotens.
     *
     * @param element der Wert des Knotens
     */
    public void setElement(E element) {
        this.element = element;
    }

    /**
     * Gibt den linken Nachfolger des Knotens zurück.
     *
     * @return der linke Kindknoten, oder <code>null</code>, falls kein solcher existiert
     */
    public TreeNode<E> getLeft() {
        return left;
    }

    /**
     * Setzt den linken Nachfolger des Knotens.
     *
     * @param left der linke Kindknoten, darf auch <code>null</code> sein
     */
    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    /**
     * Gibt den rechten Nachfolger des Knotens zurück.
     *
     * @return der rechte Kindknoten, oder <code>null</code>, falls kein solcher existiert
     */
    public TreeNode<E> getRight() {
        return right;
    }

    /**
     * Setzt den rechten Nachfolger des Knotens.
     *
     * @param right der rechte Kindknoten, darf auch <code>null</code> sein
     */
    public void setRight(TreeNode<E> right) {
        this.right = right;
    }
}
