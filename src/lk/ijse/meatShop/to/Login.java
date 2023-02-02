package lk.ijse.meatShop.to;

public class Login {
    private String Nic;
    private String Username;
    private String Password;
    private String rool;

    public String getNic() {
        return Nic;
    }

    public void setNic(String nic) {
        Nic = nic;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRool() {
        return rool;
    }

    public void setRool(String rool) {
        this.rool = rool;
    }

    public Login() {
    }

    public Login(String nic, String username, String password, String rool) {
        Nic = nic;
        Username = username;
        Password = password;
        this.rool = rool;
    }
}
