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
        userDAO.save(new User("name", "nickname", "a@email.com","password", wallet));

    }
}
