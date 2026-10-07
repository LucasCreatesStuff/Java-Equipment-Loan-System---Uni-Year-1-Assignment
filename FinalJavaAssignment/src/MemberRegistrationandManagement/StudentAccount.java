package MemberRegistrationandManagement;

import java.util.Scanner;

public class StudentAccount extends UserAccount // inherits from the user account, since it is a type of user account
{

    private String studentID;

    public StudentAccount(String name, String phoneNumber, String password, String studentID, boolean loggedIn)
    {
        super(name, phoneNumber, password, loggedIn);
        this.studentID = studentID;
    }

    @Override
    public boolean login() // method that allows the user to login to the account, if certain conditions are met
    {
        System.out.println("Please enter your studentID.");
        Scanner scan = new Scanner(System.in);
        String studentID_input = scan.next();
        System.out.println("Please enter your password.");
        String passwordInput = scan.next();

        if (studentID_input.equals(studentID))
        {
            if (passwordInput.equals(get_accPassword()))
            {
                System.out.println("Login successful. Starting up system...");
                super.login();
                return true;
            }
            else
            {
                System.out.println("Login unsuccessful. Incorrect studentID or password.");
                return false;
            }
        }
        else{
            System.out.println("Login unsuccessful. Incorrect studentID or password.");
            return false;
        }
    }

    public String get_accID() // getter for student account ID
    {
        return studentID;
    }

    @Override
    public void set_accID(String alt_id) // setter for student account ID
    {
        studentID = alt_id;
    }

    public String toString() // method to print out a student account in a readable format
    {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(studentID);
        sb.append("}");

        return String.valueOf(sb);
    }
}
