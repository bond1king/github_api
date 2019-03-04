package com.bhargav;

/**
 *
 * Created by Bhargav on 04/03/2019.
 */
public class Repository {

    String id;
    String name;
    String fullName;
    String contributorsURL;

    public Repository(String id, String name, String fullName, String contributorsURL) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.contributorsURL = contributorsURL;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getContributorsURL() {
        return contributorsURL;
    }
}
