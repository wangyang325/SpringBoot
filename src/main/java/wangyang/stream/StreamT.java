package wangyang.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StreamT {
    @Test
    public void test1() {
        List<String> list = Arrays.asList("a","b");
        list.stream();
    }
}
