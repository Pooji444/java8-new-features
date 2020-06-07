import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TryLambdas {

    public static String trySupplier() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nTrying Supplier: \n\n");
        Supplier<Person> personSupplier = () -> new Person("Gina", "gina@b99.com", 23);
        builder.append(personSupplier.get().getEmail());
        return builder.toString();
    }

    public static String tryConsumer() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nTrying Consumer: \n\n");
        Consumer<Integer> print = item -> builder.append(item).append(" ");
        Consumer<Integer> printEven = item -> {
            if(item % 2 == 0)
                print.accept(item);
        };

        Consumer<Integer> printOdd = item -> {
            if(item % 2 == 1)
                print.accept(item);
        };

        List<Integer> randomList = Arrays.asList(12, 38, 43, 44, 27, 33, 42, 56, 91, 28, 54, 36, 93);
        builder.append("All Numbers:");
        randomList.forEach(print);
        builder.append("\nEven numbers: ");
        randomList.forEach(printEven);
        builder.append("\nOdd numbers:");
        randomList.forEach(printOdd);
        return builder.toString();
    }

    public static String tryPredicate() {

        StringBuilder builder = new StringBuilder();
        builder.append("\nTrying Predicate:\n");
        List<Integer> randomList = Arrays.asList(12, 38, 43, 44, 27, 33, 42, 56, 91, 28, 54, 36, 93);

        Predicate<Integer> filterOddNumbers = item -> item % 2 == 0;
        Consumer<Integer> printNumber = item -> builder.append(item).append(" ");

        builder.append("\nEven numbers: ");
        randomList.stream().filter(filterOddNumbers).forEach(printNumber);
        return builder.toString();

    }

    public static String tryFunction() {
        StringBuilder builder = new StringBuilder();
        List<String> randomStrings = Arrays.asList("Gina", "Jake", "Amy", "Rosa");
        Function<String, String> toUpperCase = String::toUpperCase;
        Consumer<String> print = s -> builder.append(s + "\n");

        print.accept("Using Function:");
        randomStrings.forEach(s -> print.accept(toUpperCase.apply(s)));
        print.accept("");
        print.accept("Using Streams:");
        randomStrings.stream().map(toUpperCase).forEach(print);

        return builder.toString();


    }

}
