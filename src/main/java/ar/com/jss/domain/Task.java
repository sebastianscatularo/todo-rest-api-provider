package ar.com.jss.domain;

import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Sebastian Scatularo
 */
public final class Task {
    private String value;
    private DateTime expire;
    private List<Label> labels;
    private List<Note> notes;
}
