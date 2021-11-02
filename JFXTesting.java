
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
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
    boolean shiftMod = false;
    boolean sideOpen = false;
    PlayerBlock p = new PlayerBlock(2,2,5,Color.WHITE);
    TilePane tiles;
    EventHandler<KeyEvent> KEOn = new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    int distance = 1 + (shiftMod ? 1 : 0);
                    
                    switch (event.getCode()) {
                        case UP:    movePlayer(1,distance);break;
                        case DOWN:  movePlayer(3,distance);break;
                        case LEFT:  movePlayer(0,distance);break;
                        case RIGHT: movePlayer(2,distance);break;
                        case SHIFT: shiftMod = true;break;
                        case ENTER: toggleSideBar(new ActionEvent());
                    }
                    event.consume();
                }
            };
    EventHandler<KeyEvent> KEOff = new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    
                    switch (event.getCode()) {
                        case SHIFT: shiftMod = false;break;
                    }
                    event.consume();
                }
            };
    @Override
    public void start(Stage stage)
    {
        primaryStage = stage;
        // Create a Button or any control item
        //button stuff
        Button but = new Button("lol");
        but.setOnAction(this::toggleSideBar);
        but.setFocusTraversable(false);

        Button downbtn = new Button("↓");
        downbtn.setOnAction(event ->movePlayer(3,1));
        downbtn.setFocusTraversable(false);

        Button upbtn = new Button("↑");
        upbtn.setOnAction(event ->movePlayer(1,1));
        upbtn.setFocusTraversable(false);

        Button leftbtn = new Button("←");
        leftbtn.setOnAction(event ->movePlayer(0,1));
        leftbtn.setFocusTraversable(false);

        Button rightbtn = new Button("→");
        rightbtn.setOnAction(event ->movePlayer(2,1));
        rightbtn.setFocusTraversable(false);

        //Horiz box stuff
        HBox topBar = new HBox();
        topBar.getChildren().addAll(but, new Label("nothing here"));

        GridPane movement = new GridPane();
        movement.add(upbtn,1,0);
        movement.add(downbtn,1,2);
        movement.add(leftbtn,0,1);
        movement.add(rightbtn,2,1);
        //tile pane stuff
        tiles = new TilePane();
        tiles.setPrefColumns(5);
        for (int i = 0; i < 25; i++) {
            tiles.getChildren().add(new Rectangle(100,100,Color.BLACK));
        }
        tiles.getChildren().set(5*p.getY()+p.getX(), new Rectangle(100,100,p.getColor()));

        //border pane stuff        
        border = new BorderPane();
        border.setCenter(tiles);
        border.setTop(topBar);
        border.setBottom(movement);

        //scene stuff
        Scene scene = new Scene(border);
        scene.setOnKeyPressed(KEOn);
        scene.setOnKeyReleased(KEOff);

        //stage stuff
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);
        stage.show();
    }

    public void movePlayer(int direction, int distance){
        if(p.move(direction,distance)){
            for (int i = 0; i < 25; i++) {
                tiles.getChildren().set(i,new Rectangle(100,100,Color.BLACK));
            }
            tiles.getChildren().set(5*p.getY()+p.getX(), new Rectangle(100,100,p.getColor()));
        }
    }

    public void toggleSideBar(ActionEvent e){
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
