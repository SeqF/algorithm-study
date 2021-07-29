package test;

import java.util.ArrayList;
import java.util.List;

public class TestA {

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(1);
        res.add(new ArrayList<>(path));
        System.out.println(res.toString());
        path.remove(0);
        System.out.println(res.toString());
    }
}
