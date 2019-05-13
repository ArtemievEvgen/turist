package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DB;
import entity.Rooms;

public class DaoRooms implements DaoInterface<Rooms> {
    private DB db;

    public DaoRooms(DB db) {
        this.db = db;
    }
    @Override
    public void insert(Rooms ob) throws SQLException {
        PreparedStatement ps = db.getCn().prepareStatement("INSERT INTO " + ob.getClass().getSimpleName() + " VALUES(?,?,?,?,?)");

        ps.setInt(1, ob.getId_room());
        ps.setString(2, ob.getType());
        ps.setInt(3, ob.getKol_mest());
        ps.setDouble(4, ob.getPrice());
        ps.setString(5, ob.getStatus());


        ps.execute();

    }

    @Override
    public void update(Rooms ob) throws SQLException {
        PreparedStatement ps = db.getCn().prepareStatement("UPDATE " + ob.getClass().getSimpleName() + " SET "
                + "type=?, kol_mest=?, price=?, status=? WHERE id_room=" + ob.getId_room());

        ps.setString(1, ob.getType());
        ps.setInt(2, ob.getKol_mest());
        ps.setDouble(3, ob.getPrice());
        ps.setString(4, ob.getStatus());


        ps.execute();

    }

    @Override
    public void delete(Rooms ob) throws SQLException {
        PreparedStatement ps = db.getCn().prepareStatement("DELETE FROM " + ob.getClass().getSimpleName() + " WHERE id_room=" + ob.getId_room());

        ps.execute();

    }

    public void statusBlok(Rooms ob) throws SQLException {
        PreparedStatement ps = db.getCn().prepareStatement("UPDATE " + ob.getClass().getSimpleName() + " SET "
                + "status='blok' WHERE id_room=" + ob.getId_room());

        ps.execute();

    }

    public void statusNotBlok(Rooms ob) throws SQLException {
        PreparedStatement ps = db.getCn().prepareStatement("UPDATE " + ob.getClass().getSimpleName() + " SET "
                + "status='not blok' WHERE id_room=" + ob.getId_room());

        ps.execute();

    }
}
