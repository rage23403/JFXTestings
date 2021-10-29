import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Write a description of JavaFX class JFXApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JFXApp extends Application
{
    Scene scene;
    Button btn = new Button("button");
    @Override
    public void start(Stage stage)
    {

        //default pane, origin at the top left of the screen
        Pane pane = new Pane();
        pane.setPrefSize(200,200);
        Rectangle rect = new Rectangle(50,50,Color.ORANGE);
        rect.relocate(20,20);
        pane.getChildren().add(rect);

        //a pane with a horizontal left-to-right orientation
        HBox horiz = new HBox();
        horiz.setPrefSize(200,200);
        horiz.getChildren().addAll(new Rectangle(100,100,Color.ORANGE), new Rectangle(100,100,Color.BLUE), new Rectangle(100,100,Color.BLACK));
        //will resize horizontally based on nodes added.

        //a pane with a vertical top-to-bottom orientation
        VBox verti = new VBox();
        verti.setPrefSize(200,200);
        verti.getChildren().addAll(new Rectangle(100,100,Color.ORANGE), new Rectangle(100,100,Color.BLUE), new Rectangle(100,100,Color.BLACK));
        //acts like the vertical alternative to HBox

        //a flow pane acts like a nes game where
        //you go out the right side and come in the left
        //if you resize the flow pane the wrapping also resizes. same with Tile pane
        //the main difference between a flow pane and a tile pane is
        //that in a tile pane, every tile takes up the same 
        //amount of space no matter what. if you add a small node
        //into a flow pane it won't add extra padding onto it.
        //
        //my preference for emulating a PPU or something like a CRT TV
        FlowPane flow = new FlowPane();
        flow.setVgap(10);
        flow.setHgap(10);
        flow.setPrefWrapLength(550);//this creates the base width
        for(int i = 0; i < 25; i++){
            if(i == 12){
                flow.getChildren().add(new Rectangle(80,80,Color.ORANGE));
            }
            else
                flow.getChildren().add(new Rectangle(100,100,Color.BLACK));
        }

        //a grid pane acts like a 2D array of nodes.
        //every node is set into a specific grid from 0,0 to n,n
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                grid.add(new Rectangle((j+1)*5,(i+1)*5,Color.BLACK),i,j);
            }
        }
        //grid pane isn't usually made with a double for loop.
        //the width of a column is based on the widest thing in the column
        //the height of a row is based on the tallest thing in the row
        
        

        //a stack pane lays out the nodes in a back to front order
        //think like a camera facing a bunch of pieces of paper.
        //each piece of paper you add is in front of the previous piece.
        StackPane stack = new StackPane();
        stack.setPrefSize(200,200);
        stack.getChildren().addAll(new Rectangle(100,100,Color.BLUE), new Rectangle(50,50,Color.BLACK), new Rectangle(25,25,Color.RED), new Rectangle(10,10,Color.WHITE));
        //unlike most other Panes, the stack pane's origin is in 
        //the middle rather than the top left corner.
        
        

        //tile pane must have set preferred columns OR rows to work
        //the tiles are all always the same size. if a new node is added
        //with larger parameters it will add padding onto the other
        //nodes to make them all take up the same space
        TilePane tile = new TilePane();
        tile.setHgap(8);
        tile.setVgap(8);
        tile.setPrefColumns(5);
        for (int i = 0; i < 25; i++) {
                tile.getChildren().add(new Rectangle(100,100,Color.BLACK));
        }
        
        

        //Anchor Pane is based on 
        //the distace a node is from the left/right/bottom/top edges
        AnchorPane anchor = new AnchorPane();
        anchor.setTopAnchor(btn, 50.0);
        anchor.setLeftAnchor(btn, 50.0);
        anchor.getChildren().add(btn);
        //setPrefSize will make the x and y minimum for the window
        //with a prefferred size you'll most likely 
        //want to just set the top and left anchors.
        anchor.setPrefSize(300,300);
        
        
        
        //A border pane is generally used to put in multiple different
        //panes onto a project with having the main pane
        //in the center usually, with stuff like a hotbar on the top or bottom
        BorderPane border = new BorderPane();
        border.setPrefSize(600,600);
        border.setTop(new Rectangle(400,100,Color.BLACK));
        border.setLeft(new Rectangle(100,200,Color.BLUE));
        border.setBottom(new Rectangle(400,100,Color.BLACK));
        border.setRight(new Rectangle(100,200,Color.BLUE));
        border.setCenter(new Rectangle(200,200,Color.RED));
        //left is aligned from the top left under "top"
        //right is aligned from the top right under "top"
        //top is aligned from the top left
        //bottom is aligned from the bottom left
        //center is aligned with the direct center
        
        
        
        //A region is basically just an object that has a background
        //and the base properties for the Pane classes.
        //it is not reccomended to use a region over any panes.
        Region reg = new Region();
        reg.setBackground(new Background(new BackgroundFill(Color.BLACK,new CornerRadii(0),new Insets(0))));
        //usually the only things you change with a region is the borders
        //insets, or size. You can't even access the children
        
        scene = new Scene(grid);
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);
        stage.show();
    }
}
