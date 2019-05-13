package DB;

import java.sql.SQLException;

import dao.DaoInfo;
import dao.DaoOrders;
import dao.DaoRooms;
import dao.DaoUsers;
import entity.Info;
import entity.Orders;
import entity.Rooms;
import entity.Users;

public class WorkDB {
    public static void createDB(String url, String nameDB, String login, String pass) throws SQLException {
        DB db = new DB(url, "", login, pass);

        db.update("CREATE DATABASE " + nameDB);
        db.update("USE " + nameDB);

        db.update("CREATE TABLE users(id_user INT NOT NULL AUTO_INCREMENT,"
                + " login VARCHAR(20) NOT NULL UNIQUE,"
                + " pass VARCHAR(20) NOT NULL,"
                + " rol INT(1) DEFAULT 2,"
                + " status VARCHAR(8) DEFAULT 'not blok',"
                + " PRIMARY KEY(id_user))");
		/*db.update("INSERT INTO users VALUES(1, 'admin', 'admin', 1, 'not blok')");
		db.update("INSERT INTO users (login, pass) VALUES('user1', '111')");
		db.update("INSERT INTO users (login, pass, status) VALUES('user2', '222', 'blok' )");
		db.update("INSERT INTO users VALUES(5, 'user3', '333', 2, 'not blok')");
		db.update("INSERT INTO users VALUES(6, 'admin1', 'admin1', 1, 'blok')");*/
        DaoUsers user = new DaoUsers(db);

        user.insert(new Users(1, "admin", "admin", 1, "not blok"));
        user.insert(new Users(2, "user1", "111", 2, "not blok"));
        user.insert(new Users(3, "user2", "222", 2, "blok"));
        user.insert(new Users(5, "user3", "333", 2, "not blok"));
        user.insert(new Users(6, "admin1", "admin1", 1, "blok"));


        db.update("CREATE TABLE info(id INT NOT NULL AUTO_INCREMENT,"
                + " id_user INT NOT NULL,"
                + " fam VARCHAR(20) DEFAULT '',"
                + " name VARCHAR(20) DEFAULT '',"
                + " tel VARCHAR(20) DEFAULT '',"
                + " PRIMARY KEY(id),"
                + " FOREIGN KEY(id_user) REFERENCES users(id_user))");
		/*db.update("INSERT INTO info VALUES(1, 2, 'Ivanov', 'Ivan', '+375291234567')");
		db.update("INSERT INTO info VALUES(2, 5, 'Petrv', 'Petr', '+375447116494')");*/
        DaoInfo info = new DaoInfo(db);
        info.insert(new Info(1, 2, "Ivanov", "Ivan", "+375291234567"));
        info.insert(new Info(2, 5, "Petrv", "Petr", "+375447116494"));

        db.update("CREATE TABLE rooms(id_room INT NOT NULL AUTO_INCREMENT,"
                + " type VARCHAR(8) DEFAULT 'econom',"
                + " kol_mest INT(1) DEFAULT 1,"
                + " price DOUBLE(6,2) DEFAULT 40.00,"
                + " status VARCHAR(8) DEFAULT 'not blok',"
                + " PRIMARY KEY(id_room))");
		/*db.update("INSERT INTO rooms VALUES(1, 'econom', 2, 50.00, 'not blok')");
		db.update("INSERT INTO rooms VALUES(2, 'standart', 2, 80.00, 'not blok')");
		db.update("INSERT INTO rooms VALUES(3, 'vip', 3, 200.00, 'not blok')");
		db.update("INSERT INTO rooms VALUES(4, 'econom', 3, 70.00, 'not blok')");
		db.update("INSERT INTO rooms VALUES()");
		db.update("INSERT INTO rooms VALUES()");*/
        DaoRooms room = new DaoRooms(db);
        room.insert(new Rooms(1, "econom", 2, 50.00, "not blok"));
        room.insert(new Rooms(2, "standart", 2, 80.00, "not blok"));
        room.insert(new Rooms(3, "vip", 3, 200.00, "not blok"));
        room.insert(new Rooms(4, "econom", 3, 70.00, "not blok"));


        db.update("CREATE TABLE orders(id_order INT NOT NULL AUTO_INCREMENT,"
                + " id_user INT NOT NULL,"
                + " fam VARCHAR(20) NOT NULL,"
                + " name VARCHAR(20) NOT NULL,"
                + " id_room INT NOT NULL,"
                + " type VARCHAR(8) NOT NULL,"
                + " kol_mest INT(1) NOT NULL,"
                + " date_ot VARCHAR(10) NOT NULL,"
                + " date_DO VARCHAR(10) NOT NULL,"
                + " coast DOUBLE(8,2) NOT NULL,"
                + " status VARCHAR(3) DEFAULT 'no',"
                + " pay VARCHAR(3) DEFAULT 'no',"
                + " del_status VARCHAR(8) DEFAULT 'activ',"
                + " PRIMARY KEY(id_order),"
                + " FOREIGN KEY(id_user) REFERENCES users(id_user),"
                + " FOREIGN KEY(id_room) REFERENCES rooms(id_room))");
		/*db.update("INSERT INTO orders VALUES(2, 5, 'Petrov', 'Petr', 3, 'vip', 3, '01/01/2018', '10/01/2018', 2000.00, 'yes', 'no', 'activ')");
		db.update("INSERT INTO orders VALUES(1, 2, 'Ivanov', 'Ivan', 1, 'econom', 2, '01/01/2018', '10/01/2018', 500.00, 'no', 'no', 'activ')");
		*/
        DaoOrders order = new DaoOrders(db);
        order.insert(new Orders(2, 5, "Petrov", "Petr", 3, "vip", 3, "01/01/2018", "10/01/2018", 2000.00, "yes", "no", "activ"));
        order.insert(new Orders(1, 2, "Ivanov", "Ivan", 1, "econom", 2, "01/01/2018", "10/01/2018", 500.00, "no", "no", "activ"));

        System.out.println("\n\n---------База данных создана---------------\n");

        System.out.println("\n---------------------------Users-------------------------------");
        db.showTable(db.query("SELECT * FROM users"));
        System.out.println("\n---------------------------Info-------------------------------");
        db.showTable(db.query("SELECT * FROM info"));
        System.out.println("\n---------------------------Rooms-------------------------------");
        db.showTable(db.query("SELECT * FROM rooms"));
        System.out.println("\n---------------------------Orders-------------------------------");
        db.showTable(db.query("SELECT * FROM orders"));


    }

    public static void deleteDB(String url, String nameDB, String login, String pass) throws SQLException {
        DB db = new DB(url, nameDB, login, pass);

        db.update("DROP DATABASE " + nameDB);


        System.out.println("\nБаза данных удалена\n");
    }
}
