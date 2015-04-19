package ar.com.jss.domain;

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

    public static void main(String... args) throws ScriptException {
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from String
        engine.eval("()(" +
                "function() {" +
                        "print('Hello, World');" +
                    "}" +
                ");");
    }
}
