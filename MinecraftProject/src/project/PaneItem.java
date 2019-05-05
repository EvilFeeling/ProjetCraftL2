package project;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class PaneItem extends Pane{
	String basePan = "-fx-border-color: WHITE;-fx-background-color: #c6c6c6; -fx-effect: innershadow( three-pass-box, rgba( 0, 0, 0, 0.5 ), 10, 0.2, 1, 1 ); -fx-font-size:10;";

	int ti = 48;
	int tc = ti + 10;
	public String nom = "vide"; // Si pas d'item alors vide, sinon nom de l'item
	public String typePan = new String();
	
	public PaneItem() {
		

		this.setStyle(basePan);
		this.setPrefSize(tc,tc);
		this.setMaxSize(tc, tc);
		

		this.setOnMouseEntered(new EventHandler<MouseEvent>(){
			
	        public void handle(MouseEvent me){
	        	Pane k = (Pane)me.getTarget();
	        	k.setStyle("-fx-background-color: GREY; -fx-font-size:10;");
	        }
	    });
		
	    this.setOnMouseExited(new EventHandler<MouseEvent>(){
	        public void handle(MouseEvent me){
	        	Pane k = (Pane)me.getTarget();
	        	k.setStyle(basePan);
	        }
	    });
	}
	public void draw(String n,int end) {
		if (n == "Ascendant") {
			Line line = new Line(tc, tc/2,   tc+tc/2,  tc / 2);
			line.setStroke(Color.WHITE);
			line.setStrokeWidth(5);
			if (end != 0) {
				Line angle = new Line( tc+tc/2,  tc / 2,   tc+tc/2,  tc / 2 + tc + 15);
				angle.setStroke(Color.WHITE);
				angle.setStrokeWidth(5);
				this.getChildren().add(angle);
			}
			this.getChildren().add(line);
			
			
		}
		if (n == "Descendant") {
			Line line = new Line(0, tc/2,   -tc/2,  tc / 2);
			line.setStroke(Color.WHITE);
			line.setStrokeWidth(5);
			Line angle = new Line();
			
			
			if (end == 0) {
				angle = new Line(-tc/2,  tc / 2,-tc/2,- (ti) );

			}
			else if (end == 1 || end == 2) {
				angle = new Line(-tc/2,  tc / 2,-tc/2,- (tc) * 2 - 10);
				
			}
			else if (end == 3) {
				angle = new Line(-tc/2,  tc / 2,-tc/2,- (tc) * 2 - 10);

			}
			else if (end == 4 ) {
				angle = new Line(-tc/2,  tc / 2,-tc/2,- (tc) * 3 - 30);
			}
			angle.setStroke(Color.WHITE);
			angle.setStrokeWidth(5);
			this.getChildren().addAll(line,angle);
			
			
			
		}

		
		
	}
}
