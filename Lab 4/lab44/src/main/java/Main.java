import Controller.Controller;
import org.json.simple.JSONArray;

public class Main {

    public static void main( String[] args) throws Exception {

        Controller myController = new Controller(System.in);

        JSONArray result = myController.calculation();

        System.out.println(result);

    }
}