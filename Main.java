import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Invoking main class...");
        System.out.println(TryStreams.tryParallelization());
        System.out.println(TryLambdas.trySupplier());
        System.out.println(TryLambdas.tryConsumer());
        System.out.println(TryLambdas.tryPredicate());
        System.out.println(TryLambdas.tryFunction());
        System.out.println(TryStreams.tryFlatMap());
        System.out.println(TryStreams.tryReduce());
        System.out.println(Reader.readFunctions("trySupplier", System.getProperty("user.dir") + "/src/TryLambdas.java"));

    }

}
