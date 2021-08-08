package models;

import java.util.UUID;

public class User {
    String name ;
    String email_id ;
    String contact ;
    String uuid ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public User(String name, String email_id, String contact, String uuid) {
        this.name = name;
        this.email_id = email_id;
        this.contact = contact;
        UUID u = UUID.randomUUID();
        this.uuid  = u.toString();
    }
}
