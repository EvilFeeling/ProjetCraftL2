package project;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ViewMenu extends HBox {
    Button BCraft = new Button("Craft");

    public ViewMenu(final ControllerMenu controllerM) {
    	BCraft.setOnAction(controllerM);
        this.getChildren().addAll(BCraft);
    }

    public Button getButton() {
        return BCraft;
    }
}
