package main.java.model;

public class Msg {


    private String tittle;
    private String content;

    public Msg() {
        super();
    }

    public Msg (String tittle, String content) {
        this.tittle = tittle;
        this.content = content;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
