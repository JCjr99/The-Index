
import java.io.File;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.layout.TilePane;
import javafx.stage.FileChooser;
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
	        	newSolutionUI();
	        });
	        
	        Button searchBtn = new Button("Search Solutions");
	        searchBtn.setMaxWidth(2000);
	        searchBtn.setMaxHeight(2000);
	        VBox.setVgrow(searchBtn, Priority.ALWAYS);
	        searchBtn.setOnMouseClicked(e ->
	        {
	        	findSolutionUI();
	        });
	        
	        Button helpBtn = new Button("Help");
	        helpBtn.setMaxWidth(2000);
	        helpBtn.setMaxHeight(2000);
	        VBox.setVgrow(helpBtn, Priority.ALWAYS);
	        
	        Button quitBtn = new Button("Quit");
	        quitBtn.setMaxWidth(2000);
	        quitBtn.setMaxHeight(2000);
	        VBox.setVgrow(quitBtn, Priority.ALWAYS);
	        quitBtn.setOnMouseClicked(e -> {
	            Platform.exit();
	        });
	        
	        root.getChildren().addAll(newBtn, searchBtn, helpBtn, quitBtn);
	        root.setFillWidth(true);
	        Scene scene = new Scene(root);
	        stage.setTitle("Main Menu");
	        stage.setMaximized(true);
	        stage.setScene(scene);
	        stage.show();
	    }
	    
	    public static void newSolutionUI() 
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
	        rcons3.setVgrow(Priority.ALWAYS);
	        
	        RowConstraints rcons4 = new RowConstraints(50);
	        rcons4.setVgrow(Priority.ALWAYS);
	        
	        Label nameLbl = new Label("Name:");
	        
	        TextField nameField = new TextField();
	        
	        Label desLbl = new Label("Description:");
	        TextArea desField = new TextArea();
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
	        grid.add(okBtn, 3 , 5);
	        grid.add(cnclBtn, 4, 5);
	        grid.getRowConstraints().addAll(rcons1, rcons2);
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
	    
	    public static void findSolutionUI()
	    {
	    	Stage findStage = new Stage();
	        findStage.setTitle("Find Solution");

	    	GridPane grid = new GridPane();
	        grid.setHgap(8);
	        grid.setVgap(8);
	        grid.setPadding(new Insets(5));
	       
	        
	    	ColumnConstraints cons1 = new ColumnConstraints();
	        cons1.setHgrow(Priority.NEVER);
	        
	        ColumnConstraints cons2 = new ColumnConstraints();
	        cons2.setHgrow(Priority.ALWAYS);
	        
	        ColumnConstraints cons3 = new ColumnConstraints();
	        cons3.setHgrow(Priority.ALWAYS);
	        
	        RowConstraints rcons1 = new RowConstraints(50);
	        rcons1.setVgrow(Priority.ALWAYS);
	        
	        RowConstraints rcons2 = new RowConstraints(50);
	        rcons2.setVgrow(Priority.ALWAYS); 

	        Button searchButton = new Button("Search");
	        TextField searchField = new TextField();

	        ListView<String> listView = new ListView<String>();
	        listView.setCellFactory(lv -> 
	        {
	            ListCell<String> cell = new ListCell<String>() 
	            {
	                @Override
	                protected void updateItem(String item, boolean empty) 
	                {
	                    super.updateItem(item, empty);
	                    if (empty) 
	                    {
	                        setText(null);
	                    } else 
	                    {
	                        setText(item.toString());
	                    }
	                }
	            };
	        
		        cell.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> 
		        {
		            if (event.getButton()== MouseButton.PRIMARY && (! cell.isEmpty())) 
		            {
		                String item = cell.getItem();
		                //code here to fetch data about selected item
		                System.out.println("Clicked "+item);
		            }
		        });
		        return cell ;
		    });
	        listView.getItems().add("Item 1");
	        listView.getItems().add("Item 2");
	        listView.getItems().add("Item 3");

	        //HBox hbox = new HBox(listView);
	        
	        grid.add(searchField, 0, 0, 2, 1);
	        grid.add(searchButton, 2, 0);
	        grid.add(listView, 0, 1, 3, 3);
	        grid.getRowConstraints().addAll(rcons1, rcons2);
	        grid.getColumnConstraints().addAll(cons1, cons2);
	        Scene scene = new Scene(grid);
	        findStage.setMaximized(true);
	        findStage.setScene(scene);
	        findStage.show();
	    }

	    public static void main(String[] args) 
	    {
	        launch(args);
	    }
	
	}

