package ar.com.jss.domain;

import java.util.Date;
import java.util.List;

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
