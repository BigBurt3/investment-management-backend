package com.wellsfargo.fs.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PORTFOLIO")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    private Long portfolioId;

    @Column(name = "creation_date")
    private String creationDate;

    // One Portfolio belongs to One Client
    @OneToOne(mappedBy = "portfolio")
    private Client client;

    // One Portfolio contains Many Securities
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    // Default constructor
    public Portfolio() {
    }

    // Constructor initializing instance variables
    public Portfolio(String creationDate, Client client, List<Security> securities) {
        this.creationDate = creationDate;
        this.client = client;
        this.securities = securities;
    }

    // Getters and Setters
    public Long getPortfolioId() {
        return portfolioId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
