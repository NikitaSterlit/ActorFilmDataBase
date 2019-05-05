package spring.nikitasterlit.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "nickname")
    private String nickname;

    @NotNull
    @Column(name = "telephone_number")
    private String telephoneNumber;

    @NotNull
    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name = "lable_company")
    private LableCompany lableCompany;

    public Manager() {
    }

    public Manager(String nickname, String telephoneNumber, String status) {
        this.nickname = nickname;
        this.telephoneNumber = telephoneNumber;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LableCompany getLableCompany() {
        return lableCompany;
    }

    public void setLableCompany(LableCompany lableCompany) {
        this.lableCompany = lableCompany;
    }
}
