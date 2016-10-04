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
     * @param n Number n
     * @param m Number m
     * @return the gcd
     */
    public static long gcd(long n, long m) {
        if (m == 0) {
            return n;
        } else {
            return gcd(m, n % m);
        }
    }
    /*public static long gcd(long a, long b){
        if(a == 0) {
            return b;
        } else if(b == 0) {
            return a;
        } else if (a > b) {
            return gcd(a-b,b);
        } else {
            return gcd(a,b-a);
        }
    }*/

    public static void main(String[] args){
        long a = 33;
        long b = 99;
        System.out.println("ggT von " + a + " und " + b + " : " + gcd(a,b));
    }
}
