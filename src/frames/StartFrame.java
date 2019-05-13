package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DB.DB;
import DB.WorkDB;

public class StartFrame extends JFrame{
    private JPanel panel;
    private JLabel labelUrl, labelNameDB, labelLogin, labelPass;
    private JTextField url, nameDB, login;
    private JPasswordField pass;
    private JButton createDB, deleteDB, connect;


    public StartFrame() {
        setTitle("StartFrame");
        setSize(290, 180);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        initComponents();
        action();

        setVisible(true);
    }

    private void initComponents() {
        panel = new JPanel();

        labelUrl = new JLabel("url");
        labelNameDB = new JLabel("nameDB");
        labelLogin = new JLabel("login");
        labelPass = new JLabel("pass");

        url = new JTextField("jdbc:mysql://127.0.0.1/", 20);
        nameDB = new JTextField("turist", 20);
        login = new JTextField("root", 20);

        pass = new JPasswordField("root", 20);

        createDB = new JButton("createDB");
        deleteDB = new JButton("deleteDB");
        connect = new JButton("connect");

        panel.add(labelUrl);
        panel.add(url);
        panel.add(labelNameDB);
        panel.add(nameDB);
        panel.add(labelLogin);
        panel.add(login);
        panel.add(labelPass);
        panel.add(pass);
        panel.add(createDB);
        panel.add(deleteDB);
        panel.add(connect);

        add(panel);
    }

    private void action() {

        deleteDB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    WorkDB.deleteDB(url.getText(), nameDB.getText(), login.getText(), String.valueOf(pass.getPassword()));
                    JOptionPane.showMessageDialog(panel, "Молодец!!!\\n\nТы удалил всю базу данных " + nameDB.getText(), ":-)", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(panel, "Удалить нельзя\nБазы данных " + nameDB.getText() + " не существует", ":-(", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        createDB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    WorkDB.createDB(url.getText(), nameDB.getText(), login.getText(), String.valueOf(pass.getPassword()));
                    JOptionPane.showMessageDialog(panel, "База данных " + nameDB.getText() + " успешно создана", ":-)", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(panel, "Создать нельзя\nБаза данных " + nameDB.getText() + " уже существует", ":-(", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        connect.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DB db = new DB(url.getText(), nameDB.getText(), login.getText(), String.valueOf(pass.getPassword()));
                    new LoginFrame(db);
                    dispose();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(panel, "Ошибка при подключении", ":-(", JOptionPane.ERROR_MESSAGE);
                }

            }
        });


    }



}
