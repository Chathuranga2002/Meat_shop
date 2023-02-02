package lk.ijse.meatShop.model;

import lk.ijse.meatShop.to.CartDetail;
import lk.ijse.meatShop.to.Stocks;
import lk.ijse.meatShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddToShowcaseModel {
    public static ResultSet getStokscode() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT code FROM stocks ");
    }


    public static Stocks getStoksDesc(String code) throws SQLException, ClassNotFoundException {
        String sql =("SELECT * FROM stocks where code=? ");
        ResultSet result = CrudUtil.execute(sql,code);

        if (result.next()) {
            return new Stocks(

                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4)
            );
        }
        return null;

    }

    public static boolean UpdateStoks(int qty, String code) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE stocks SET qty_onHand = qty_onHand - ? WHERE code = ?";
        return CrudUtil.execute(sql,qty,code);

    }
    public static boolean UpdateShowcasse(int qty,String code,double uniteprice) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE item SET qty_onHand = qty_onHand + ?,unit_Price =?  WHERE item_code = ?";
        return CrudUtil.execute(sql,qty,uniteprice,code);

    }


}
