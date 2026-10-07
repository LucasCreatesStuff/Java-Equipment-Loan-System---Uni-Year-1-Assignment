package MemberRegistrationandManagement;

import java.util.Scanner;

public class EditUserAccount
{
    public static void setName(String name) // method which allows the user to set the name of an account, if specific conditions are met
    {
        try
        {
            UserAccount account = UserStorage.getObj(name); // store reference to the object with the associated name, which is the argument when the getObj method is being called here
            System.out.println("What would you like to set the name of the account holder to?");
            Scanner scan = new Scanner(System.in); // create scanner so that we can take input
            String nameChange = scan.next(); // store input
            if (ValidateAccountAttributes.nameValidation(nameChange)) // if the input is valid
            {
                if (!nameChange.equals(account.get_accName())) // if the desired name is not the same as the accounts current name
                {
                    if(account.getLoginStatus()) // if the account is logged into
                    {
                        UserStorage.removeMapPair(name); // remove it from the system storage
                        account.set_accName(nameChange); // change its name
                        UserStorage.addPairToMap(account); // add the new pair with the new name - this ensures that when the user is wanting to access the account by name they can still do so
                        System.out.println("The name associated with this account has been changed successfully.");
                    }
                    else // if the account is not logged into...
                    {
                        System.out.println("You cannot take this action since you are not logged into this account.");
                    }
                }
                else // if the desired name is the same as the accounts current name...
                {
                    System.out.println("The new name cannot be the same as the current name.");
                }
            }
        }
        catch(NullPointerException e) // if there is no account inside the account variable...
        {
            System.out.println("This account does not exist in our system. Therefore, there is no associated name for you to edit.");
        }
    }

    public static void setPhoneNumber(String name) // method which allows the user to set the phone number associated with an account, if specific conditions are met
    {
        try
        {
            UserAccount account = UserStorage.getObj(name); // store reference to the object with the associated name, which is the argument when the getObj method is being called here
            System.out.println("What would you like to change the phone number associated with this account to?");
            Scanner scan = new Scanner(System.in); // create scanner to take input
            String numberChange = scan.next(); // store input
            if(ValidateAccountAttributes.phoneNumberValidation(numberChange)) // if the desired phone number change is valid...
            {
                if (!numberChange.equals(account.get_accNumber())) // if the new phone number is not the same as the current phone number
                {
                    if (account.getLoginStatus()) // if the user is logged into the account...
                    {
                        account.set_accPhoneNumber(numberChange);
                        System.out.println("The phone number associated with this account has been changed successfully.");
                    }
                    else // if they are not logged into the account...
                    {
                        System.out.println("You cannot take this action because you are not logged into this account.");
                    }
                }
                else // if the new phone number is the same as the phone number currently associated with the chosen account...
                {
                    System.out.println("The new phone number cannot be the same as the current phone number.");
                }
            }
        }
        catch(NullPointerException e) // if there is no account in the account variable...
        {
            System.out.println("This account does not exist in our system. Therefore, there is no associated phone number for you to edit.");
        }
    }

    public static void setPassword(String name) // method which allows the user to set the password of an account, if specific conditions are met
    {
        try
        {
            UserAccount account = UserStorage.getObj(name); // store reference to the object with the associated name, which is the argument when the getObj method is being called here
            System.out.println("What would you like to change the password associated with this account to?");
            Scanner scan = new Scanner(System.in); // create scanner to take input
            String passwordChange = scan.next(); // store input
            if(ValidateAccountAttributes.passwordValidation(passwordChange)) // if the desired passwordChange is valid...
            {
                if (!passwordChange.equals(account.get_accPassword())) // if the new password is not the same as the current password
                {
                    if (account.getLoginStatus()) // if the user is logged into the account they would like to change the password of
                    {
                        account.set_accPassword(passwordChange);
                        System.out.println("Your password has been changed successfully.");
                    }
                    else // if the user is not logged into the account they would like to change the password of
                    {
                        System.out.println("You cannot take this action because you are not logged into this account.");
                    }
                }
                else // if the new password is the same as the current password
                {
                    System.out.println("The new password cannot be the same as the current password.");
                }
            }
        }
        catch(NullPointerException e) // if there is no account that exists inside the account variable
        {
            System.out.println("This account does not exist in our system. Therefore, there is no associated password for you to edit.");
        }
    }

    public static void setID(String name) // method that allows the user to set the ID of an account, if specific conditions are met
    {
        try{
            UserAccount account = UserStorage.getObj(name); // store reference to the object with the associated name, which is the argument when the getObj method is being called here
            System.out.println("What would you like to change the ID associated with this account to?");
            Scanner scan = new Scanner(System.in); // create scanner to take input
            String altID = scan.next(); // store input
            if(ValidateAccountAttributes.validateID(altID)) // if the alternate ID that is input is valid
            {
                if (!altID.equals(account.get_accID())) // if the new ID is not the same as the current ID
                {
                    if (account.getLoginStatus()) // if the user is logged into the account
                    {
                        account.set_accID(altID);
                        System.out.println("The ID associated with this account has been changed successfully.");
                    }
                    else // if the user is not logged into the account
                    {
                        System.out.println("You cannot take this action because you are not logged into this account.");
                    }
                }
                else // if the alternate ID is not valid
                {
                    System.out.println("The new ID cannot be the same as the current ID");
                }
            }
        }
        catch(NullPointerException e) // if an account does not exist inside the account variable =
        {
            System.out.println("This account does not exist in our system. Therefore, there is no associated ID for you to edit.");
        }
    }
}
