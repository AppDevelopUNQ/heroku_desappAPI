package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.scheduled;

import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Lazy(false)
@Component
@Controller
public class ScheduledMail {
    @Autowired
    private ProjectService projectService;

    //@Scheduled(cron = "0 20 * * * *")
    public void sendEmailsOfTheDay() throws IOException, InvalidException {
        projectService.topProjects();
        projectService.tenLocallities();
    }
}
