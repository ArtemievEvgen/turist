package entity;

public class Users {
    private int id_user;
    private String login;
    private String pass;
    private int rol;
    private String status;

    public Users(int id_user, String login, String pass, int rol, String status) {
        this.id_user = id_user;
        this.login = login;
        this.pass = pass;
        this.rol = rol;
        this.status = status;
    }

    public Users(String login, String pass, int rol, String status) {
        this.login = login;
        this.pass = pass;
        this.rol = rol;
        this.status = status;
    }

    public Users(int id_user) {
        this.id_user = id_user;
    }

    public Users(String login, String pass, String status) {
        this.login = login;
        this.pass = pass;
        this.status = status;
    }

    public Users(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public Users() {

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_user;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((pass == null) ? 0 : pass.hashCode());
        result = prime * result + rol;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Users other = (Users) obj;
        if (id_user != other.id_user)
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (pass == null) {
            if (other.pass != null)
                return false;
        } else if (!pass.equals(other.pass))
            return false;
        if (rol != other.rol)
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Users [id_user=" + id_user + ", login=" + login + ", pass=" + pass + ", rol=" + rol + ", status="
                + status + "]";
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
