package ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.rule;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.interfaces.IRule;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;

public class TimesInTheMonth implements IRule {
    @Override
    public boolean isApplicable(Donation aDonation, User user) {
        return user.getDonationsOfTheMonth().size() == 2;
    }

    @Override
    public Double pointsForDonation(Donation aDonation, User user) {
        return 500.0;
    }
}
