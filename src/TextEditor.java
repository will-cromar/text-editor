import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
* Basic text file editor
* Author: William Cromar
* E-mail Address: williamcromar58@gmail.com
* Programming Assignment: Project 6
* Last Changed: 11/18/14
*/

public class TextEditor extends JFrame {

    private JTextField fileNameField;
    private JTextArea textArea;
    
    public TextEditor() {
        super("Text Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(50, 50, 350, 400);
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        //File name and load button
        Box loadBox = Box.createHorizontalBox();
        fileNameField = new JTextField("new.txt");
        loadBox.add(fileNameField);
        loadBox.add(new LoadButton(this));
        add(loadBox, "North");
        
        //Put main text area in scoll pane
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, "Center");
        
        //Put save button on the bottom
        add(new SaveButton(this), "South");
    }
    
    public String getFileName() {
        return fileNameField.getText();
    }
    
    public String getWritableText() {
        return textArea.getText();
    }
    
    public void clearText() {
        textArea.setText("");
    }
    
    public void appendText(String line) {
        //Append carriage return to each line
        textArea.append(line + "\n");
    }
    
    public static void main(String[] args) {
        //Create the window
        TextEditor window = new TextEditor();
        window.setVisible(true);
    }

}
