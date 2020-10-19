
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Screen;
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
	        grid.setHgap(8);
	        grid.setVgap(8);
	        grid.setPadding(new Insets(5));
	       
	        
	    	ColumnConstraints cons1 = new ColumnConstraints();
	        cons1.setHgrow(Priority.NEVER);
	        
	        ColumnConstraints cons2 = new ColumnConstraints();
	        cons2.setHgrow(Priority.ALWAYS);
	        
	        RowConstraints rcons1 = new RowConstraints(50);
	        rcons1.setVgrow(Priority.ALWAYS);
	        
	        RowConstraints rcons2 = new RowConstraints(50);
	        rcons2.setVgrow(Priority.ALWAYS); 
	        
	        RowConstraints rcons3 = new RowConstraints(50);
	        rcons2.setVgrow(Priority.ALWAYS);
	        
	        RowConstraints rcons4 = new RowConstraints(50);
	        rcons2.setVgrow(Priority.ALWAYS);
	        
	        Label nameLbl = new Label("Name:");
	        
	        TextField nameField = new TextField();
	        
	        Label desLbl = new Label("Description:");
	        TextField desField = new TextField();
	        desField.setPrefHeight(800);
	        
	        Label solLbl = new Label("Solution:");
	        TextArea solField = new TextArea();
	        solField.setPrefHeight(400);
	        //solField.setAlignment(Pos.TOP_LEFT);
	       // solField.setPrefColumnCount();
	        
	        Button okBtn = new Button("OK");
	        
	        Button cnclBtn = new Button("Cancel");
	        
	        grid.add(nameLbl, 0, 0);
	        grid.add(nameField, 1, 0, 2, 1);
	        grid.add(desLbl, 0, 1);
	        grid.add(desField, 1, 1, 4, 2);
	        grid.add(solLbl, 0, 3);
	        grid.add(solField, 1, 3, 4, 2);
	        grid.add(okBtn,3 , 5);
	        grid.add(cnclBtn, 4, 5);
	        grid.getRowConstraints().addAll(rcons1, rcons2, rcons3, rcons4);
	        grid.getColumnConstraints().addAll(cons1, cons2);
	        
	        //GridPane.setMargin(nameLbl, new Insets(-1, -1, -1, -1));
	        //GridPane.setMargin(nameField, new Insets(-1, -1, -1, -1));
	       // GridPane.setMargin(desLbl, new Insets(-1, -1, -1, -1));
	       // GridPane.setMargin(desField, new Insets(-1, -1, -1, -1));
	        
	        Scene scene = new Scene(grid);
	        newSol.setMaximized(true);
	        newSol.setScene(scene);
	    	newSol.show();
	    	
	    }

	    public static void main(String[] args) 
	    {
	        launch(args);
	    }
	
	}

