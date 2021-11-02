import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Using lambdas with JavaFX.
 * I decided to make this in JavaFX instead of Swing because in the newer versions of Java's developement kit,
 * they're planning on removing Swing all together. Swing has basically been outdated and just isn't as good -
 * to use or make something look visually appealing as in some other graphical interaces.
 * 
 * JavaFX was designed to sort-of compete with other Graphics libraries like OpenGL.
 * Swing used to be really useful but it's sort-of become pretty obsolete.
 * 
 * unlike in Swing, the main code must extend Application whereas,
 * in Swing you could just create a new Object of type JFrame.
 * 
 */
public class JFXLambda extends Application
{
    // We keep track of the count, and label displaying the count:
    private int count = 0;
    private Label myLabel = new Label("0");

    /**
     * The start method is the main entry point for every JavaFX application. 
     * It is called after the init() method has returned and after 
     * the system is ready for the application to begin running.
     * 
     * 
     * @param  stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage)
    {
        Button myButton = new Button("Count");

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        /**Lambda version #1*/
        myButton.setOnAction(this::buttonClick);
         
        /**Lambda version #2*/
        myButton.setOnAction(event -> {
            count = count+2;
            myLabel.setText(Integer.toString(count));
        });
        
        /**Non-Lambda version*/
        myButton.setOnAction(new ButtonEvent());

        // Add the button and label into the pane
        pane.add(myLabel, 1, 0);
        pane.add(myButton, 0, 0);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 300,100);
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
        //stage.setOnCloseRequest(event -> {Platform.exit(); System.exit(0);});
        /**
        * Essential in BlueJ because for some reason when you close the window it doesn't delete the object
        * Not usually essential in most other situations as far as I know.
        * Platform.exit() does the stop functions. System.exit() actually stops the program in BlueJ
        */
    }

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void buttonClick(ActionEvent event)
    {
        // Counts number of button clicks and shows the result on a label
        count = count + 1;
        myLabel.setText(Integer.toString(count));
    }
}

/**
 * Pros: You can make an entire class and variables that could be used in the event handler
 * 
 * Cons: you probably don't need to effect non-global variables in an event handler.
 *  -if you do this, you have no access to any private variables from the Application.
 * 
   */
class ButtonEvent implements EventHandler{
    public void handle(Event e){
        ((Button)e.getSource()).setText("loser");
    }
}
