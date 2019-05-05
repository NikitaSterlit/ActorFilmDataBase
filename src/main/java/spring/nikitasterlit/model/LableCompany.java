package spring.nikitasterlit.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "lable_company")
public class LableCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String company;

    @NotNull
    private String colors;

    @NotNull
    private long ageCompany;

    public LableCompany() {
    }

    public LableCompany(String company, String colors,long ageCompany) {
        this.company = company;
        this.colors = colors;
        this.ageCompany = ageCompany;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public long getAgeCompany() {
        return ageCompany;
    }

    public void setAgeCompany(long ageCompany) {
        this.ageCompany = ageCompany;
    }
}
