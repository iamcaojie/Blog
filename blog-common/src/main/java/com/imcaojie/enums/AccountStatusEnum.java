package com.imcaojie.enums;

public enum AccountStatusEnum {
    /**
     *
     */
    OK("ok",1);
    private final String name;
    private final int status;

    AccountStatusEnum(String name, int status) {
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
