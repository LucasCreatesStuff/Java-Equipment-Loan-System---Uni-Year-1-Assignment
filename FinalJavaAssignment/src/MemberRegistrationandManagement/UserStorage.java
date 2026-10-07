package MemberRegistrationandManagement;

import java.util.HashMap;

public class UserStorage
{
    protected static HashMap<String, UserAccount> userAccounts = new HashMap<>(); // user accounts storage - links account name to the object account so that the user can refer to an account by account name

    public static void addPairToMap(UserAccount user) // method to add a user to the user storage
    {
        userAccounts.put(user.get_accName(), user);
    }

    public static void removeMapPair(String userName) // method to remove a user account from the user storage
    {
        userAccounts.remove(userName);
    }

    public static UserAccount getObj(String accountName) // method to get the obj associated with a specific account name
    {
        return userAccounts.get(accountName);
    }


}
