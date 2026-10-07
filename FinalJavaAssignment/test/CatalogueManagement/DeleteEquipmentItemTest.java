package CatalogueManagement;

import MemberRegistrationandManagement.DeleteUserAccount;
import MemberRegistrationandManagement.UserStorage;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.*;

class DeleteEquipmentItemTest {

    @Test
    void cannotDeleteEquipmentItemThatDoesNotExist() throws Exception
    {
        String text = tapSystemOut(() -> {
            DeleteEquipmentItem.delete("Glorious");
        });

        assertTrue(text.contains("This item does not exist in the system, so it cannot be deleted."));
    }

    @Test
    void deleteEquipmentItemThatDoesExist()
    {
        LocalDate checkoutdate = LocalDate.of(2026, 2, 1);
        LocalDate duedate = LocalDate.of(2026,3,1);
        EquipmentItem GloryMouse = new EquipmentItem("Glorious", "O", "21/03/2020", "Mouse", "In Stock", checkoutdate, duedate);
        ItemStorage.addPairToMap(GloryMouse);

        System.out.println(ItemStorage.Items.toString()); // proving that the item has successfully been added to the hashmap

        DeleteEquipmentItem.delete("Glorious"); // deleting the equipment item
        assertEquals("{}" ,ItemStorage.Items.toString()); // confirming that we have deleted the account successfully, by showing that it is no longer in the user storage


    }
}