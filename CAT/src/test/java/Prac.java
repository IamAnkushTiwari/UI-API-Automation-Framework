import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Prac {

    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();

        al.add(23);
        al.add(34);
        al.add(24);
        al.add(63);
        al.add(45);

        System.out.println(al);

        Comparator<Integer> c = (T1,T2)->(T1>T2)?-1:(T1>T2)?1:(T1>T2)?1:0;
        Collections.sort(al,c);
        System.out.println(al);


    }
}
