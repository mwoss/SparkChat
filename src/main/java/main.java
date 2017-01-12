/**
 * Created by Matthew on 2017-01-12.
 */
import static spark.Spark.*;

public class main {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
