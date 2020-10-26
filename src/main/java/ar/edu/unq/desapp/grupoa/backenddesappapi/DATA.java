package ar.edu.unq.desapp.grupoa.backenddesappapi;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.interfaces.IRule;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.Product;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.PunctuationSystem;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rule.InvertedCash;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rule.InvertedLocality;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rule.TimesInTheMonth;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DATA{

    private Locality locality = new Locality("L1", "province", 250, 15.0);
    private Locality locality1 = new Locality("L2", "province", 250, 25.0);
    private Locality locality2 = new Locality("L3", "province", 2500, 35.0);
    private Locality locality3 = new Locality("L4", "province", 25000, 45.0);

    private Project project = new Project("P1", 9000.0, "FP1", LocalDate.now(), LocalDate.now(), this.locality);
    private Project projectB = new Project("P2", 8000.0, "FP2", LocalDate.now(), LocalDate.now(), 2000.0, this.locality1);
    private Project projectC = new Project("P3", 10000.0, "FP3", LocalDate.now(), LocalDate.now(), this.locality);
    private Project projectD = new Project("P4", 11000.0, "FP4", LocalDate.now(), LocalDate.now(), 5000.0, this.locality3);
    private Project projectE = new Project("P5", 12000.0, "FP5", LocalDate.now(), LocalDate.now(), this.locality2);

    private Donation donation = new Donation(200.0, "nickname", this.project());
    private Donation d1 = new Donation(20.0, "init", this.projectE);
    private Donation d2 = new Donation(20.0, "init", this.projectE);
    private Donation d3 = new Donation(20.0, "init", this.projectE);
    private Donation d4 = new Donation(20.0, "init", this.projectE);

    private InvertedLocality forLocality = new InvertedLocality();
    private InvertedCash forCash = new InvertedCash();
    private TimesInTheMonth forTimes = new TimesInTheMonth();
    private List<IRule> lsRules = new ArrayList<>();
    private Product product = new Product("name", 0.0, "/img", 0);
    private List<Product> lsProduct = new ArrayList<>();
    private PunctuationSystem system = new PunctuationSystem();

    public Locality locality(){
        return this.locality;
    }
    public Locality locality1(){
        return this.locality1;
    }
    public Locality locality2(){
        return this.locality2;
    }
    public Locality locality3() {
        return this.locality3;
    }
    public Donation donation(){return this.donation;}
    public InvertedCash forCash(){return this.forCash;}
    public InvertedLocality forLocality(){return this.forLocality;}
    public TimesInTheMonth forTimes(){return this.forTimes;}

    public List<IRule> lsRules(){return this.lsRules;}

    public Product product(){return this.product;}

    public List<Product> lsProduct(){return this.lsProduct;}

    public PunctuationSystem system(){return this.system;}

    public Project project(){
        return this.project;
    }
    public Project projectB(){
        return this.projectB;
    }
    public Project projectC(){
        return this.projectC;
    }
    public Project projectD(){
        return this.projectD;
    }
    public Project projectE(){
        this.projectE.receiveNewDonation(this.d1);
        this.projectE.receiveNewDonation(this.d2);
        this.projectE.receiveNewDonation(this.d3);
        this.projectE.receiveNewDonation(this.d4);
        return this.projectE;
    }
}