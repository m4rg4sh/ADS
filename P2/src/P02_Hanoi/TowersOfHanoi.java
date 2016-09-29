package P02_Hanoi;

/**
 * This class solves the towers of Hanoi puzzle and prints the solution to the console
 *
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class TowersOfHanoi {

    /**
     * @param n      size of tower to move
     * @param source name of the source field
     * @param target name of the target field
     * @param work   name of the work field
     */
    static void moveDisks(int n, char source, char target, char work) {
        if (n == 1) {
            System.out.println(source + " -> " + target);
        } else {
            moveDisks(n - 1, source, work, target);
            System.out.println(source + " -> " + target);
            moveDisks(n - 1, work, target, source);
        }
    }

    public static void main(String[] args) {
        moveDisks(4, 'A', 'B', 'C');
    }
}
