package MemberRegistrationandManagement;

public class DeleteUserAccount
{
    public static void deleteAccount(String name) // method which allows the user to delete an account
    {
        UserAccount account = UserStorage.getObj(name); // store reference to the object with the associated name, which is the argument when the getObj method is being called here
        if (account != null) // if a user account object exists inside the account variable
        {
            if (account.getLoginStatus()) // if the user is logged into the account they are trying to delete
            {
                UserStorage.removeMapPair(name); // remove the account from the system storage
                System.out.println("Account deleted successfully.");
            }
        }
        else // otherwise, if no account exists inside the account variable
        {
            System.out.println("This account does not exist in the system, therefore you cannot delete it.");
        }
    }
}
