package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class page47 {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList(null, "", "1", "2");

        page47 p = new page47();
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = p.filter(listOfStrings, nonEmptyStringPredicate);

        // 打印值
        for (String s : nonEmpty) {
            System.out.println(s);
        }
    }

    public <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (t == null) {
                continue;
            }
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
