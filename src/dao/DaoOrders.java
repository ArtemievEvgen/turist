package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DB;
import entity.Orders;

public class DaoOrders implements DaoInterface<Orders>{
    private DB db;

    public DaoOrders(DB db) {
        this.db = db;
    }
    @Override
    public void insert(Orders ob) throws SQLException {
        PreparedStatement ps = db.getCn().prepareStatement("INSERT INTO " + ob.getClass().getSimpleName() + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");

        ps.setInt(1, ob.getId_order());
        ps.setInt(2, ob.getId_user());
        ps.setString(3, ob.getFam());
        ps.setString(4,  ob.getName());
        ps.setInt(5, ob.getId_room());
        ps.setString(6,  ob.getType());
        ps.setInt(7, ob.getKol_mest());
        ps.setString(8,  ob.getDate_ot());
        ps.setString(9,  ob.getDate_do());
        ps.setDouble(10,  ob.getCoast());
        ps.setString(11, ob.getStatus());
        ps.setString(12, ob.getPay());
        ps.setString(13, ob.getDel_status());

        ps.execute();

    }

    @Override
    public void update(Orders ob) throws SQLException {
        PreparedStatement ps = db.getCn().prepareStatement("UPDATE " + ob.getClass().getSimpleName() + " SET "
                + "id_user=?, fam=?, name=?, id_room=?, type=?, kol_mest=?, date_ot=?,date_do=?, "
                + "status=?, pay=?, del_status=? WHERE id_order=" + ob.getId_order());

        ps.setInt(1, ob.getId_user());
        ps.setString(2, ob.getFam());
        ps.setString(3,  ob.getName());
        ps.setInt(4, ob.getId_room());
        ps.setString(5,  ob.getType());
        ps.setInt(6, ob.getKol_mest());
        ps.setString(7,  ob.getDate_ot());
        ps.setString(8,  ob.getDate_do());
        ps.setDouble(9,  ob.getCoast());
        ps.setString(10, ob.getStatus());
        ps.setString(11, ob.getPay());
        ps.setString(12, ob.getDel_status());

        ps.execute();

    }

    @Override
    public void delete(Orders ob) throws SQLException {
        PreparedStatement ps = db.getCn().prepareStatement("DELETE FROM " + ob.getClass().getSimpleName() + " WHERE id_order=" + ob.getId_order());

        ps.execute();
    }

    public void delStatusDeActiv(Orders ob) throws SQLException {
        PreparedStatement ps = db.getCn().prepareStatement("UPDATE " + ob.getClass().getSimpleName() + " SET "
                + "del_status='de activ' WHERE id_order=" + ob.getId_order());

        ps.execute();


    }

    public void payYes(Orders ob) throws SQLException {
        PreparedStatement ps = db.getCn().prepareStatement("UPDATE " + ob.getClass().getSimpleName() + " SET "
                + "pay='yes' WHERE id_order=" + ob.getId_order());

        ps.execute();


    }

    public void StatusYes(Orders ob) throws SQLException {
        PreparedStatement ps = db.getCn().prepareStatement("UPDATE " + ob.getClass().getSimpleName() + " SET "
                + "status='yes' WHERE id_order=" + ob.getId_order());

        ps.execute();

    }

    public void StatusNo(Orders ob) throws SQLException {
        PreparedStatement ps = db.getCn().prepareStatement("UPDATE " + ob.getClass().getSimpleName() + " SET "
                + "status='no' WHERE id_order=" + ob.getId_order());

        ps.execute();

    }
}
