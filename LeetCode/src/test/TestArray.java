package test;

import java.util.ArrayList;
import java.util.List;

public class TestArray {

    public static void main(String[] args) {
        int[] a = new int[16];
        System.out.println(a.length);

        List<Integer> b = new ArrayList<>(16);
        System.out.println(b.size());
    }
}
