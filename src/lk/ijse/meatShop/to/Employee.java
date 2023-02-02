package lk.ijse.meatShop.to;

import javafx.collections.ObservableList;

public class Employee {
    private String employeeId;
    private String username;
    private String password;
    private String nic;
    private String addres;
    private String name;
    private String jobroll;
    private String tel_no;

    public String getJobroll() {
        return jobroll;
    }



    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setJobroll(String jobroll) {
        this.jobroll = jobroll;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nic='" + nic + '\'' +
                ", addres='" + addres + '\'' +
                ", name='" + name + '\'' +
                ", jobroll='" + jobroll + '\'' +
                ", tel_no='" + tel_no + '\'' +
                '}';
    }

    public Employee(String employeeId, String username, String password, String nic, String addres, String name, String jobroll, String tel_no) {
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        this.nic = nic;
        this.addres = addres;
        this.name = name;
        this.jobroll = jobroll;
        this.tel_no = tel_no;
    }
}
