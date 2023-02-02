package lk.ijse.meatShop.model;

import lk.ijse.meatShop.to.Payment;
import lk.ijse.meatShop.to.Stocks;
import lk.ijse.meatShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentModle {
    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("select * from buyer_payment where balance !=0");
    }
    public static ResultSet getcode() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("select buy_id from buyer_payment where balance !=0");
    }
    public static Payment getDesc(String code) throws SQLException, ClassNotFoundException {
        String sql =("SELECT * FROM buyer_payment where buy_id=? ");
        ResultSet result = CrudUtil.execute(sql,code);

        if (result.next()) {
            return new Payment(

                    result.getString(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getDouble(4),
                    result.getDouble(5)
            );
        }
        return null;

    }
    public static boolean UpdateStoks(double amount, String code) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE buyer_payment SET payed = payed + ?,balance=balance-? WHERE buy_id = ?";
        return CrudUtil.execute(sql,amount,amount,code);

    }

}
