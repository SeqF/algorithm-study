package test;

import java.io.ByteArrayInputStream;
import java.util.Locale;

public class TestLocale {

    public static void main(String[] args) {
        System.out.println(Locale.TRADITIONAL_CHINESE);
        String locale = "zh-CN";
        System.out.println(Locale.forLanguageTag(locale).toString());
    }
}
