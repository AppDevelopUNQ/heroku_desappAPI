package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody;

public class ProjectFilter {
    private String word;
    private String date;

    public ProjectFilter(){}

    public ProjectFilter(String word, String date){
        this.word = word;
        this.date = date;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
