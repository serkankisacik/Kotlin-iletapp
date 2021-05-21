package app.ilet.Model;

public class Chatlist {
    public String id;
    public String date;



    public Chatlist(String id,String date) {
        this.id = id;
        this.date=date;

    }

    public Chatlist() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }

}
