package frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DB.DB;

public class LoginFrame extends JFrame{
    private JPanel panel;
    private JLabel labelLogin, labelPass;
    private JTextField login;
    private JPasswordField pass;
    private JButton ok, registration, back;
    private DB db;


    public LoginFrame(DB db) {
        this.db = db;
        setTitle("LoginFrame");
        setSize(290, 140);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        initComponents();
        action();

        setVisible(true);
    }


    private void initComponents() {
        panel = new JPanel();

        labelLogin = new JLabel("login");
        labelPass = new JLabel("pass");

        login = new JTextField("admin", 20);

        pass = new JPasswordField("admin", 20);

        ok = new JButton("ok");
        registration = new JButton("registration");
        back = new JButton("back");

        panel.add(labelLogin);
        panel.add(login);
        panel.add(labelPass);
        panel.add(pass);
        panel.add(ok);
        panel.add(registration);
        panel.add(back);

        add(panel);
    }


    private void action() {
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(login.getText().equals("") != true) {
                    login.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                }else {
                    login.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
                if(String.valueOf(pass.getPassword()).equals("") != true) {
                    pass.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                }else {
                    pass.setBorder(BorderFactory.createLineBorder(Color.RED));
                }

                if(login.getText().equals("") != true && String.valueOf(pass.getPassword()).equals("") != true) {
                    try {
                        ResultSet rs = db.query("SELECT * FROM users WHERE login='" + login.getText() + "'");//!!!!!!!!!!!!!
                        if(rs.next() == true) {
                            if(String.valueOf(pass.getPassword()).equals(rs.getString("pass")) == true) {
                                if(rs.getString("status").equals("not blok")) {
                                    if(rs.getInt("rol") == 1) {
                                        //admin
                                        new AdminFrame(db, login.getText());
                                        dispose();
                                    }else {
                                        //user
                                        new UserFrame(db, login.getText());
                                        dispose();
                                    }
                                }else {
                                    JOptionPane.showMessageDialog(panel, "Пользователь заблокирован");
                                }
                            }else {
                                JOptionPane.showMessageDialog(panel, "Пароль не верный");
                            }
                        }else {
                            JOptionPane.showMessageDialog(panel, "Пользователь с логином " + login.getText() + " не зарегестрирован");
                        }
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(panel, "Ошибка в запросе на проверку логина");
                    }
                }else {
                    JOptionPane.showMessageDialog(panel, "Заполните все поля");
                }

            }
        });

        registration.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrationFrame(db);
                dispose();
            }
        });

        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new StartFrame();
                dispose();
            }
        });

    }
}