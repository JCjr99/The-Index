
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class UI extends Application 
{
	 @Override
	 public void start(Stage stage) 
	 {

	        initUI(stage);
	 }

	    private void initUI(Stage stage) 
	    {

	        VBox root = new VBox(5);
	        root.setPadding(new Insets(10));
	        //root.setAlignment(Pos.BASELINE_RIGHT);
	        
	        Button newBtn = new Button("New Solution");
	        Button searchBtn = new Button("Search Solutions");
	        Button helpBtn = new Button("Help");
	        Button quitBtn = new Button("Quit");
	        
	        root.getChildren().addAll(newBtn, searchBtn, helpBtn, quitBtn);

	        Scene scene = new Scene(root);
	        stage.setTitle("Row of buttons");
	        stage.setScene(scene);
	        stage.show();
	    }

	    public static void main(String[] args) 
	    {
	        launch(args);
	    }
	
	}

