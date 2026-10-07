package CatalogueManagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class EditEquipmentItem
{

    public static void setItemName(String name) // method which allows you to set the name of an equipment item
    {
        try
        {
            EquipmentItem item = ItemStorage.getObj(name); // store reference to the object with the associated name, which is the argument when the getObj method is being called here
            System.out.println("What would you like to change the name of the item to?");
            Scanner scan = new Scanner(System.in); // create new scanner to take user input
            String nameChange = scan.next(); // desired name stored in variable nameChange
            if(ValidateEquipmentAttributes.itemNameValidation(nameChange)) // if desired name is valid...
            {
                if(!nameChange.equals(item.getItemName())) // check that the new name is not the same as the current name of the item
                {
                    ItemStorage.removeMapPair(item.getItemName()); // remove the pair
                    item.setItemName(nameChange); // change the name of the item to the one stored in the variable nameChange
                    ItemStorage.addPairToMap(item); // add the new pair, with the new name
                    System.out.println("Item name changed successfully.");
                }
                else // if the new name is the same as the current name of the item...
                {
                    System.out.println("The new name cannot be the same as the current name.");
                }
            }
        }
        catch(NullPointerException e) // if there is no item stored in the item variable...
        {
            System.out.println("This item does not exist in the system, so you cannot change its name.");
        }
    }

    public static void setItemModel(String name) // method which allows you to set the model of an equipment item
    {
        try
        {
            EquipmentItem item = ItemStorage.getObj(name); // store reference to the object with the associated name, which is the argument when the getObj method is being called here
            System.out.println("What would you like to change the model of the item to?");
            Scanner scan = new Scanner(System.in); // create new scanner to take the user input
            String modelChange = scan.next(); // desired model stored in variable modelChange
            if(ValidateEquipmentAttributes.itemModelValidation(modelChange)) // if desired model is valid then...
            {
                if(!modelChange.equals(item.getItemModel())) // check that the new model is not the same as the current model that is associated with the item
                {
                    item.setItemModel(modelChange); // change the model of the item to the one stored in the variable modelChange
                    System.out.println("Item model changed successfully.");
                }
                else // if the new model is the same as the current model of the item
                {
                    System.out.println("This item already has this model associated with it.");
                }
            }
        }
        catch(NullPointerException e) // if there is no item stored in the item variable
        {
            System.out.println("This item does not exist in the system, so you cannot change its model.");
        }

    }

    public static void setItemPurchaseDate(String name) // method which allows you to set the purchase date of an item
    {
        try
        {
            EquipmentItem item = ItemStorage.getObj(name); // store reference to the object with the associated name, which is the argument when the getObj method is being called here
            System.out.println("What would you like to change the purchase date of this item to? Please input the new purchase date in the format: dd/MM/yyyy");
            Scanner scan = new Scanner(System.in); // create new scanner to take the user input
            String purchaseDateChange = scan.next(); // desired purchase date stored in the variable purchaseDateChange
            if(ValidateEquipmentAttributes.itemPurchaseDateValidation(purchaseDateChange)) // if the desired purchase date is valid...
            {
                if (!Objects.equals(purchaseDateChange, item.getItemPurchaseDate())) // check that the new purchase date is not the same as the current purchase date that is associated with the item
                {
                    item.setItemPurchaseDate(purchaseDateChange); // change the purchase date of the item to the one stored in the variable purchaseDateChange
                    System.out.println("Item purchase date changed successfully.");
                }
                else // if the new purchase date is the same as the current purchase date of the item
                {
                    System.out.println("This item already has this purchase date associated with it.");
                }
            }
        }
        catch(NullPointerException e) // if there is no item stored in the item variable
        {
            System.out.println("This item does not exist in the system, so you cannot change its purchase date.");
        }
    }

    public static void setItemCategory(String name) // method which allows you to set the category of an item
    {
        try
        {
            EquipmentItem item = ItemStorage.getObj(name); // store reference to the object with the associated name, which is the argument when the getObj method is being called here
            System.out.println("What would you like to change the category of this item to?");
            Scanner scan = new Scanner(System.in); // create new scanner to take the user input
            String itemCategoryChange = scan.next(); // desired item category stored in the variable itemCategoryChange
            if(ValidateEquipmentAttributes.itemCategoryValidation(itemCategoryChange)) // if the desired item category is valid...
            {
                if(!Objects.equals(itemCategoryChange, item.getItemCategory())) // check that the new item category is not the same as the current item category associated with the item
                {
                    item.setItemCategory(itemCategoryChange); // change the category of the item to the one stored in the variable itemCategoryChange
                    System.out.println("Item category changed successfully.");
                }
                else // if the new category is the same as the current category of the item
                {
                    System.out.println("This item is already marked down as being in this category."); // otherwise, print this error message
                }
            }
        }
        catch(NullPointerException e) // if there is no item stored in the item variable
        {
            System.out.println("This item does not exist in the system, so you cannot change its category.");
        }

    }

    public static void setItemAvailability(String name) // method which allows you to set the availability of an item
    {
        try
        {
            EquipmentItem item = ItemStorage.getObj(name); // store reference to the object with the associated name, which is the argument when the getObj method is being called here
            System.out.println("If you would like to change the availability of this item to in stock, enter 1. If you would like to change the availability of this item to checked out, press 2.");
            Scanner scan = new Scanner(System.in); // create new scanner to take the user input
            int itemAvailabilityChange = scan.nextInt(); // desired item availability change input stored in the variable itemAvailabilityChange
            if(ValidateEquipmentAttributes.itemAvailabilityValidation(itemAvailabilityChange)) // if the item availability change input is valid...
            {
                if (itemAvailabilityChange == 1) // if the input was 1
                {
                    if (!Objects.equals(item.getItemAvailability(), "In Stock")) // check that the availability of the item is not already set to in stock
                    {
                        item.setItemAvailability("In Stock"); // change the item availability to "In Stock"
                        System.out.println("Item Availability changed to In Stock.");
                    }
                    else // if the item availability is already set to "In Stock"
                    {
                        System.out.println("This item is already marked as 'In Stock'");
                    }
                }
                else if(!Objects.equals(item.getItemAvailability(), "Checked out")) // otherwise, if the valid input is not 1, then it has to be 2. So we check if the item availability is not already set to "Checked out"
                {
                    item.setItemAvailability("Checked out"); // set the item availability to checked out
                    System.out.println("Item Availability changed to checked out.");
                }
                else // otherwise, if the item availability is already set to "Checked out"
                {
                    System.out.println("This item is already marked as 'Checked out'");
                }
            }
        }
        catch(NullPointerException e) // if there is no item stored in the item variable
        {
            System.out.println("This item does not exist in the system, so you cannot change its availability.");
        }
    }

    public static void setCheckoutDate(String name) // allows the checkout date of an item to be set - this method is used by other methods
    {
        EquipmentItem item = ItemStorage.getObj(name); // store reference to the object with the associated name, which is the argument when the getObj method is being called here
        item.setCheckoutDate(LocalDate.now()); // set the items checkout date to the current date
    }

    public static void setDueDate(String name) // allows the due date of an item to be set - this method is also used by other methods
    {
        EquipmentItem item = ItemStorage.getObj(name); // store reference to the object with the associated name, which is the argument when the getObj method is being called here
        item.setDueDate(); // set the items checkout date to the current date
    }
}
