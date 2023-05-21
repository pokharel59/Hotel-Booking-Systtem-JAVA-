package CustomerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class designedText extends JTextField implements FocusListener {
    private static final int ARC_RADIUS = 15;
    private String placeHolder;
    private Color placeHolderColor;

    public designedText(String placeHolder){
        this.placeHolder = placeHolder;
        this.placeHolderColor = new Color(169, 169, 169);
        setText(placeHolder);
        setForeground(placeHolderColor);
        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e){
        if(this.getText().equals(placeHolder)){
            this.setForeground(Color.black);
            this.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e){
        if(this.getText().isEmpty()){
            this.setForeground(placeHolderColor);
            this.setText(placeHolder);
        }
    }
}
