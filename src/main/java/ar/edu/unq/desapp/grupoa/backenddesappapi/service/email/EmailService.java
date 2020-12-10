package ar.edu.unq.desapp.grupoa.backenddesappapi.service.email;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void notifyNews(List<User> users, Project project) {
        for (User user : users) {
            sendNews(user, project);
        }
    }

    private void sendNews(User user, Project project) {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mailMessage, true);
            helper.setTo(user.getEmail());
            helper.setSubject("Notify News about Project "+ project.getName());
            helper.setText(
                    "<html>"
                            + "<body>"
                            + "<div>"
                            + "<div> Dear " + user.getNickname() + "</div>"
                            + "<div>We inform you that project <strong> "+project.getName()+ "</strong> has been closed.</div>"
                            + "</div>"
                            + "<div><strong>PS: we encourage you to participate in another project</strong></div>"
                            + "<div>Thanks to your donation.</div>"
                            + "</body>"
                            + "</html>", true);

            javaMailSender.send(mailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void sendTop10Projects(List<User> donors, List<Project> projects) {
        String projectNames = this.joinProjectNames(projects);

        for (User donor : donors) {
            senTop10Project(donor, projectNames);
        }
    }

    private String joinProjectNames(List<Project> projects) {
        String names = "";
        for (Project project : projects) {
            names += project.getName() +", ";
        }
        return names.substring(0,names.length()-2);
    }

    public void senTop10Project(User user, String projectNames) {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mailMessage, true);
            helper.setFrom("axel.lopez.garabal@gmail.com");
            helper.setTo(user.getEmail());
            helper.setSubject("Tops 10 Project");
            helper.setText(
                    "<html>"
                            + "<body>"
                            + "<div>"
                            + "<div>This mail is to  you of the 10 most the donated projects: </div>"
                            + "<div><strong>"+projectNames+ "</strong></div>"
                            + "<div><strong> this is only a suggestion to encourage you to participate in another project</strong></div>"
                            + "</div>"
                            + "</body>"
                            + "</html>", true);

            javaMailSender.send(mailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void sendTop10Locations(List<User> donors, List<Locality> locations) {
        String locationsNames = this.findLocationNames(locations);

        for (User donor : donors) {
            senTop10Locations(donor, locationsNames);
        }
    }

    private void senTop10Locations(User user, String locationsNames) {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mailMessage, true);
            helper.setTo(user.getEmail());
            helper.setSubject("Tops 10 Localities");
            helper.setText(
                    "<html>"
                            + "<body>"
                            + "<div>"
                            + "<div>this is the top 10 of less donated localities: </div>"
                            + "<div><strong>"+locationsNames+ "</strong></div>"
                            + "<div><strong> this is only a suggestion to encourage you to participate in another project</strong></div>"
                            + "</div>"
                            + "</body>"
                            + "</html>", true);

            javaMailSender.send(mailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String findLocationNames(List<Locality> locations) {
        String names = "";
        for (Locality location: locations) {
            names += location.getName() +", ";
        }
        return names.substring(0,names.length()-2);
    }
}
