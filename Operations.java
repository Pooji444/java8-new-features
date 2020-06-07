import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Operations extends Application {

    GridPane gridPane = new GridPane();
    TextArea outputText = new TextArea();
    TextArea codeText = new TextArea();
    GridPane buttonsGridPane = new GridPane();
    GridPane lowerGridPane = new GridPane();
    GridPane upperGridPane = new GridPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button clearButton = new Button("Clear");
        String currentDirectory = System.getProperty("user.dir") + "/src/";

        List<OperationButton> buttons = Arrays.asList(
                new OperationButton(new Button("Streams and Parallel streams"), TryStreams.tryParallelization(), "tryParallelization", currentDirectory + "TryStreams.java"),
                new OperationButton(new Button("Try Consumer"), TryLambdas.tryConsumer(), "tryConsumer", currentDirectory + "TryLambdas.java"),
                new OperationButton(new Button("Try Supplier"), TryLambdas.trySupplier(), "trySupplier", currentDirectory + "TryLambdas.java"),
                new OperationButton(new Button("Try Predicate"), TryLambdas.tryPredicate(), "tryPredicate", currentDirectory + "TryLambdas.java"),
                new OperationButton(new Button("Try Function"), TryLambdas.tryFunction(), "tryFunction", currentDirectory + "TryLambdas.java"),
                new OperationButton(new Button("Try FlatMap"), TryStreams.tryFlatMap(), "tryFlatMap", currentDirectory + "TryStreams.java"),
                new OperationButton(new Button("Try Reduce"), TryStreams.tryReduce(), "tryReduce", currentDirectory + "TryStreams.java")
        );
        IntStream.range(0, buttons.size()).forEach(i -> addNewButton(buttons.get(i).getButton(), i + 1));

        outputText.setMinSize(900, 250);
        outputText.setEditable(false);
        codeText.setMinSize(500, 500);
        codeText.setEditable(false);
        gridPane.setMinSize(900, 700);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        upperGridPane.add(outputText, 0, 0);
        lowerGridPane.add(buttonsGridPane, 0, 0);
        lowerGridPane.add(codeText, 1, 1);
        lowerGridPane.add(clearButton, 1, 0);

        gridPane.add(upperGridPane, 0, 0);
        gridPane.add(lowerGridPane, 0, 1);

        clearButton.setOnAction(actionEvent -> outputText.clear());

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Java 8 operations");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void addNewButton(Button button, int position) {
        buttonsGridPane.add(button, 0, position);
    }

    class OperationButton {

        private Button button;

        public OperationButton(Button button, String output, String functionName, String fileName) {
            this.button = button;
            button.setOnAction(actionEvent -> {
                outputText.clear();
                outputText.setText(output);
                try {
                    codeText.setText(Reader.readFunctions(functionName, fileName));
                } catch (FileNotFoundException e) {
                    codeText.setText("File not found!");
                }
            });
        }

        public Button getButton() {
            return button;
        }
    }

}
