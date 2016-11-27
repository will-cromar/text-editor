import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
* Reads text line by line from file and appends to TextEditor
* Author: William Cromar
* E-mail Address: williamcromar58@gmail.com
* Programming Assignment: Project 6
* Last Changed: 11/18/14
*/

public class LoadButton extends JButton implements ActionListener {

    private TextEditor editor;
    
    public LoadButton(TextEditor editor) {
        super("Load");
        addActionListener(this);
        
        this.editor = editor;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Open BufferedReader
        Path filePath = Paths.get(editor.getFileName());
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(filePath);
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(editor, e1.getMessage());
            e1.printStackTrace();
            return;
        }
        
        //Clear text from area before reading
        editor.clearText();
        
        boolean loop = true;
        while (loop) {
            try {
                String line = reader.readLine();
                
                if (line == null) {
                    //If the line is empty, close stream and return
                    reader.close();
                    return;
                }
                else {
                    //If all is good, append a line
                    editor.appendText(line);
                }
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(editor, e1.getMessage());
                e1.printStackTrace();
                return;
            }
        }
    }

}
