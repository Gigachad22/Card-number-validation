import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Frame myframe = new Frame();
        Model m = new Model();
        Controller v = new Controller(myframe, m);
        v.Validate();
    }
}