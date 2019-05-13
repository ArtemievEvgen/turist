package entity;

public class Info {
    private int id;
    private int id_user;
    private String fam;
    private String name;
    private String tel;

    public Info(int id, int id_user, String fam, String name, String tel) {
        this.id = id;
        this.id_user = id_user;
        this.fam = fam;
        this.name = name;
        this.tel = tel;
    }

    public Info() {

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fam == null) ? 0 : fam.hashCode());
        result = prime * result + id;
        result = prime * result + id_user;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
        Info other = (Info) obj;
        if (fam == null) {
            if (other.fam != null)
                return false;
        } else if (!fam.equals(other.fam))
            return false;
        if (id != other.id)
            return false;
        if (id_user != other.id_user)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (tel == null) {
            if (other.tel != null)
                return false;
        } else if (!tel.equals(other.tel))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Info [id=" + id + ", id_user=" + id_user + ", fam=" + fam + ", name=" + name + ", tel=" + tel + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
