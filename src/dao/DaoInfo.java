package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DB;
import entity.Info;

public class DaoInfo implements DaoInterface<Info>{
    private DB db;

    public DaoInfo(DB db) {
        this.db = db;
    }
    @Override
    public void insert(Info ob) throws SQLException {
        PreparedStatement ps = db.getCn().prepareStatement("INSERT INTO " + ob.getClass().getSimpleName() + " VALUES(?,?,?,?,?)");

        ps.setInt(1, ob.getId());
        ps.setInt(2, ob.getId_user());
        ps.setString(3,  ob.getFam());
        ps.setString(4, ob.getName());
        ps.setString(5, ob.getTel());


        ps.execute();
    }

    @Override
    public void update(Info ob) throws SQLException {
        PreparedStatement ps = db.getCn().prepareStatement("UPDATE " + ob.getClass().getSimpleName() + " SET "
                + "id_user=?, fam=?, name=?, tel=? WHERE id=" + ob.getId());

        ps.setInt(1, ob.getId_user());
        ps.setString(2,  ob.getFam());
        ps.setString(3, ob.getName());
        ps.setString(4, ob.getTel());


        ps.execute();
    }

    @Override
    public void delete(Info ob) throws SQLException {
        PreparedStatement ps = db.getCn().prepareStatement("DELETE FROM " + ob.getClass().getSimpleName() + " WHERE id=" + ob.getId());

        ps.execute();

    }
}
