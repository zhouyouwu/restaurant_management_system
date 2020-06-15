package com.team.entity;

public class Auth {
    private Integer authId;

    private String authValue;

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getAuthValue() {
        return authValue;
    }

    public void setAuthValue(String authValue) {
        this.authValue = authValue == null ? null : authValue.trim();
    }
}