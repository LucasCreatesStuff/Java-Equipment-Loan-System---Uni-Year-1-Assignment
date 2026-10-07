package MemberRegistrationandManagement;

public class ValidateAccountAttributes
{
    public static boolean nameValidation(String nameChange) // method to validate a user account name
    {
        if (nameChange.chars().anyMatch(Character::isDigit)) // the name cannot have any numbers in it
        {
            System.out.println("The name associated with this account cannot have any digits in it.");
            return false;
        }

        if (nameChange.length() < 2) // the length of the name entered cannot be less than 2 characters - because then it is clearly not a name
        {
            System.out.println("The name you enter should be more than 2 characters. A name cannot consist of less than 2 characters.");
            return false;
        }

        if (nameChange.chars().allMatch(Character::isLetterOrDigit) == false) // cannot contain special characters
        {
            System.out.println("This new name cannot contain any special characters.");
            return false;
        }

        return true; // if all of these conditions have not been met, then the account name is valid so we can return true
    }

    public static boolean phoneNumberValidation(String phoneNumberChange) // method to validate a user phone number
    {
        if (phoneNumberChange.length() != 11)
        {
            System.out.println("UK phone numbers are typically 11 digits long, so the number you have entered is highly likely to be invalid. If you believe we have made a mistake, please contact the developer of this system.");
            return false;
        }

        if (phoneNumberChange.chars().anyMatch(Character::isLetter))
        {
            System.out.println("A phone number does not have any characters in it, only digits. Please enter a valid phone number.");
            return false;
        }

        if (phoneNumberChange.chars().allMatch(Character::isLetterOrDigit) == false) // cannot contain special characters
        {
            System.out.println("A phone number cannot contain any special characters.");
            return false;
        }

        return true; // if all of these conditions have not been met, then the user phone number is valid, so we can return true
    }

    public static boolean passwordValidation(String passwordChange) // method to validate a user account password
    {

        if (passwordChange.length() < 8) // must be min 8 characters long
        {
            System.out.println("Your password must be 8 characters long, minimum.");
            return false;
        }

        if (passwordChange.chars().noneMatch(Character::isUpperCase)) // must have at least one uppercase char
        {
            System.out.println("Your password must have a minimum of one upper case character.");
            return false;
        }

        if (passwordChange.chars().noneMatch(Character::isLowerCase)) // must have at least one lower case char
        {
            System.out.println("Your password must contain at least one lower case character.");
            return false;
        }

        if (passwordChange.chars().noneMatch(Character::isDigit)) // must have at least one number
        {
            System.out.println("Your password must contain at least one number.");
            return false;
        }

        if (passwordChange.chars().allMatch(Character::isLetterOrDigit)) // must have at least one special character
        {
            System.out.println("Your password must contain at least one special character.");
            return false;
        }

        return true; // if all of these conditions have not been met, then the user account password is valid, so we can return true

    }

    public static boolean validateID(String altID) // method to validate the ID associated with a user account
    {
        if (altID.chars().allMatch(Character::isLetterOrDigit) == false) // cannot contain special characters
        {
            System.out.println("This new ID cannot contain any special characters.");
            return false;
        }

        return true; // if all of these conditions have not been met, then the user account ID is valid, so we can return true
    }
}
