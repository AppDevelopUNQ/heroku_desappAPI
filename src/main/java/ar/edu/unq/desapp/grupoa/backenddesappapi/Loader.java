package ar.edu.unq.desapp.grupoa.backenddesappapi;

import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.locality.LocalityDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.project.ProjectDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.punctuationsystem.PunctuationSystemDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.user.UserDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.wallet.WalletDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.interfaces.IRule;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.Product;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.PunctuationSystem;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.Wallet;

import java.util.List;


public class Loader {

    private DATA data = new DATA();

    public void addLocalitiesEntities(LocalityDAO localityDAO) {
        localityDAO.save(data.locality());
        localityDAO.save(data.locality1());
        localityDAO.save(data.locality2());
        localityDAO.save(data.locality3());
    }

    public void addProjectEntities(ProjectDAO projectDAO) {
        data.project().receiveNewDonation(data.donation());
        projectDAO.save(data.project());
        projectDAO.save(data.projectB());
        projectDAO.save(data.projectC());
        projectDAO.save(data.projectD());
        projectDAO.save(data.projectE());
        projectDAO.save(data.projectF());
        projectDAO.save(data.projectG());
        projectDAO.save(data.projectH());
        projectDAO.save(data.projectI());
        projectDAO.save(data.projectJ());
        projectDAO.save(data.projectK());
        projectDAO.save(data.projectL());
        projectDAO.save(data.projectM());
        projectDAO.save(data.projectN());
        projectDAO.save(data.projectO());
        projectDAO.save(data.projectP());
        projectDAO.save(data.projectQ());
        projectDAO.save(data.projectR());
        projectDAO.save(data.projectS());
        projectDAO.save(data.projectT());
        projectDAO.save(data.projectU());
        projectDAO.save(data.projectV());
        projectDAO.save(data.projectW());
        projectDAO.save(data.projectX());
        projectDAO.save(data.projectY());
    }

    public void add(PunctuationSystemDAO systemDAO, WalletDAO walletDAO, UserDAO userDAO) {
        PunctuationSystem sys = data.system();

        List<IRule> ls = data.lsRules();
        ls.add(data.forCash());
        ls.add(data.forLocality());
        ls.add(data.forTimes());

        sys.setRules(ls);

        List<Product> lps = data.lsProduct();
        lps.add(data.product());

        sys.setProductList(lps);

        PunctuationSystem system = systemDAO.save(sys);

        Wallet wallet = walletDAO.save(new Wallet(0.0, system));
        Wallet otherWallet = walletDAO.save(new Wallet(100.0, system));
        Wallet walletIS = walletDAO.save(new Wallet(15364.0, system));
        userDAO.save(new User("name", "slave", "a@email.com","password", wallet));

        User admin = new User("admin", "master", "axel.lopez.garabal@gmail.com","1234", otherWallet);
        User otherUser = new User("App Develop", "AppDevelop", "appdevelop.unq@gmail.com","AppDevelop2020", walletIS);
        admin.becameAdmin();
        userDAO.save(admin);
        userDAO.save(otherUser);
    }
}
