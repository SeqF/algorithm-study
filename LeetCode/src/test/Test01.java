package test;

public class Test01 {
    public static void main(String[] args) {
        Human human = new Man();
        human.initSex();
        ((Man) human).initSexB();
    }
}
