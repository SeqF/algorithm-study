package test;

import javax.print.attribute.standard.PrinterName;

public class StringBuilderTest {

    private static void printName(StringBuilder builder, String name) {
        builder.append(name);
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        printName(builder, "AAA");
        builder.append("hello");
        System.out.println(builder.toString());
    }
}
