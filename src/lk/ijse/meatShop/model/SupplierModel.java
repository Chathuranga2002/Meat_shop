package lk.ijse.meatShop.model;

import lk.ijse.meatShop.to.Employee;
import lk.ijse.meatShop.to.Supplier;
import lk.ijse.meatShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierModel {
    public static ResultSet getLastId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT sup_id FROM supplier ORDER BY sup_id  DESC LIMIT 1");
    }

    public static boolean save(Supplier supplier) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO supplier VALUES (?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql,supplier.getSup_id(),supplier.getName(),supplier.getAddress(),
                supplier.getNic(),supplier.getTel_no());
    }

    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM supplier");
    }

    public static Supplier search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  * FROM supplier WHERE sup_id = ?||nic = ?";
        ResultSet result = CrudUtil.execute(sql, id,id);

        if (result.next()) {
            return new Supplier(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)

            );
        }
        return null;
    }


    public static boolean Update(Supplier supplier) throws ClassNotFoundException, SQLException {

        String sql ="Update supplier set name=?, address=?, nic=? ,tel_no=? where sup_id=?";
        return CrudUtil.execute(sql,supplier.getName(),supplier.getAddress(),supplier.getNic(),supplier.getTel_no(),
                supplier.getSup_id());
    }

}
