package nata_prog;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Graph extends Application {
    ObservableList<XYChart.Data<Number, Number>> xyList1 = FXCollections.observableArrayList();
    ObservableList<XYChart.Data<Number, Number>> xyList2 = FXCollections.observableArrayList();

    int start = 0;

    public Task<Number> task;

    private LineChart<Number,Number> lineChart;

    private XYChart.Series xySeries1;
    private XYChart.Series xySeries2;

    private NumberAxis xAxis;

    private int lastObservedSize;

    public Number X = 0;
    public Number Y1 = 0;
    public Number Y2 = 0;

    @Override public void start(Stage stage) {
        xyList1.addListener((ListChangeListener<XYChart.Data<Number, Number>>) change -> {
            if (change.getList().size() - lastObservedSize > 10) {
                lastObservedSize += 10;
            }
        });

        stage.setTitle("Line Chart");
        xAxis = new NumberAxis();
        xAxis.setLabel("Iteratation");

        final NumberAxis yAxis = new NumberAxis();
        lineChart = new LineChart<>(xAxis,yAxis);

        lineChart.setTitle("VOVA");
        lineChart.setAnimated(false);

        task = new Task<Number>() {
            @Override
            protected Number call() throws Exception {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException iex) {
                        Thread.currentThread().interrupt();
                    }

                    if (isCancelled()) {
                        break;
                    }
                    X = X.doubleValue() + Math.random();
                    updateValue(X);
                    Y1 = Y1.doubleValue() +  Math.random();
                    Y2 = Y2.doubleValue() + Math.random();
                }
                return X;
            }
        };

        task.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldNumber, Number newNumber) {

                xyList1.add(new XYChart.Data(newNumber, Y1));
                xyList2.add(new XYChart.Data(newNumber, Y2));

            }
        });


        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(task);


        Scene scene  = new Scene(lineChart,800,600);


        xySeries1 = new XYChart.Series(xyList1);
        xySeries1.setName("Line 1");

        xySeries2 = new XYChart.Series(xyList2);
        xySeries2.setName("Line 2");

        lineChart.getData().addAll(xySeries1, xySeries2);


        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(windowEvent -> { task.cancel(); });
    }

    public void generateGraph() {
        launch(null);
    }

}
