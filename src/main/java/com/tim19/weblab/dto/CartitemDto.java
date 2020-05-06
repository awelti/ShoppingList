package com.tim19.weblab.dto;

public class CartitemDto {

    private String name;

    private int id;

    private int anzahl;

    public CartitemDto(){

    }

    public CartitemDto(int id, String name, int anzahl){
        this.id = id;
        this.name = name;
        this.anzahl=anzahl;
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

    public int getAnzahl() {return anzahl; }

    public void setAnzahl(int anzahl) {this.anzahl=anzahl;}
}
