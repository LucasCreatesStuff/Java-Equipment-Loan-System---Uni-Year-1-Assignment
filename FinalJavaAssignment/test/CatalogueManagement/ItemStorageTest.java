package CatalogueManagement;

import CatalogueManagement.BorrowingAndReturning.BorrowEquipmentItem;
import MemberRegistrationandManagement.UserStorage;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.*;

class ItemStorageTest {

    EquipmentItem GloryMouse = new EquipmentItem("Glorious", "O", "21/03/2020", "Mouse", "In Stock");

    @Test
    void addPairToMap()
    {
        ItemStorage.addPairToMap(GloryMouse);

        assertEquals("{Glorious=Glorious{item_model: Oitem_purchase_date: 21/03/2020item_category Mouseitem_availability In Stock}}", ItemStorage.Items.toString()); // confirm that this method adds a pair to the system storage by printing the hashmap user accounts via the toString method
    }

    @Test
    void removeMapPair()
    {
        ItemStorage.addPairToMap(GloryMouse);
        System.out.println(ItemStorage.Items.toString()); // proving that the student has been successfully added to the hashmap

        ItemStorage.removeMapPair("Glorious"); // removing the pair we just added
        assertEquals("{}" ,ItemStorage.Items.toString()); // confirming that we have been able to remove the pair successfully
    }

    @Test
    void getObj()
    {
        ItemStorage.addPairToMap(GloryMouse); // adding valid equipment item to the hashmap
        assertEquals(GloryMouse , ItemStorage.getObj(GloryMouse.getItemName())); // testing that we are able to use this method to get the object of the equipment item
    }

    @Test
    void displayStoredItems() throws Exception
    {

        ItemStorage.addPairToMap(GloryMouse);

        String text = tapSystemOut(() -> {
            ItemStorage.displayStoredItems();
        });

        assertTrue(text.contains("Name ┃ Model ┃ PurchaseDate ┃ Category ┃ Availability\n" +
                " Glorious ┃     O ┃ 21/03/2020        ┃ Mouse    ┃ In Stock")); // this is the table that should be printed out if this method functions as intended
    }
}