
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.layout.TilePane;
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

	        VBox root = new VBox(4);
	        root.setPadding(new Insets(10));
	        //root.setAlignment(Pos.BASELINE_RIGHT);
	        
	        Button newBtn = new Button("New Solution");
	        newBtn.setMaxWidth(2000);
	        newBtn.setMaxHeight(2000);
	        VBox.setVgrow(newBtn, Priority.ALWAYS);
	        
	        Button searchBtn = new Button("Search Solutions");
	        searchBtn.setMaxWidth(2000);
	        searchBtn.setMaxHeight(2000);
	        VBox.setVgrow(searchBtn, Priority.ALWAYS);
	        
	        Button helpBtn = new Button("Help");
	        helpBtn.setMaxWidth(2000);
	        helpBtn.setMaxHeight(2000);
	        VBox.setVgrow(helpBtn, Priority.ALWAYS);
	        
	        Button quitBtn = new Button("Quit");
	        quitBtn.setMaxWidth(2000);
	        quitBtn.setMaxHeight(2000);
	        VBox.setVgrow(quitBtn, Priority.ALWAYS);
	        
	        root.getChildren().addAll(newBtn, searchBtn, helpBtn, quitBtn);
	        root.setFillWidth(true);
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

