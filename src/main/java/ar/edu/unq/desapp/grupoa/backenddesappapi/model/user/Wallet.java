package ar.edu.unq.desapp.grupoa.backenddesappapi.model.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.PunctuationSystem;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long walletId;
    private Double points = 0.0;
    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    private PunctuationSystem system;

    public Wallet(){}

    public Wallet(Double points, PunctuationSystem system){
        this.points = points;
        this.system = system;
    }

    public Double getPoints() {
        return this.points;
    }

    public void addPoints(Double pointsToAdd) {
        this.points = this.points + pointsToAdd;
    }

    public void spendPoints(Double amountOfPoints) {
        this.points = this.points - amountOfPoints;
    }

    public void setPoints(Double newAmountOfPoints) {
        this.points = newAmountOfPoints;
    }

    public void setPunctuationSystem(PunctuationSystem punctuationSystem) {
        this.system = punctuationSystem;
    }

    public PunctuationSystem getPunctuationSystem() {
        return this.system;
    }

    public void gainPointsForDonation(Donation aDonation, User user) {
        Double gainedPoints = this.system.pointsGainForDonation(aDonation, user);
        this.addPoints(gainedPoints);
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public void gainPointsForNewDonation(Donation newDonation, User user) {
        Double gainedPoints = this.system.pointsGainForDonationWithRules(newDonation, user);
        this.addPoints(gainedPoints);
    }
}
