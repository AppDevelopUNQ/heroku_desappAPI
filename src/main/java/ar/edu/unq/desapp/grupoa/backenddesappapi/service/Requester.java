package ar.edu.unq.desapp.grupoa.backenddesappapi.service;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Requester {
    public Requester(){}

    @Async
    public void sendNews(List<User> users, Project project) throws IOException {
        System.out.println();
        System.out.println(users.size());
        System.out.println();
        for (User user : users) {
            this.requestToNotify(("Notify News about Project "+ project.getName()), this.message(user, project), user.getEmail());
        }
    }

    private String message(User user, Project project){
        return  "Dear " + user.getNickname()
                + "We inform you that project "+project.getName()+ " has been closed."
                + "Thanks to your donation";
    }

    public void requestToNotify(String subject, String message, String receptor) throws IOException {
        URL url = new URL("https://devappnotification.herokuapp.com/api/notify");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);

        Map<String,String> arguments = new HashMap<>();
        arguments.put("subject", subject);
        arguments.put("message", message); // This is a fake password obviously
        arguments.put("receptor", receptor);
        StringJoiner sj = new StringJoiner("&");
        for(Map.Entry<String,String> entry : arguments.entrySet())
            sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "="
                    + URLEncoder.encode(entry.getValue(), "UTF-8"));
        byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }
    }
}
