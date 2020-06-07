import java.util.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class TryStreams {

    public static String tryParallelization() {
        StringBuilder builder = new StringBuilder(1000);
        List<Integer> list1 = new ArrayList<>();

        builder.append("\nTrying Stream: \n");
        builder.append("\nSequential stream: ");
        IntStream.range(0, 100).forEach(list1::add);
        list1.forEach(item -> builder.append(item).append(" "));
        builder.append("\nParallel stream: ");
        list1.parallelStream().forEach(item -> builder.append(item).append(" "));

        return builder.toString();
    }

    public static String tryFlatMap() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nTrying FlatMap:\n");
        Consumer<String> printString = s -> builder.append(s).append(" ");
        Consumer<Integer> printInt = i -> builder.append(i).append(" ");

        List<Integer> integers1 = Arrays.asList(1, 2, 3, 7, 3, 4, 8);
        List<Integer> integers2 = Arrays.asList(6, 9, 0, 5);
        List<Integer> integers3 = Arrays.asList(9, 2, 8, 7, 3);
        printString.accept("\nOriginal lists:");
        printString.accept("\nList1: ");
        integers1.forEach(printInt);
        printString.accept("\nList2: ");
        integers2.forEach(printInt);
        printString.accept("\nList3: ");
        integers3.forEach(printInt);

        printString.accept("\n\nFlat list: ");
        List<List<Integer>> resultList = Arrays.asList(integers1, integers2, integers3);
        resultList.stream().flatMap(Collection::stream).forEach(printInt);

        return builder.toString();
    }

    public static String tryReduce() {
        StringBuilder builder = new StringBuilder();
        List<Integer> integersList = new ArrayList<>(20);
        IntStream.range(0, 20).forEach(item -> integersList.add(new Random().nextInt(100)));
        Consumer<Integer> printInt = item -> builder.append(item).append(" ");

        builder.append("\nTrying reduce: \n");
        builder.append("\nOriginal list: ");
        integersList.forEach(printInt);

        builder.append("\nMax value: ");
        builder.append(
                integersList.stream()
                .max(Comparator.naturalOrder())
                .orElse(null)
        );

        builder.append("\nMin value: ");
        builder.append(
                integersList.stream()
                .min(Comparator.naturalOrder())
                .orElse(null)
        );

        builder.append("\nMin value greater than 30: ");
        builder.append(
                integersList.stream()
                .filter(item -> item > 30)
                .min(Comparator.naturalOrder())
                .orElse(null)
        );

        builder.append("\nMax value less than 80: ");
        builder.append(
                integersList.stream()
                .filter(item -> item < 80)
                .max(Comparator.naturalOrder())
                .orElse(null)
        );

        return builder.toString();
    }

}
