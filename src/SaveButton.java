import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
* Saves text from TextEditor to file
* Author: William Cromar
* E-mail Address: willliamcromar58@gmail.com
* Programming Assignment: Project 6
* Last Changed: 11/18/14
*/

public class SaveButton extends JButton implements ActionListener {

    private TextEditor editor;
    
    public SaveButton(TextEditor editor) {
        super("Save");
        addActionListener(this);
        
        this.editor = editor;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Open BufferedWriter
        Path filePath = Paths.get(editor.getFileName());
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(filePath);
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(editor, e1.getMessage());
            e1.printStackTrace();
            return;
        }
        
        try {
            //If all is good, write to file and close stream
            writer.write(editor.getWritableText());
            writer.close();
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(editor, e1.getMessage());
            e1.printStackTrace();
        }
    }
}
