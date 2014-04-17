package com.stack.domain;

public enum Role {

    Admin("Admin"),
    User("User"),
    Developer("Developer"),
    Finance("Finance");
    
    private final String role;
    
    private Role(String role) {
        this.role = role;
    }

    @Override 
    public String toString() {
        return role;
    }
    
}
