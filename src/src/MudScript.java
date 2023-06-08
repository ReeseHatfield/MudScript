import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MudScript {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine engine = manager.getEngineByName("JavaScript");


    }
}
