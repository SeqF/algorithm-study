package test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 2, 4);
        int level1 = 1;
        int level2 = 2;
        int level3 = 3;

//        List<Integer> collect = list.stream().filter(t -> t < level1).collect(Collectors.toList()).get();
//        System.out.println(collect.get(collect.size() - 1));

    }
}
