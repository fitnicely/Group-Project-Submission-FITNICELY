import java.awt.*;
import java.net.URI;

public class YogaPage {

    //test code
    public static void main(String args[]){
        YogaData yoga = new YogaData();

        //beginner
        System.out.println("Here is your tutorial: ");
                try {
        Desktop.getDesktop().browse(new URI(yoga.getUrl_easy()));
    } catch (Exception e) {
        e.printStackTrace();
    }
        //intermediate
        System.out.println("Here is your tutorial: ");
        try {
            Desktop.getDesktop().browse(new URI(yoga.getUrl_intermediate()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //expert
        System.out.println("Here is your tutorial: ");
        try {
            Desktop.getDesktop().browse(new URI(yoga.getUrl_expert()));
        } catch (Exception e) {
            e.printStackTrace();
        }
}
}
