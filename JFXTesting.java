

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Write a description of JavaFX class JFXTesting here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JFXTesting extends Application
{
    Stage primaryStage;
    BorderPane border;
    boolean sideOpen = false;
    @Override
    public void start(Stage stage)
    {
        primaryStage = stage;
        // Create a Button or any control item
        Button myButton = new Button("Count");
        
        Button but = new Button("lol");
        //Horiz box
        HBox horiz = new HBox();
        horiz.getChildren().addAll(but, new Label("nothing here"));
        
        //tile pane
        TilePane tiles = new TilePane();
        tiles.setPrefColumns(5);
        for (int i = 0; i < 25; i++) {
                tiles.getChildren().add(new Rectangle(100,100,Color.BLACK));
        }        

        //border pane
        border = new BorderPane();
        border.setCenter(tiles);
        border.setTop(horiz);
        
        but.setOnAction(this::buttonAction);
        
        //scene stuff
        Scene scene = new Scene(border);
        
        //stage stuff
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);
        stage.show();
    }
    
    public void buttonAction(ActionEvent e){
        sideOpen = !sideOpen;
        if(sideOpen){
            border.setRight(new Rectangle(100,500,Color.WHITE));
            primaryStage.sizeToScene();
        }
        else{
            border.setRight(new Rectangle(0,0,Color.WHITE));
            primaryStage.sizeToScene();
        }
    }
}
