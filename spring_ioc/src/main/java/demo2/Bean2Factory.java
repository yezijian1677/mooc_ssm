package demo2;

public class Bean2Factory {

    public static Bean2 createBean2() {
        System.out.println("一致性");
        return  new Bean2();
    }
}
