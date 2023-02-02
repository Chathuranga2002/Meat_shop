package lk.ijse.meatShop.model;

import lk.ijse.meatShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewOrderModel {
    public static ResultSet getAll(String code) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT  * from order_detail where ord_id=? ",code);
    }
}
