package User;

import Ticket.Ticket;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by joseja on 10/19/16.
 */
@Entity
public class UserImp implements User {

    private int id;

    private List<Ticket> tickets;

    private String username;
    private String password;

    public UserImp() {
        this.setUsername("jose");
        this.setPassword("jose");
        this.setTickets(new ArrayList<>(Arrays.asList(new Ticket(), new Ticket(), new Ticket())));
    }

    public UserImp(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
        this.setTickets(new ArrayList<Ticket>());
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

    @OneToMany
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
        if (!UserImp.class.isAssignableFrom(other.getClass())) {
            return false;
        }
        final UserImp userImp = (UserImp) other;
        if (!this.username.equals(userImp.getUsername()) || !this.password.equals(userImp.getPassword())) {
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
}
