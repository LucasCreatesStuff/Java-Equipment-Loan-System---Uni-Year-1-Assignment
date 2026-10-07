package MemberRegistrationandManagement;

import java.util.Scanner;

public class StaffAccount extends UserAccount // inherits from the user account class, because it is a user account
{

    private String staffID;

    public StaffAccount(String name, String phoneNumber, String password, String staffID, boolean loggedIn)
    {
        super(name, phoneNumber, password, loggedIn);
        this.staffID = staffID;
    }

    @Override
    public boolean login() // allows the user to login to a staff account, if certain conditions are met
    {
        System.out.println("Please enter your staffID.");
        Scanner scan = new Scanner(System.in);
        String staffID_input = scan.next();
        System.out.println("Please enter your password.");
        String passwordInput = scan.next();

        if (staffID_input.equals(staffID))
        {
            if (passwordInput.equals(get_accPassword()))
            {
                System.out.println("Login successful. Starting up system...");
                super.login();
                return true;
            }
            else
            {
                System.out.println("Login unsuccessful. Incorrect staffID or password.");
                return false;
            }
        }
        else
        {
            System.out.println("Login unsuccessful. Incorrect staffID or password.");
            return false;
        }
    }

    public String get_accID() // method to allow the retrieval of the ID associated with the staff account
    {
        return staffID;
    }

    @Override
    public void set_accID(String alt_id) // method that allows for the setting of the ID associated with the staff account
    {
        staffID = alt_id;
    }

    public String toString() // method to print out a staff account in a readable format
    {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(staffID);
        sb.append("}");

        return String.valueOf(sb);
    }
}
