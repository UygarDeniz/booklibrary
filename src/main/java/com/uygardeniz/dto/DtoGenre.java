package com.uygardeniz.dto;

public class DtoGenre {

    private Long id;
    private String name;

    public DtoGenre() {
    }

    public DtoGenre(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DTOGenre{" + "id=" + id + ", name=" + name + '}';
    }
}
