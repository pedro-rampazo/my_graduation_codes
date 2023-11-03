package br.edu.ifsp.spo.juntossomosmais.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import java.util.Set;


@Entity
public class Customer {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column(length = 100)
    private String type;

    @Column(length = 1)
    private String gender;

    @Column
    private String email;

    @Column
    private String birthday;

    @Column
    private String registered;

    @Column(length = 2)
    private String nacionality;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name_id", unique = true)
    private Name name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "picture_id", unique = true)
    private Picture picture;

    @OneToMany(mappedBy = "customer")
    private Set<TelephoneNumber> telephoneNumber;

    @OneToMany(mappedBy = "customer")
    private Set<MobileNumber> mobileNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", unique = true)
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metadata_id")
    private Metadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(final String birthday) {
        this.birthday = birthday;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(final String registered) {
        this.registered = registered;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(final String nacionality) {
        this.nacionality = nacionality;
    }

    public Name getName() {
        return name;
    }

    public void setName(final Name name) {
        this.name = name;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(final Picture picture) {
        this.picture = picture;
    }

    public Set<TelephoneNumber> getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(final Set<TelephoneNumber> telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Set<MobileNumber> getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(final Set<MobileNumber> mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(final Location location) {
        this.location = location;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(final Metadata metadata) {
        this.metadata = metadata;
    }

}
