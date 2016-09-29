package P02_gcd;

/**
 * This class implements the calculation of the gcd (german: ggT)
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
public class Gcd {

    /**
     * calculates the gcd
     * @param a Number A
     * @param b Number B
     * @return
     */
    public static long gcd(long a, long b){
        if(a == 0) {
            return b;
        } else if(b == 0) {
            return a;
        } else if (a > b) {
            return gcd(a-b,b);
        } else {
            return gcd(a,b-a);
        }
    }

    public static void main(String[] args){
        long a = 33;
        long b = 99;
        System.out.println("ggT von " + a + " und " + b + " : " + gcd(a,b));
    }
}
