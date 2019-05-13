package frames;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import DB.DB;
import dao.DaoOrders;
import dao.DaoUsers;
import entity.Orders;
import entity.Users;

public class AdminFrame extends JFrame{
    private DB db;
    private String login;
    private JPanel panel;
    private Table tableUsers, tableRooms, tableOrders;
    private JScrollPane scrollUsers, scrollRooms, scrollOrders;
    private JButton info, add1, update1, status1, rol, delete1, add2, update2, status2, delete2,
            add3, update3, status3, pay, del_status, delete3, backLoginFrame;

    public AdminFrame(DB db, String login) {
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
        panel = new JPanel();

        try {
            tableUsers = new Table(db.query("SELECT * FROM users"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        scrollUsers = new JScrollPane(tableUsers);
        try {
            tableRooms = new Table(db.query("SELECT * FROM rooms"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        scrollRooms = new JScrollPane(tableRooms);
        try {
            tableOrders = new Table(db.query("SELECT * FROM orders"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        scrollOrders = new JScrollPane(tableOrders);

        info = new JButton("info");
        add1 = new JButton("add");
        update1 = new JButton("update");
        rol = new JButton("rol");
        status1 = new JButton("status");
        delete1 = new JButton("delete");
        add2 = new JButton("add");
        update2 = new JButton("update");
        status2 = new JButton("status");
        delete2 = new JButton("delete");
        add3 = new JButton("add");
        update3 = new JButton("update");
        status3 = new JButton("status");
        pay = new JButton("pay");
        del_status = new JButton("del_status");
        delete3 = new JButton("delete");
        backLoginFrame = new JButton("backLoginFrame");


        panel.add(scrollUsers);
        panel.add(info);
        panel.add(add1);
        panel.add(update1);
        panel.add(rol);
        panel.add(status1);
        panel.add(delete1);

        panel.add(scrollRooms);
        panel.add(add2);
        panel.add(update2);
        panel.add(status2);
        panel.add(delete2);

        panel.add(scrollOrders);
        panel.add(add3);
        panel.add(update3);
        panel.add(status3);
        panel.add(pay);
        panel.add(del_status);
        panel.add(delete3);

        panel.add(backLoginFrame);

        scrollUsers.setPreferredSize(new Dimension(650, 150));
        scrollRooms.setPreferredSize(new Dimension(650, 150));
        scrollOrders.setPreferredSize(new Dimension(650, 150));
        backLoginFrame.setPreferredSize(new Dimension(650, 30));

        add(panel);
    }

    private void action() {

        status3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(tableOrders.getSelectedRow() != -1) {
                    DaoOrders order = new DaoOrders(db);
                    if(String.valueOf(tableOrders.getValueAt(tableOrders.getSelectedRow(), 10)).equals("no")) {
                        try {
                            order.StatusYes(new Orders(Integer.valueOf(String.valueOf(tableOrders.getValueAt(tableOrders.getSelectedRow(), 0)))));
                        } catch (NumberFormatException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }else {
                        try {
                            order.StatusNo(new Orders(Integer.valueOf(String.valueOf(tableOrders.getValueAt(tableOrders.getSelectedRow(), 0)))));
                        } catch (NumberFormatException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                    updateAdminFrame();
                }else {
                    JOptionPane.showMessageDialog(panel, "Выберите заказ");
                }


            }
        });



        tableUsers.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    DaoUsers user = new DaoUsers(db);
                    try {
                        user.update(new Users(Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0))),
                                String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 1)),
                                String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 2)),
                                Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 3))),
                                String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 4))	));
                        updateAdminFrame();
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(panel, "неверный тип данных");
                        updateAdminFrame();
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(panel, "нельзя отредактировать");
                    }
                }

                super.keyReleased(e);
            }


        });







        update1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(tableUsers.getSelectedRow() != -1) {
                    DaoUsers user = new DaoUsers(db);

                    //вся таблица
                    for(int i = 0; i < tableUsers.getRowCount(); i++) {
                        try {
                            user.update(new Users(Integer.valueOf(String.valueOf(tableUsers.getValueAt(i, 0))),
                                    String.valueOf(tableUsers.getValueAt(i, 1)),
                                    String.valueOf(tableUsers.getValueAt(i, 2)),
                                    Integer.valueOf(String.valueOf(tableUsers.getValueAt(i, 3))),
                                    String.valueOf(tableUsers.getValueAt(i, 4))	));

                        } catch (NumberFormatException e1) {
                            JOptionPane.showMessageDialog(panel, "неверный тип данных");
                            updateAdminFrame();
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(panel, "нельзя отредактировать");
                        }

                    }
                    updateAdminFrame();


					/*//редактируем выделенную строку
					try {
						user.update(new Users(Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0))),
								String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 1)),
								String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 2)),
								Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 3))),
								String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 4))	));
						updateAdminFrame();
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(panel, "неверный тип данных");
						updateAdminFrame();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panel, "нельзя отредактировать");
					}*/

                }else {
                    JOptionPane.showMessageDialog(panel, "Выберите пользователя для удаления");
                }

            }
        });




        delete1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(tableUsers.getSelectedRow() != -1) {
                    DaoUsers user = new DaoUsers(db);

                    if(Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 3))) != 1) {
                        try {
                            user.delete(new Users(Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0)))));
                            updateAdminFrame();
                        } catch (NumberFormatException e1) {
                            JOptionPane.showMessageDialog(panel, "неверный тип данных");
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(panel, "нельзя удалить");
                        }
                    }else {
                        JOptionPane.showMessageDialog(panel, login + " - вы не можете удалять админа");
                    }

                }else {
                    JOptionPane.showMessageDialog(panel, "Выберите пользователя для удаления");
                }

            }
        });


        status1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(tableUsers.getSelectedRow() != -1) {
                    DaoUsers user = new DaoUsers(db);
                    if(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 4)).equals("not blok") == true) {
                        try {
                            if(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 1)).equals(login) != true) {
                                if(Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 3))) != 1) {
                                    user.statusBlok(new Users(Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0)))));
                                }else {
                                    JOptionPane.showMessageDialog(panel, login + " - вы не можете заблокировать другого админа");
                                }
                            }else {
                                JOptionPane.showMessageDialog(panel, login + " - вы не можете заблокировать себя");
                            }
                        } catch (NumberFormatException e1) {
                            JOptionPane.showMessageDialog(panel, "неверный тип данных");
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(panel, "нельзя поменять роль");
                        }
                    }else {
                        try {
                            user.statusNotBlok(new Users(Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0)))));
                        } catch (NumberFormatException e1) {
                            JOptionPane.showMessageDialog(panel, "неверный тип данных");
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(panel, "нельзя поменять роль");
                        }
                    }
                    updateAdminFrame();
                }else {
                    JOptionPane.showMessageDialog(panel, "Выберите пользователя");
                }
            }
        });

        rol.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(tableUsers.getSelectedRow() != -1) {
                    DaoUsers user = new DaoUsers(db);
                    if(Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 3))) == 1) {
                        try {
                            if(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 1)).equals(login) != true) {
                                user.rolUser(new Users(Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0)))));
                            }else {
                                JOptionPane.showMessageDialog(panel, login + " - вы не можете поменять свою роль");
                            }
                        } catch (NumberFormatException e1) {
                            JOptionPane.showMessageDialog(panel, "неверный тип данных");
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(panel, "нельзя поменять роль");
                        }
                    }else {
                        try {
                            user.rolAdmin(new Users(Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0)))));
                        } catch (NumberFormatException e1) {
                            JOptionPane.showMessageDialog(panel, "неверный тип данных");
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(panel, "нельзя поменять роль");
                        }
                    }
                    updateAdminFrame();
                }else {
                    JOptionPane.showMessageDialog(panel, "Выберите пользователя");
                }
            }
        });


        add1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DaoUsers user = new DaoUsers(db);
                try {
                    user.insert(new Users("", "", 2, "not blok"));
                    updateAdminFrame();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(panel, "Невозможно добавить");
                }
            }
        });





        info.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder str = new StringBuilder();

                if(tableUsers.getSelectedRow() != -1) {
                    try {

                        ResultSet rs = db.query("SELECT * FROM info WHERE id_user=" + Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0))));

                        if(rs.next() == true) {
                            for(int i = 3; i <= rs.getMetaData().getColumnCount(); i++) {
                                str.append(rs.getString(i)).append("\n");
                            }
                            JOptionPane.showMessageDialog(panel, str);
                        }else {
                            JOptionPane.showMessageDialog(panel, "данные отсутствуют");
                        }

                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(panel, "ошибка в запросе");
                    }
                }else {
                    JOptionPane.showMessageDialog(panel, "Выберите пользователя");
                }

            }
        });

        backLoginFrame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame(db);
                dispose();
            }
        });

    }


    private void updateAdminFrame() {
        panel.removeAll();

        try {
            tableUsers = new Table(db.query("SELECT * FROM users"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        scrollUsers = new JScrollPane(tableUsers);
        try {
            tableRooms = new Table(db.query("SELECT * FROM rooms"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        scrollRooms = new JScrollPane(tableRooms);
        try {
            tableOrders = new Table(db.query("SELECT * FROM orders"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        scrollOrders = new JScrollPane(tableOrders);

        info = new JButton("info");
        add1 = new JButton("add");
        update1 = new JButton("update");
        rol = new JButton("rol");
        status1 = new JButton("status");
        delete1 = new JButton("delete");
        add2 = new JButton("add");
        update2 = new JButton("update");
        status2 = new JButton("status");
        delete2 = new JButton("delete");
        add3 = new JButton("add");
        update3 = new JButton("update");
        status3 = new JButton("status");
        pay = new JButton("pay");
        del_status = new JButton("del_status");
        delete3 = new JButton("delete");
        backLoginFrame = new JButton("backLoginFrame");


        panel.add(scrollUsers);
        panel.add(info);
        panel.add(add1);
        panel.add(update1);
        panel.add(rol);
        panel.add(status1);
        panel.add(delete1);

        panel.add(scrollRooms);
        panel.add(add2);
        panel.add(update2);
        panel.add(status2);
        panel.add(delete2);

        panel.add(scrollOrders);
        panel.add(add3);
        panel.add(update3);
        panel.add(status3);
        panel.add(pay);
        panel.add(del_status);
        panel.add(delete3);

        panel.add(backLoginFrame);

        scrollUsers.setPreferredSize(new Dimension(650, 150));
        scrollRooms.setPreferredSize(new Dimension(650, 150));
        scrollOrders.setPreferredSize(new Dimension(650, 150));
        backLoginFrame.setPreferredSize(new Dimension(650, 30));

        panel.updateUI();
        action();

    }



}