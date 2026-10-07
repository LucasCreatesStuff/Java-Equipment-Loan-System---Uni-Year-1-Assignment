package CatalogueManagement.BorrowingAndReturning;

import CatalogueManagement.EditEquipmentItem;
import CatalogueManagement.EquipmentItem;
import CatalogueManagement.ItemStorage;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class ReturnEquipmentItem extends BorrowEquipmentItem
{

    public static void returnItem(String name) // method that allows us to return an item
    {
        try{
            EquipmentItem item = ItemStorage.getObj(name); // store reference to the object with the associated name, which is the argument when the getObj method is being called here

            if (LocalDate.now().isAfter(item.getDueDate())) // if the current date is after the due date, the item is being returned late
            {
                long daysBetweenDates = ChronoUnit.DAYS.between(item.getDueDate(), LocalDate.now()); // calculate the number of days between the current date and the due date
                System.out.println("You have returned this item late. Please pay your overdue fee of £" + daysBetweenDates + " to the lab administrator."); // £1 overdue fee for every day the item is overdue for being returned
            }
            else
            {
                System.out.println("You have successfully returned this item."); // if the item is being returned on time then we simply print this message out
            }
            //need to edit the set item availability again so we can have input in the argument
            item.setItemAvailability("In Stock"); //set the availability of the item to be back in stock
        }
        catch(NullPointerException e) // this exception occurs if the item does not exist in the system
        {
            System.out.println("This item does not exist in the system. If you think this is a mistake, and the item you have is property of the University, please contact the lab administrator.");
        }
    }
}
