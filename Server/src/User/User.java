package User;

import Ticket.Ticket;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Created by joseja on 10/19/16.
 */
@Entity
public class User {

    private int id;

    private List<Ticket> tickets;

    private String username;
    private String password;
    private String token;

    public User() {
    }

    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public User(String username, String password, String token) {
        this.setUsername(username);
        this.setPassword(password);
        this.setToken(token);
    }

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    @OneToMany(cascade=CascadeType.ALL)
    @Column(name="tickets")
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
