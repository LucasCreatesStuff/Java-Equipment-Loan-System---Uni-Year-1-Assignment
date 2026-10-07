package CatalogueManagement.BorrowingAndReturning;

import CatalogueManagement.EquipmentItem;
import CatalogueManagement.ItemStorage;
import MemberRegistrationandManagement.DeleteUserAccount;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.*;

class BorrowEquipmentItemTest {

    LocalDate date = LocalDate.now();

    @org.junit.jupiter.api.Test
    void checkoutItem() throws Exception
    {
        EquipmentItem checkoutItem = new EquipmentItem("Glorious", "O", "12/12/2012", "Mouse", "In Stock", date, date);

        ItemStorage.addPairToMap(checkoutItem);

        String text = tapSystemOut(() -> {
            BorrowEquipmentItem.checkoutItem("Glorious");
        });

        assertEquals("Checked out" , checkoutItem.getItemAvailability());
        assertTrue(text.contains("You have successfully checked out " + checkoutItem + "This item should be returned to us before or upon this due date :" + checkoutItem.getDueDate() + "."));



    }

    @Test
    void cannotCheckoutItemThatIsNotInStock() throws Exception
    {
        EquipmentItem checkoutItem = new EquipmentItem("Glorious", "O", "12/12/2012", "Mouse", "Checked out", date, date);

        ItemStorage.addPairToMap(checkoutItem);

        String text = tapSystemOut(() -> {
            BorrowEquipmentItem.checkoutItem("Glorious");
        });

        assertTrue(text.contains("You cannot borrow this item, because it is not in stock at the moment.")); // shows that the user is unable to borrow the item when it is already checked out
    }

    @Test
    void cannotCheckoutAnItemThatDoesNotExist() throws Exception
    {
        // do not add the item to the hashmap so that it does not exist

        String text = tapSystemOut(() -> {
            BorrowEquipmentItem.checkoutItem("Glorious");
        });

        assertTrue(text.contains("This item does not exist in the system, so you cannot borrow it."));
    }
}