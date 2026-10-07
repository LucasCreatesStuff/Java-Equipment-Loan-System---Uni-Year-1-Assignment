package CatalogueManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class ValidateEquipmentAttributes
{

    public static boolean itemNameValidation(String nameChange) // method to validate an item name input
    {
        if (nameChange.chars().anyMatch(Character::isDigit)) // cannot contain digits
        {
            System.out.println("This new name cannot contain any numbers.");
            return false;
        }

        if (nameChange.chars().allMatch(Character::isLetterOrDigit) == false) // cannot contain special characters
        {
            System.out.println("This new name cannot contain any special characters.");
            return false;
        }

        if (nameChange.length() < 2) // the name must be longer than 2 characters
        {
            System.out.println("You must enter a valid name. There is no equipment item that would have a name this short.");
            return false;
        }

        return true; // otherwise, if none of these conditions are met, the item name is valid so return true
    }

    public static boolean itemModelValidation(String modelChange) // method to validate an item model input
    {
        if (modelChange.chars().allMatch(Character::isLetterOrDigit) == false) // model cannot have any special characters
        {
            System.out.println("The item model cannot contain any special characters.");
            return false;
        }

        return true; // otherwise, if this condition is met, the item model is valid so return true
    }

    public static boolean itemPurchaseDateValidation(String purchaseDateChange) // method to validate an item purchase date input
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // the format that all of these purchase dates should be
        dateFormat.setLenient(false); // strict adherence to the format
        try
        {
            Date parsedDate = dateFormat.parse(purchaseDateChange); // parse the date and format it
            return true;
        }
        catch (ParseException e) // if the date is not valid
        {
            System.out.println("The date you enter must be in the format specified: dd/MM/yyyy and it must be a valid date eg. you cannot have 51/02/2026 as there is no day '51' in February.");
            return false;
        }
    }

    public static boolean itemCategoryValidation(String input) // method to validate an item category input
    {
        enum Categories // valid categories that can be entered
        {
            MONITOR,
            COMPUTER,
            KEYBOARD,
            MOUSE,
            SPEAKERS,
            HEADPHONES
        }

        try
        {
            input = input.toUpperCase(); // change all characters in the input to uppercase, making sure that if a valid category is entered in lowercase it still matches the categories in the enum
            Categories Category = Categories.valueOf(input); // check the category exists
            return true;
        }
        catch(IllegalArgumentException e) // if category does not exist
        {
            System.out.println("Please enter a category that exists. If the category you have tried to enter should exist, please contact the developer of this system.");
            return false;
        }

    }

    public static boolean itemAvailabilityValidation(int input) // method to validate an item availability input
    {
        while (!(input == 1) && !(input == 2)) // while the input is not 1 or 2, print out the message below
        {
            System.out.println("Please enter either 1, to change the availability of the item to 'In Stock' or 2 for 'Checked out'.");
            return false;
        }

        return true; // if 1 or 2 is entered, we return true
    }


}
