package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author Arkadiusz Brych
 */
public class RandomGenerator {
    public static void main(String[] args) {
        List<Integer> abcList =
                fun(() -> {
                    Random rand = new Random();
                    return rand.nextInt();
                });

        performAction(abcList, x -> {
            System.out.println(x);
        });
        System.out.println("before >>>>>>>>>>>>>> after");

        removeIf(abcList, y -> {
            if (y % 2 == 0) {
                return true;
            }
            return false;
        });

        performAction(abcList, x -> {
            System.out.println(x);
        });
    }

    static List<Integer> fun(Supplier<Integer> generator) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(generator.get());
        }
        return numbers;
    }

    static void performAction(List<Integer> list, Consumer<Integer> consumer) {
        for (Integer element :
                list) {
            consumer.accept(element);
        }
    }

    static void removeIf(List<Integer> list, Predicate<Integer> predicate) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (predicate.test(iterator.next())) {
                iterator.remove();
            }
        }

    }
}
