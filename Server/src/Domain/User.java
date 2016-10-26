package Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by joseja on 10/19/16.
 */
public class User {

    private String username;
    private String password;
    private ArrayList<Ticket> tickets;

    public User() {
        this.username = "jose";
        this.password = "jose";
        this.tickets = new ArrayList<>(Arrays.asList(new Ticket(), new Ticket(), new Ticket()));
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public String toString() {
        return "Username: " + username + ", Password: " + password;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!User.class.isAssignableFrom(other.getClass())) {
            return false;
        }
        final User user = (User) other;
        if (!this.username.equals(user.getUsername()) || !this.password.equals(user.getPassword())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

}
