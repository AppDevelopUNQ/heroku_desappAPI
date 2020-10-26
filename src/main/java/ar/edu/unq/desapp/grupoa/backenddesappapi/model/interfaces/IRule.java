package ar.edu.unq.desapp.grupoa.backenddesappapi.model.interfaces;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;

public interface IRule {

    boolean isApplicable(Donation aDonation, User user);

    Double pointsForDonation(Donation aDonation, User user);
}
