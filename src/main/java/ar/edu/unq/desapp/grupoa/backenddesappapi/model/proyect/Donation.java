package ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;

@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double amount;
    private String nickname;
    private String email;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Project project;
    private LocalDate date;
    private Double points;

    public Donation() {
    }

    public Donation(Long id, Double amount, String nickname, String email, Double points, Project project) {
        this.id = id;
        this.amount = amount;
        this.nickname = nickname;
        this.email = email;
        this.project = project;
        this.date = LocalDate.now();
        this.points = points;
    }

    public Donation(Double amount, String nickname, String email, Double points, Project project) {
        this.amount = amount;
        this.nickname = nickname;
        this.email = email;
        this.project = project;
        this.date = LocalDate.now();
        this.points = points;
    }

    public Long getId() {
        return this.id;
    }

    public Double getAmount() {
        return this.amount;
    }

    public String getNickname() {
        return this.nickname;
    }

    public Project getProject() {
        return this.project;
    }

    public void setAmount(Double newAmount) {
        this.amount = newAmount;
    }

    public void setNickname(String newNickname) {
        this.nickname = newNickname;
    }

    public void setProject(Project newProject) {
        this.project = newProject;
    }

    public void sendToProject(Project project) {
        project.receiveNewDonation(this);
    }

    public boolean amountIsGreaterThen(double amount) {
        return this.amount > amount;
    }

    public boolean populationOfProjectIsLessThen(Integer population) {
        return (this.project.getPopulationOfLocality()) < population;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate newDate){
        this.date = newDate;
    }

    public boolean isOfThisMonth(Month month) {
        return this.getDate().getMonth() == month;
    }

    public boolean isOfThisYear(int year) {
        return this.getDate().getYear() == year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }
}
