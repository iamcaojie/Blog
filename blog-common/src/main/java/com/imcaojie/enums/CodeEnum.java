package com.imcaojie.enums;

public enum CodeEnum {
    /**
     *
     */
    OK("ok",200);
    private final String name;
    private final int status;

    CodeEnum(String name, int status) {
        this.name = name;
        this.status = status;
    }
    public String getName(){
        return name;
    }
    public int getStatus(){
        return status;
    }
}
