package com.uygardeniz.dto;

public class DtoAuthor {

    private Long id;
    private String firstName;
    private String lastName;
    private String birthDate;

    public DtoAuthor() {
    }

    public DtoAuthor(String firstName, String lastName, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "DTOAuthor{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
                + birthDate + '}';
    }

}
