package lk.ijse.meatShop.model;

import lk.ijse.meatShop.to.Customer;
import lk.ijse.meatShop.to.Employee;
import lk.ijse.meatShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerModel {
    public static ResultSet getLastId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT cus_id FROM customer ORDER BY cus_id  DESC LIMIT 1");
    }
    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM customer");
    }

    public static boolean save(Customer customer) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO customer VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql,customer.getCus_id(),customer.getName(),customer.getAddress(),
                customer.getTel_no());
    }



    public static Customer search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  * FROM customer WHERE cus_id = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)

            );
        }
        return null;
    }


    public static boolean Update(Customer customer) throws ClassNotFoundException, SQLException {

        String sql ="Update customer set  name=?, address=?, tel_no=? where cus_id=?";
        return CrudUtil.execute(sql,customer.getName(),customer.getAddress(),customer.getTel_no(),customer.getCus_id()
             );
    }


}
