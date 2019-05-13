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
import dao.DaoUsers;
import entity.Users;

public class RegistrationFrame extends JFrame{
    private JPanel panel;
    private JLabel labelLogin, labelPass, labelPass1;
    private JTextField login;
    private JPasswordField pass, pass1;
    private JButton ok, back;
    private DB db;


    public RegistrationFrame(DB db) {

        this.db = db;
        setTitle("Регистрация");
        setSize(290, 170);
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
        labelPass1 = new JLabel("pass");

        login = new JTextField("", 20);

        pass = new JPasswordField("", 20);
        pass1 = new JPasswordField("", 20);

        ok = new JButton("ok");
        back = new JButton("back");

        panel.add(labelLogin);
        panel.add(login);
        panel.add(labelPass);
        panel.add(pass);
        panel.add(labelPass1);
        panel.add(pass1);
        panel.add(ok);
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
                if(String.valueOf(pass1.getPassword()).equals("") != true) {
                    pass1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                }else {
                    pass1.setBorder(BorderFactory.createLineBorder(Color.RED));
                }

                if(String.valueOf(pass1.getPassword()).equals(String.valueOf(pass.getPassword())) != true) {
                    JOptionPane.showMessageDialog(panel, "Пароли не совпадают", ":-(", JOptionPane.ERROR_MESSAGE);
                }

                if(String.valueOf(pass1.getPassword()).equals(String.valueOf(pass.getPassword())) == true && String.valueOf(pass.getPassword()).equals("") != true && login.getText().equals("") != true) {
                    try {
                        ResultSet rs = db.query("SELECT * FROM users WHERE login='" + login.getText() + "'");

                        if(rs.next() == true) {
                            JOptionPane.showMessageDialog(panel, "Пользователь с логином " + login.getText() + " уже зарегестрирован", ":-)", JOptionPane.INFORMATION_MESSAGE);
                        }else {
                            DaoUsers user = new DaoUsers(db);
                            user.insert(new Users(login.getText(), String.valueOf(pass.getPassword()), 2, "not blok"));
                            JOptionPane.showMessageDialog(panel, "Пользователь успешно зарегестрирован", ":-)", JOptionPane.INFORMATION_MESSAGE);
                            new LoginFrame(db);
                            dispose();
                        }
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(panel, "Ошибка при чтении из таблицы users", ":-)", JOptionPane.INFORMATION_MESSAGE);
                    }

                }else {
                    JOptionPane.showMessageDialog(panel, "Error");
                }



            }
        });

        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame(db);
                dispose();
            }
        });
    }
}