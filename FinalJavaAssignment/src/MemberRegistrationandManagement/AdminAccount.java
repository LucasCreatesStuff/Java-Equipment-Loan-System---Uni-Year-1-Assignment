package MemberRegistrationandManagement;

public class AdminAccount extends StaffAccount // inherits from the staff account class because it is a type of staff account
{

    public AdminAccount(String name, String phoneNumber, String password, String staffID, boolean loggedIn) // constructor for admin. No methods are in here because we can call all the methods we need to on this account via dynamic polymorphism.
    {
        super(name, phoneNumber, password, staffID, loggedIn);
    }

}
