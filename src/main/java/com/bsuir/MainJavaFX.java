package com.bsuir;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainJavaFX extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Slider slider1 = new Slider(-10.0, 10.0, 0.0); // создаем слайдер, для которого установлены минимальное, максимальное и текущее значения;
        Slider slider2 = new Slider(-10.0, 10.0, 0.0);

        setProperties(slider1);
        setProperties(slider2);

        setActionOnEvent(slider1, slider2);
        setActionOnEvent(slider2, slider1);

        Button btn = new Button("Reset");
        btn.setAlignment(Pos.CENTER);
        btn.setOnAction(event -> {
            slider1.setValue(0);
            slider2.setValue(0);
        });

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10); //Setting the space between the nodes of a VBox pane

        //Setting the margin to the nodes
        vBox.setMargin(btn, new Insets(20, 20, 20, 20));
        vBox.setMargin(slider1, new Insets(20, 20, 20, 20));
        vBox.setMargin(slider2, new Insets(20, 20, 20, 20));

        ObservableList list = vBox.getChildren();
        list.addAll(btn, slider1, slider2);

        Scene scene = new Scene(vBox, 300, 250);

        stage.setScene(scene);
        stage.setTitle("Slider in JavaFX");
        stage.show();
    }

    private void setProperties(Slider slider2) {
        slider2.setShowTickMarks(true); // значение true (по умолчанию) делает деления на шкале слайдера видимыми, соответственно значение false делает деления невидимыми;
        slider2.setShowTickLabels(true); //  устанавливает видимость числовых меток на шкале;
        slider2.setBlockIncrement(2.0); //  устанавливает, насколько значений будет перемещаться бегунок слайдера с помощью клавиатурных клавиш Вперед и Назад при горизонтальной ориентации и клавиш Вверх и Вниз при вертикальной ориентации;
        slider2.setMajorTickUnit(5.0); // устанавливает расстояниие между двумя числовыми отметками на шкале;
        slider2.setMinorTickCount(4); //  устанавливает количество делений между двумя числовыми отметками на шкале;
        slider2.setSnapToTicks(true); // при передачи значения true позволяет переходить ровно по делениям (то есть вместо значения типа 4.5677687 будет 5)
    }

    private void setActionOnEvent(Slider slider1, Slider slider2) {
        slider1.valueProperty().addListener((changed, oldValue, newValue) -> {
            slider2.setValue(0 - newValue.doubleValue());
        });
    }
}
