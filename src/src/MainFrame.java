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
        //frame creation

        //initialize fields
        this.textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(scrollPane, BorderLayout.CENTER); 
        // center will occupy the majority of space

        //initialize compile button
        this.compileBtn = new JButton("Compile");
        
        this.compileBtn.addActionListener(e -> {

            //compile button action
            String code = this.textArea.getText();

            ScriptEngineManager manager = new ScriptEngineManager();
            //add text field to script managers engine

            ScriptEngine engine = manager.getEngineByName("JavaScript");

            //Attempt to evaluate the code provided
            try{
                engine.eval(code);
            } catch (ScriptException scriptException) {
                scriptException.printStackTrace();
            }
        });

        //Add buttons to panel and panel to root
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.add(this.compileBtn);

        this.add(buttonPanel, BorderLayout.SOUTH);
        
        //set all elements to be visible
        this.setVisible(true);
    }
}
