package application.ui.button;

import javax.swing.*;
import java.awt.event.ActionListener;


public class ActionListenerButton extends JButton {

    public ActionListenerButton(ActionListener actionListener)
    {
        this.addActionListener(actionListener);
    }
}
