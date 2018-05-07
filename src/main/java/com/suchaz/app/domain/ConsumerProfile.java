package com.suchaz.app.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

import com.suchaz.app.domain.enumeration.Gender;

import com.suchaz.app.domain.enumeration.AgeGroup;

/**
 * A ConsumerProfile.
 */
@Entity
@Table(name = "consumer_profile")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ConsumerProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "age", nullable = false)
    private AgeGroup age;

    @Column(name = "input_traits")
    private String inputTraits;

    @Column(name = "trait_structure")
    private String traitStructure;

    @Column(name = "activity_structure")
    private String activityStructure;

    @Column(name = "hobby_structure")
    private String hobbyStructure;

    @Column(name = "input_reletionship")
    private String inputReletionship;

    @Column(name = "input_hobbies")
    private String inputHobbies;

    @Column(name = "reccomended_product_types")
    private String reccomendedProductTypes;

    @NotNull
    @Column(name = "created_date", nullable = false)
    private Long createdDate;

    @Column(name = "last_updated_date")
    private Long lastUpdatedDate;

    @NotNull
    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    @NotNull
    @Column(name = "is_logged_in_user", nullable = false)
    private Boolean isLoggedInUser;

    @ManyToOne
    private SuchAzUser suchAzUser;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ConsumerProfile name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public ConsumerProfile gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public AgeGroup getAge() {
        return age;
    }

    public ConsumerProfile age(AgeGroup age) {
        this.age = age;
        return this;
    }

    public void setAge(AgeGroup age) {
        this.age = age;
    }

    public String getInputTraits() {
        return inputTraits;
    }

    public ConsumerProfile inputTraits(String inputTraits) {
        this.inputTraits = inputTraits;
        return this;
    }

    public void setInputTraits(String inputTraits) {
        this.inputTraits = inputTraits;
    }

    public String getTraitStructure() {
        return traitStructure;
    }

    public ConsumerProfile traitStructure(String traitStructure) {
        this.traitStructure = traitStructure;
        return this;
    }

    public void setTraitStructure(String traitStructure) {
        this.traitStructure = traitStructure;
    }

    public String getActivityStructure() {
        return activityStructure;
    }

    public ConsumerProfile activityStructure(String activityStructure) {
        this.activityStructure = activityStructure;
        return this;
    }

    public void setActivityStructure(String activityStructure) {
        this.activityStructure = activityStructure;
    }

    public String getHobbyStructure() {
        return hobbyStructure;
    }

    public ConsumerProfile hobbyStructure(String hobbyStructure) {
        this.hobbyStructure = hobbyStructure;
        return this;
    }

    public void setHobbyStructure(String hobbyStructure) {
        this.hobbyStructure = hobbyStructure;
    }

    public String getInputReletionship() {
        return inputReletionship;
    }

    public ConsumerProfile inputReletionship(String inputReletionship) {
        this.inputReletionship = inputReletionship;
        return this;
    }

    public void setInputReletionship(String inputReletionship) {
        this.inputReletionship = inputReletionship;
    }

    public String getInputHobbies() {
        return inputHobbies;
    }

    public ConsumerProfile inputHobbies(String inputHobbies) {
        this.inputHobbies = inputHobbies;
        return this;
    }

    public void setInputHobbies(String inputHobbies) {
        this.inputHobbies = inputHobbies;
    }

    public String getReccomendedProductTypes() {
        return reccomendedProductTypes;
    }

    public ConsumerProfile reccomendedProductTypes(String reccomendedProductTypes) {
        this.reccomendedProductTypes = reccomendedProductTypes;
        return this;
    }

    public void setReccomendedProductTypes(String reccomendedProductTypes) {
        this.reccomendedProductTypes = reccomendedProductTypes;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public ConsumerProfile createdDate(Long createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public ConsumerProfile lastUpdatedDate(Long lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
        return this;
    }

    public void setLastUpdatedDate(Long lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ConsumerProfile createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public ConsumerProfile lastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
        return this;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Boolean isIsLoggedInUser() {
        return isLoggedInUser;
    }

    public ConsumerProfile isLoggedInUser(Boolean isLoggedInUser) {
        this.isLoggedInUser = isLoggedInUser;
        return this;
    }

    public void setIsLoggedInUser(Boolean isLoggedInUser) {
        this.isLoggedInUser = isLoggedInUser;
    }

    public SuchAzUser getSuchAzUser() {
        return suchAzUser;
    }

    public ConsumerProfile suchAzUser(SuchAzUser suchAzUser) {
        this.suchAzUser = suchAzUser;
        return this;
    }

    public void setSuchAzUser(SuchAzUser suchAzUser) {
        this.suchAzUser = suchAzUser;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConsumerProfile consumerProfile = (ConsumerProfile) o;
        if (consumerProfile.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), consumerProfile.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ConsumerProfile{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", gender='" + getGender() + "'" +
            ", age='" + getAge() + "'" +
            ", inputTraits='" + getInputTraits() + "'" +
            ", traitStructure='" + getTraitStructure() + "'" +
            ", activityStructure='" + getActivityStructure() + "'" +
            ", hobbyStructure='" + getHobbyStructure() + "'" +
            ", inputReletionship='" + getInputReletionship() + "'" +
            ", inputHobbies='" + getInputHobbies() + "'" +
            ", reccomendedProductTypes='" + getReccomendedProductTypes() + "'" +
            ", createdDate=" + getCreatedDate() +
            ", lastUpdatedDate=" + getLastUpdatedDate() +
            ", createdBy='" + getCreatedBy() + "'" +
            ", lastUpdatedBy='" + getLastUpdatedBy() + "'" +
            ", isLoggedInUser='" + isIsLoggedInUser() + "'" +
            "}";
    }
}
