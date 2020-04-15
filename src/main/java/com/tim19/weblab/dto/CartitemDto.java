package com.tim19.weblab.dto;

public class CartitemDto {

    private String name;

    private int id;

    public CartitemDto(){

    }

    public CartitemDto(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
