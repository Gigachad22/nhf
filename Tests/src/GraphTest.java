import controller.Controller;
import model.Graph;
import org.junit.Before;

public class GraphTest {

    @Before
    public void setup(){
        Graph graph = new Graph();
        graph = Controller.createK4();

    }
}
