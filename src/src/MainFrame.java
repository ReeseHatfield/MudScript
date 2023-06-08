import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JTextArea textArea;
    private JButton compileBtn;

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());

        this.textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(scrollPane, BorderLayout.CENTER); // Center will occupy the majority of space

        this.compileBtn = new JButton("Compile");
        this.compileBtn.addActionListener(e -> {
            String code = this.textArea.getText();

            ScriptEngineManager manager = new ScriptEngineManager();

            ScriptEngine engine = manager.getEngineByName("JavaScript");

            try{
                engine.eval(code);
            } catch (ScriptException scriptException) {
                scriptException.printStackTrace();
            }
        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.add(this.compileBtn);

        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
