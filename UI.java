
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
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
	        newBtn.setOnMouseClicked(e -> 
	        {
	        	NewSolutionUI();
	        });
	        
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
	    
	    public static void NewSolutionUI() 
	    {
	    	Stage newSol = new Stage();
	    	GridPane grid = new GridPane();
	        
	    	ColumnConstraints cons1 = new ColumnConstraints();
	        cons1.setHgrow(Priority.NEVER);
	        
	        ColumnConstraints cons2 = new ColumnConstraints();
	        cons2.setHgrow(Priority.ALWAYS);
	        
	        RowConstraints rcons1 = new RowConstraints();
	        rcons1.setVgrow(Priority.ALWAYS);
	        
	        RowConstraints rcons2 = new RowConstraints();
	        rcons2.setVgrow(Priority.ALWAYS); 
	        
	        Label nameLbl = new Label("Name:");
	        TextField nameField = new TextField();
	        Label desLbl = new Label("Descrition:");
	        TextField desField = new TextField();
	        
	        grid.add(nameLbl, 0, 0);
	        grid.add(nameField, 1, 0, 2, 1);
	        grid.add(desLbl, 0, 2);
	        grid.add(desField, 1, 2, 2, 1);
	        grid.getRowConstraints().addAll(rcons1, rcons2);
	        grid.getColumnConstraints().addAll(cons1);
	        
	        Scene scene = new Scene(grid, 280, 300);
	        
	        newSol.setScene(scene);
	    	newSol.show();
	    	
	    }

	    public static void main(String[] args) 
	    {
	        launch(args);
	    }
	
	}

