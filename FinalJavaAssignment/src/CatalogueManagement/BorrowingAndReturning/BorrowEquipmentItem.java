package CatalogueManagement.BorrowingAndReturning;
import CatalogueManagement.EditEquipmentItem;
import CatalogueManagement.EquipmentItem;
import CatalogueManagement.ItemStorage;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BorrowEquipmentItem
{

    public static void checkoutItem(String name) // method that allows the user to checkout an item
    {
        try
        {
            EquipmentItem checkoutItem = ItemStorage.getObj(name); // store reference to the object with the associated name, which is the argument when the getObj method is being called here
            if (checkoutItem.getItemAvailability().equals("In Stock")) // if the availability of the item is in stock...
            {
                // need to come back to this and edit set item availability so that we can pass in input automatically
                checkoutItem.setItemAvailability("Checked out"); // change the availability of the item to checked out
                EditEquipmentItem.setCheckoutDate(name); // set the items checkout date
                EditEquipmentItem.setDueDate(name); // calculate the due date for returning the item
                System.out.println("You have successfully checked out " + checkoutItem + "This item should be returned to us before or upon this due date :" + checkoutItem.getDueDate() + ".");
            }
            else // if the item is not in stock...
            {
                System.out.println("You cannot borrow this item, because it is not in stock at the moment.");
            }
        }
        catch(NullPointerException e) // exception occurs when the item does not exist in the system
        {
            System.out.println("This item does not exist in the system, so you cannot borrow it.");
        }
    }
}
