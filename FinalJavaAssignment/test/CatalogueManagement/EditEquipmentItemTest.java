package CatalogueManagement;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.*;

class EditEquipmentItemTest {


    LocalDate checkoutdate = LocalDate.of(2026, 2, 1);
    LocalDate duedate = LocalDate.of(2026,3,1);
    EquipmentItem GloryMouse = new EquipmentItem("Glorious", "O", "21/03/2020", "Mouse", "In Stock", checkoutdate, duedate);

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void canSetNameOfEquipmentItemThatExistsIfTheNameChangeIsValid()
    {
        ItemStorage.addPairToMap(GloryMouse);
        provideInput("Arctic");
        EditEquipmentItem.setItemName("Glorious");

        assertEquals("Arctic" , GloryMouse.getItemName()); // shows that the item name has been changed

    }

    @Test
    void cannotSetNameOfEquipmentItemThatExistsIfTheNameChangeIsTheSameAsTheCurrentItemName()
    {
        ItemStorage.addPairToMap(GloryMouse);
        provideInput("Glorious");
        EditEquipmentItem.setItemName("Glorious");

        assertEquals("Glorious", GloryMouse.getItemName()); // shows that the name could not be changed

    }

    @Test
    void cannotSetNameOfEquipmentItemThatDoesNotExist()
    {
        // item not added to the map, so that it does not exist
        provideInput("Arctic");
        EditEquipmentItem.setItemName("Glorious");

        assertEquals("Glorious", GloryMouse.getItemName()); // shows that the item name could not be changed

    }

    @Test
    void cannotSetNameOfEquipmentItemThatExistsIfTheNameChangeIsInvalid()
    {
        ItemStorage.addPairToMap(GloryMouse);
        provideInput("w");
        EditEquipmentItem.setItemName("Glorious");

        assertEquals("Glorious", GloryMouse.getItemName()); // shows that the name could not be changed

    }


    @Test
    void canSetModelOfEquipmentItemThatExistsIfTheModelChangeIsValid()
    {
        ItemStorage.addPairToMap(GloryMouse);
        provideInput("Wireless");
        EditEquipmentItem.setItemModel("Glorious");

        assertEquals("Wireless", GloryMouse.getItemModel()); // shows that the item model has been changed
    }

    @Test
    void cannotSetModelOfEquipmentItemThatExistsIfTheModelChangeIsTheSameAsTheCurrentItemModel()
    {
        ItemStorage.addPairToMap(GloryMouse);
        provideInput("O");
        EditEquipmentItem.setItemModel("Glorious");

        assertEquals("O", GloryMouse.getItemModel()); // show that the item model could not be changed

    }

    @Test
    void cannotSetModelOfEquipmentItemThatDoesNotExist()
    {
        // item not added to the map so that it does not exist
        provideInput("2");
        EditEquipmentItem.setItemModel("Glorious");


        assertEquals("O", GloryMouse.getItemModel()); // shows that the item model could not be changed

    }

    @Test
    void cannotSetModelOfEquipmentItemThatExistsIfTheModelChangeIsInvalid()
    {
        ItemStorage.addPairToMap(GloryMouse);
        provideInput("2!");
        EditEquipmentItem.setItemModel("Glorious");

        assertEquals("O", GloryMouse.getItemModel()); // shows that the item model could not be changed

    }

    @Test
    void canSetPurchaseDateOfEquipmentItemThatExistsIfThePurchaseDateChangeIsValid()
    {
        ItemStorage.addPairToMap(GloryMouse);
        provideInput("28/02/2000");
        EditEquipmentItem.setItemPurchaseDate("Glorious");

        assertEquals("28/02/2000", GloryMouse.getItemPurchaseDate()); // show that the item purchase date could be changed

    }

    @Test
    void cannotSetPurchaseDateOfEquipmentItemThatExistsIfThePurchaseDateChangeIsTheSameAsTheCurrentItemPurchaseDate()
    {
        ItemStorage.addPairToMap(GloryMouse);
        provideInput("21/03/2020");
        EditEquipmentItem.setItemPurchaseDate("Glorious");

        assertEquals("21/03/2020", GloryMouse.getItemPurchaseDate()); // shows that the item purchase date could not be changed

    }

    @Test
    void cannotSetPurchaseDateOfEquipmentItemThatDoesNotExist()
    {
        // not adding the item to the hashmap, so that it does not exist
        provideInput("22/03/2021");
        EditEquipmentItem.setItemPurchaseDate("Glorious");

        assertEquals("21/03/2020", GloryMouse.getItemPurchaseDate()); // shows that the item purchase date could not be changed

    }

    @Test
    void cannotSetPurchaseDateOfEquipmentItemThatExistsIfThePurchaseDateChangeIsInvalid()
    {
        ItemStorage.addPairToMap(GloryMouse);
        provideInput("2!");
        EditEquipmentItem.setItemPurchaseDate("Glorious");

        assertEquals("21/03/2020", GloryMouse.getItemPurchaseDate()); // shows that the item purchase date could not be changed

    }

    @Test
    void canSetCategoryOfEquipmentItemThatExistsIfTheCategoryChangeIsValid()
    {
        ItemStorage.addPairToMap(GloryMouse);
        provideInput("Monitor");
        EditEquipmentItem.setItemCategory("Glorious");


        assertEquals("Monitor", GloryMouse.getItemCategory()); // shows that the item category could be changed

    }

    @Test
    void cannotSetCategoryOfEquipmentItemThatExistsIfTheCategoryChangeIsTheSameAsTheCurrentItemCategory()
    {
        ItemStorage.addPairToMap(GloryMouse);
        provideInput("Mouse");
        EditEquipmentItem.setItemCategory("Glorious");


        assertEquals("Mouse", GloryMouse.getItemCategory()); // show that item category could not be changed

    }

    @Test
    void cannotSetCategoryOfEquipmentItemThatDoesNotExist()
    {
        // not adding the item to the hashmap so it does not exist
        provideInput("Monitor");
        EditEquipmentItem.setItemCategory("Glorious");

        assertEquals("Mouse", GloryMouse.getItemCategory()); // show that item category could not be changed

    }

    @Test
    void cannotSetCategoryOfEquipmentItemThatExistsIfTheCategoryChangeIsInvalid()
    {
        ItemStorage.addPairToMap(GloryMouse);
        provideInput("Hammer");
        EditEquipmentItem.setItemCategory("Glorious");

        assertEquals("Mouse", GloryMouse.getItemCategory()); // show that item category could not be changed

    }

    @Test
    void canSetAvailabilityOfEquipmentItemThatExistsIfTheAvailabilityChangeIsValid()
    {
        ItemStorage.addPairToMap(GloryMouse);
        provideInput(String.valueOf(2));
        EditEquipmentItem.setItemAvailability("Glorious");

        assertEquals("Checked out", GloryMouse.getItemAvailability()); // shows that the item availability has been changed

    }

    @Test
    void cannotSetAvailabilityOfEquipmentItemThatExistsIfTheAvailabilityChangeIsTheSameAsTheCurrentItemAvailability()
    {
        ItemStorage.addPairToMap(GloryMouse);
        provideInput(String.valueOf(1));
        EditEquipmentItem.setItemAvailability("Glorious");

        assertEquals("In Stock", GloryMouse.getItemAvailability()); // show that the item availability could not be changed

    }

    @Test
    void cannotSetAvailabilityOfEquipmentItemThatDoesNotExist()
    {
        // not adding the item to the hashmap so that it does not exist
        provideInput(String.valueOf(2));
        EditEquipmentItem.setItemAvailability("Glorious");

        assertEquals("In Stock", GloryMouse.getItemAvailability()); // show that the item availability could not be changed

    }

    @Test
    void cannotSetAvailabilityOfEquipmentItemThatExistsIfTheAvailabilityChangeIsInvalid()
    {
        ItemStorage.addPairToMap(GloryMouse);
        provideInput(String.valueOf(3));
        EditEquipmentItem.setItemAvailability("Glorious");

        assertEquals("In Stock", GloryMouse.getItemAvailability()); // show that the item availability could not be changed

    }

    @Test
    void setCheckoutDate()
    {

        ItemStorage.addPairToMap(GloryMouse);
        EditEquipmentItem.setCheckoutDate("Glorious"); // set checkout date using the setCheckoutDate method

        assertEquals(LocalDate.now() , GloryMouse.getCheckoutDate()); // the set checkout date method should set the checkout date to the current date, this assertion proves it has - if it passes
    }

    @Test
    void setDueDate()
    {
        ItemStorage.addPairToMap(GloryMouse);
        EditEquipmentItem.setCheckoutDate("Glorious"); // set the checkout date of the equipment item
        EditEquipmentItem.setDueDate("Glorious"); // set the due date using the setDueDate method

        assertEquals(LocalDate.now().plusDays(30), GloryMouse.getDueDate()); // the set due date method should set the due date to the checkout date (LocalDate.now()) plus 30 days, this assertion proves it has - if it passes
    }
}