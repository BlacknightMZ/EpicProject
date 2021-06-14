import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EventTest {
    public static void main(String[] args) {
        GraphicFrame frame = new GraphicFrame();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponentsToPane();
   
        frame.pack();
        frame.setVisible(true);
        frame.requestFocusInWindow();
    } 
}

class GraphicFrame extends JFrame implements ActionListener {
    static final String newline = System.getProperty("line.separator");
    private JTextArea displayArea;
    private JTextField typingArea;
    private GraphicPanel gPanel;

    void addComponentsToPane() {
        gPanel = new GraphicPanel();
        gPanel.setBackground(Color.BLUE);
        gPanel.setRequestFocusEnabled(true);
        gPanel.setPreferredSize(new Dimension(500, 500));
        getContentPane().add(gPanel, BorderLayout.CENTER);

        JButton button = new JButton("Start");
        button.addActionListener(this);
        getContentPane().add(button, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        gPanel.requestFocusInWindow();
    }
}

class GraphicPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        System.out.println("got " + e);
    }
}
