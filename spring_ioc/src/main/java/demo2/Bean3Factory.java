package demo2;

public class Bean3Factory {
    public Bean3 createBean3() {
        System.out.println("Bean3执行");
        return new Bean3();
    }
}
