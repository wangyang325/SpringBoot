package wangyang.lambda;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaT {
    public static void main(String[] args) {
        System.out.println("a");
    }

    public void type1 () {
        Runnable r = () -> System.out.println("---------------Run");
        r.run();
    }
    @Test
    public void type2 () {
        Consumer<String> con = (x) -> System.out.println("---------------Run");
        Consumer<String> con1 = x -> System.out.println("---------------Run");
        con.accept("a");
    }
    @Test
    public void type3 () {
        Comparator<Integer> com = (x, y) -> {
            return Integer.compare(x, y);
        };
    }

    @Test
    public void type4 () {
        int a = 1;
        int b =2;
        ICalculate cal = (x, y) -> x * y;
        System.out.println(cal.calculate(a,b));
    }

    @Test
    public void type5 () {
        List ls = new ArrayList();
        addA(ls, "a",
                (e) -> ls.forEach(System.out::println)
        );
    }

    @Test
    public void type6 () {
        System.out.println(operation(() -> Math.random()));
    }

    @Test
    public void type7 () {
        System.out.println(editS("a  ", (str) -> str.trim()));
    }

    public Double operation(Supplier<Double> sp) {
        return sp.get();
    }
    public void addA(List ls, String it, Consumer<List> con) {
        ls.add(it);
        con.accept(ls);
    }
    public String editS (String a, Function<String, String> fn) {
        return fn.apply(a);
    }

}
