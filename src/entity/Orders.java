package entity;

public class Orders {
    private int id_order;
    private int id_user;
    private String fam;
    private String name;
    private int id_room;
    private String type;
    private int kol_mest;
    private String date_ot;
    private String date_do;
    private double coast;
    private String status;
    private String pay;
    private String del_status;

    public Orders(int id_order, int id_user, String fam, String name, int id_room, String type, int kol_mest,
                  String date_ot, String date_do, double coast, String status, String pay, String del_status) {
        this.id_order = id_order;
        this.id_user = id_user;
        this.fam = fam;
        this.name = name;
        this.id_room = id_room;
        this.type = type;
        this.kol_mest = kol_mest;
        this.date_ot = date_ot;
        this.date_do = date_do;
        this.coast = coast;
        this.status = status;
        this.pay = pay;
        this.del_status = del_status;
    }

    public Orders(int id_order) {
        this.id_order = id_order;
    }

    public Orders() {

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(coast);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((date_do == null) ? 0 : date_do.hashCode());
        result = prime * result + ((date_ot == null) ? 0 : date_ot.hashCode());
        result = prime * result + ((del_status == null) ? 0 : del_status.hashCode());
        result = prime * result + ((fam == null) ? 0 : fam.hashCode());
        result = prime * result + id_order;
        result = prime * result + id_room;
        result = prime * result + id_user;
        result = prime * result + kol_mest;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((pay == null) ? 0 : pay.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        Orders other = (Orders) obj;
        if (Double.doubleToLongBits(coast) != Double.doubleToLongBits(other.coast))
            return false;
        if (date_do == null) {
            if (other.date_do != null)
                return false;
        } else if (!date_do.equals(other.date_do))
            return false;
        if (date_ot == null) {
            if (other.date_ot != null)
                return false;
        } else if (!date_ot.equals(other.date_ot))
            return false;
        if (del_status == null) {
            if (other.del_status != null)
                return false;
        } else if (!del_status.equals(other.del_status))
            return false;
        if (fam == null) {
            if (other.fam != null)
                return false;
        } else if (!fam.equals(other.fam))
            return false;
        if (id_order != other.id_order)
            return false;
        if (id_room != other.id_room)
            return false;
        if (id_user != other.id_user)
            return false;
        if (kol_mest != other.kol_mest)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (pay == null) {
            if (other.pay != null)
                return false;
        } else if (!pay.equals(other.pay))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Orders [id_order=" + id_order + ", id_user=" + id_user + ", fam=" + fam + ", name=" + name
                + ", id_room=" + id_room + ", type=" + type + ", kol_mest=" + kol_mest + ", date_ot=" + date_ot
                + ", date_do=" + date_do + ", coast=" + coast + ", status=" + status + ", pay=" + pay + ", del_status="
                + del_status + "]";
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
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

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getKol_mest() {
        return kol_mest;
    }

    public void setKol_mest(int kol_mest) {
        this.kol_mest = kol_mest;
    }

    public String getDate_ot() {
        return date_ot;
    }

    public void setDate_ot(String date_ot) {
        this.date_ot = date_ot;
    }

    public String getDate_do() {
        return date_do;
    }

    public void setDate_do(String date_do) {
        this.date_do = date_do;
    }

    public double getCoast() {
        return coast;
    }

    public void setCoast(double coast) {
        this.coast = coast;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getDel_status() {
        return del_status;
    }

    public void setDel_status(String del_status) {
        this.del_status = del_status;
    }
}
