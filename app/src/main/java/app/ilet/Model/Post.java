package app.ilet.Model;

public class Post {
    String baslik;
    String mesaj;
    String user;
    String userid;
    String price;

    public Post(String baslik, String mesaj, String user, String userid, String price) {
        this.baslik = baslik;
        this.mesaj = mesaj;
        this.user = user;
        this.userid=userid;
        this.price=price;
    }

    public Post() {
    }

    public String getBaslik() {
        return baslik;
    }
    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getMesaj() {
        return mesaj;
    }
    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }


}
