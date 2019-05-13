package entity;

public class Rooms {
    private int id_room;
    private String type;
    private int kol_mest;
    private double price;
    private String status;

    public Rooms(int id_room, String type, int kol_mest, double price, String status) {
        this.id_room = id_room;
        this.type = type;
        this.kol_mest = kol_mest;
        this.price = price;
        this.status = status;
    }

    public Rooms() {

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_room;
        result = prime * result + kol_mest;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Rooms other = (Rooms) obj;
        if (id_room != other.id_room)
            return false;
        if (kol_mest != other.kol_mest)
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
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
        return "Rooms [id_room=" + id_room + ", type=" + type + ", kol_mest=" + kol_mest + ", price=" + price
                + ", status=" + status + "]";
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
