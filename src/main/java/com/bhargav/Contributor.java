package com.bhargav;

/**
 * Contributor is just a user type object;
 * Created by Bhargav on 04/03/2019.
 */
public class Contributor {

    String id;
    String login;

    public Contributor(String id, String login) {
        this.id = id;
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contributor that = (Contributor) o;

        if (!id.equals(that.id)) return false;
        return login.equals(that.login);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + login.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return  login ;
    }
}
