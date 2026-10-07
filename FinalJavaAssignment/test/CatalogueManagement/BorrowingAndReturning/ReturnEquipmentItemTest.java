package CatalogueManagement.BorrowingAndReturning;

import CatalogueManagement.DeleteEquipmentItem;
import CatalogueManagement.EditEquipmentItem;
import CatalogueManagement.EquipmentItem;
import CatalogueManagement.ItemStorage;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.*;

class ReturnEquipmentItemTest {

    LocalDate checkoutdate = LocalDate.of(2026, 2, 1);
    LocalDate duedate = LocalDate.of(2026,3,1);
    EquipmentItem GloryMouse = new EquipmentItem("Glorious", "O", "21/03/2020", "Mouse", "Checked Out", checkoutdate, duedate);

    @Test
    void cannotReturnItemThatDoesNotExist() throws Exception
    {
        String text = tapSystemOut(() -> {
            ReturnEquipmentItem.returnItem("Steels");
        });

        assertTrue(text.contains("This item does not exist in the system. If you think this is a mistake, and the item you have is property of the University, please contact the lab administrator."));
    }

    @Test
    void returnItemLate() throws Exception
    {
        ItemStorage.addPairToMap(GloryMouse);
        ReturnEquipmentItem.returnItem("Glorious");
        long daysBetweenDates = ChronoUnit.DAYS.between(GloryMouse.getDueDate(), LocalDate.now());

        String text = tapSystemOut(() -> {
            ReturnEquipmentItem.returnItem("Glorious");
        });

        assertTrue(text.contains("You have returned this item late. Please pay your overdue fee of £" + daysBetweenDates + " to the lab administrator."));
        assertEquals("In Stock", GloryMouse.getItemAvailability()); // shows that the item availability has been changed to back in stock, proving that the item has been successfully returned

    }

    @Test
    void returnItemOnTime()
    {
        EquipmentItem GloryMouse = new EquipmentItem("Glorious", "O", "21/03/2020", "Mouse", "Checked Out", checkoutdate, LocalDate.now());
        ItemStorage.addPairToMap(GloryMouse);
        ReturnEquipmentItem.returnItem("Glorious");

        assertEquals("In Stock", GloryMouse.getItemAvailability()); // shows that the item availability has been changed to back in stock, proving that the item has been successfully returned
    }
}