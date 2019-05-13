package frames;
import javax.swing.JFrame;

import DB.DB;

public class UserFrame extends JFrame{
    private DB db;
    private String login;

    public UserFrame(DB db, String login) {
        this.db = db;
        this.login = login;
        setTitle("Привет " + login);
        setSize(700, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        initComponents();
        action();

        setVisible(true);
    }

    private void initComponents() {
        // TODO Auto-generated method stub

    }

    private void action() {
        // TODO Auto-generated method stub

    }
}
