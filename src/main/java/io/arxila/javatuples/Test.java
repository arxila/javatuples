package io.arxila.javatuples;

public class Test {

    public static void main(String[] args) {
        Pair<String, String> pair = Pair.of("a", "b");
        System.out.println(pair.value0());
        System.out.println(pair.value1());
        Empty.of().withValue0("a").withValue1("b");
    }

}
