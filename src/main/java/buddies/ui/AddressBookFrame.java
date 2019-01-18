package buddies.ui;

import java.awt.*;
import javax.swing.*;


public class AddressBookFrame extends JFrame {
    public void init() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new Dimension(600, 400));

        setVisible(true);
        setState(Frame.NORMAL);
        show();
    }
}