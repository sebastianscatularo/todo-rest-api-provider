package ar.com.jss.tasks.model.domain;

import java.util.Date;
import java.util.List;
import javax.script.*;

/**
 * @author Sebastian Scatularo
 */
public final class User {
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private Date lastLogin;
    private List<Project> projects;

}
