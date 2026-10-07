package MemberRegistrationandManagement;

import java.util.HashMap;

public abstract class UserAccount
{
    private String name;
    private String phoneNumber;
    private String password;
    private String ID;
    private boolean loggedIn;

    public UserAccount(String name, String phoneNumber, String password, boolean loggedIn)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.loggedIn = loggedIn;
    }

    public String get_accName() // allow for retrieval of the name associated with a user account
    {
        return name;
    }

    public String get_accPassword() // allow for retrieval of the password associated with a user account
    {
        return password;
    }

    public String get_accID() // allow for retrieval of the ID associated with a user account
    {
        return ID;
    }

    public String get_accNumber() // allow for retrieval of the phone number associated with a user account
    {
        return phoneNumber;
    }

    public void set_accName(String alt_name) // allow for the setting of the name associated with a user account
    {
        name = alt_name;
    }

    public void set_accPhoneNumber(String alt_phoneNumber) // allow for the setting of the phone number associated with a user account
    {
        phoneNumber = alt_phoneNumber;
    }

    public void set_accPassword(String alt_password) // allow for the setting of the password associated with a user account
    {
        password = alt_password;
    }

    public void set_accID(String alt_ID) // allow for the setting of the ID associated with a user account
    {
        ID = alt_ID;
    }

    public boolean getLoginStatus() // allow for the retrieval of the login status associated with a user account
    {
        return loggedIn;
    }

    public boolean login() // allow the user to login to any user account
    {
        loggedIn = true;
        return true;
    }

    public void logout() // allow the user to logout of any user account
    {
        loggedIn = false;
        System.out.println("You have been successfully logged out.");
    }

    public String toString() // method to print out the user account in a readable format
    {
        return name + "{phoneNumber: " + phoneNumber + " password: " + password
                + "ID: ";
    }
}
