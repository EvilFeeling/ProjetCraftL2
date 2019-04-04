package project;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerMenu implements EventHandler {
    private final Stage primaryStage;
    private final ViewMenu view = new ViewMenu(this);
    Modele mdl;

    public ControllerMenu(final Stage primaryStage, Modele modl) {
        this.primaryStage = primaryStage;
        this.mdl = modl;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ViewMenu getView() {
        return view;
    }

	@Override
	public void handle(Event event) {
		final Button source = (Button)event.getSource();
        if (source.getText() == "Craft") {
            System.out.println("ButtonCraft has been pressed, switching to ViewCraft.");

            final ControllerCraft controllerC = new ControllerCraft(primaryStage, mdl);
            final Scene scene = new Scene(controllerC.getView());
            primaryStage.setScene(scene);
        }
		
	}
}