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

    private Project project = new Project("P1", 90.0, "FP1", LocalDate.now(),  LocalDate.parse("2022-11-27"), this.locality);
    private Project projectB = new Project("P2", 80.0, "FP2", LocalDate.now(), LocalDate.parse("2023-11-27"), 200.0, this.locality1);
    private Project projectC = new Project("P3", 60.0, "FP3", LocalDate.now(), LocalDate.parse("2021-11-27"), this.locality);
    private Project projectD = new Project("P4", 67.0, "FP4", LocalDate.now(), LocalDate.parse("2022-11-27"), 50.0, this.locality3);
    private Project projectE = new Project("P5", 78.0, "FP5", LocalDate.now(), LocalDate.parse("2021-11-27"), this.locality2);

    private Project projectF = new Project("P6", 50.0, "FP1", LocalDate.now(), LocalDate.parse("2023-11-27"), this.locality);
    private Project projectG = new Project("P7", 60.0, "FP2", LocalDate.now(), LocalDate.parse("2022-11-27"), 10.0, this.locality1);
    private Project projectH = new Project("P8", 70.0, "FP3", LocalDate.now(), LocalDate.parse("2021-11-27"), this.locality);
    private Project projectI = new Project("P9", 80.0, "FP4", LocalDate.now(), LocalDate.parse("2020-11-27"), 5.0, this.locality3);
    private Project projectJ = new Project("PA", 58.0, "FP5", LocalDate.now(), LocalDate.parse("2021-11-27"), this.locality2);

    private Project projectK = new Project("PB", 76.0, "FP1", LocalDate.now(), LocalDate.parse("2021-11-27"), this.locality);
    private Project projectL = new Project("PC", 86.0, "FP2", LocalDate.now(), LocalDate.parse("2022-11-27"), 2.0, this.locality1);
    private Project projectM = new Project("PD", 85.0, "FP3", LocalDate.now(), LocalDate.parse("2022-11-27"), this.locality);
    private Project projectN = new Project("PE", 52.0, "FP4", LocalDate.now(), LocalDate.parse("2022-11-27"), 1.0, this.locality3);
    private Project projectO = new Project("PF", 64.0, "FP5", LocalDate.now(), LocalDate.parse("2021-11-27"), this.locality2);

    private Project projectP = new Project("P10", 65.0, "FP1", LocalDate.now(), LocalDate.parse("2024-11-27"), this.locality);
    private Project projectQ = new Project("P11", 78.0, "FP2", LocalDate.now(), LocalDate.parse("2024-11-27"), 4.0, this.locality1);
    private Project projectR = new Project("P12", 36.0, "FP3", LocalDate.now(), LocalDate.parse("2026-11-27"), this.locality);
    private Project projectS = new Project("P13", 18.0, "FP4", LocalDate.now(), LocalDate.parse("2025-11-27"), 6.0, this.locality3);
    private Project projectT = new Project("PK", 12.0, "FP5", LocalDate.now(),  LocalDate.parse("2027-11-27"), this.locality2);

    private Project projectU = new Project("P14", 90.0, "FP1", LocalDate.now(), LocalDate.parse("2028-11-27"), this.locality);
    private Project projectV = new Project("P15", 83.0, "FP2", LocalDate.now(), LocalDate.parse("2029-11-27"), 8.0, this.locality1);
    private Project projectW = new Project("P16", 63.0, "FP3", LocalDate.now(), LocalDate.parse("2028-11-27"), this.locality);
    private Project projectX = new Project("P17", 61.0, "FP4", LocalDate.now(), LocalDate.parse("2029-11-27"), 9.0, this.locality3);
    private Project projectY = new Project("P18", 82.0, "FP5", LocalDate.now(), LocalDate.parse("2030-11-27"), this.locality2);

    private Donation donation = new Donation(200.0, "aeonclock","axel.lopez.garabal@gmail.com" , 200.0,this.project());
    private Donation d1 = new Donation(20.0, "init", "b@gmail.com",20.0, this.projectE);
    private Donation d2 = new Donation(20.0, "init", "c@gmail.com", 20.0,this.projectE);
    private Donation d3 = new Donation(20.0, "init","d@gmail.com", 20.0,this.projectE);
    private Donation d4 = new Donation(20.0, "init","e@gmail.com", 20.0,this.projectE);

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
    public Project projectF(){return this.projectF;}
    public Project projectG(){return this.projectG;}
    public Project projectH(){return this.projectH;}
    public Project projectI(){return this.projectI;}
    public Project projectJ(){return this.projectJ;}
    public Project projectK(){return this.projectK;}
    public Project projectL(){return this.projectL;}
    public Project projectM(){return this.projectM;}
    public Project projectN(){return this.projectN;}
    public Project projectO(){return this.projectO;}
    public Project projectP(){return this.projectP;}
    public Project projectQ(){return this.projectQ;}
    public Project projectR(){return this.projectR;}
    public Project projectS(){return this.projectS;}
    public Project projectT(){return this.projectT;}
    public Project projectU(){return this.projectU;}
    public Project projectV(){return this.projectV;}
    public Project projectW(){return this.projectW;}
    public Project projectX(){return this.projectX;}
    public Project projectY(){return this.projectY;}
}