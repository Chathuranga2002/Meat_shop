package lk.ijse.meatShop.model;

import lk.ijse.meatShop.to.Employee;
import lk.ijse.meatShop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeModel {
    public static ResultSet getLastId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT emp_id FROM employee ORDER BY emp_id  DESC LIMIT 1");
    }

    public static boolean save(Employee employee) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql,employee.getEmployeeId(),employee.getUsername(),employee.getPassword(),
                employee.getNic(),employee.getName(),employee.getAddres()
                ,employee.getJobroll(),employee.getTel_no());
    }

    public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT emp_id,user_name,nic,name,address,rool,tel_no FROM employee");
    }

    public static Employee search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  * FROM employee WHERE emp_id = ?||nic = ?";
        ResultSet result = CrudUtil.execute(sql, id,id);

        if (result.next()) {
            return new Employee(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(6),
                    result.getString(5),
                    result.getString(7),
                    result.getString(8)
            );
        }
        return null;
    }


    public static boolean Update(Employee employee) throws ClassNotFoundException, SQLException {

        String sql ="Update employee set user_name=?, password=?, nic=?, name=?, address=? ,rool=? ,tel_no=? where emp_id=?";
        return CrudUtil.execute(sql,employee.getUsername(),employee.getPassword(),employee.getNic(),employee.getName(),
                employee.getAddres(),employee.getJobroll(),employee.getTel_no(),employee.getEmployeeId());
    }

}
