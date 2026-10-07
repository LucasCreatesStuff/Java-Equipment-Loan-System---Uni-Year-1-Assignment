package CatalogueManagement;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.*;

class EquipmentItemTest {

    LocalDate checkoutdate = LocalDate.of(2026, 2, 1);
    LocalDate duedate = LocalDate.of(2026,3,1);

    EquipmentItem GloryMouse = new EquipmentItem("Glorious", "O", "21/03/2020", "Mouse", "In Stock", checkoutdate, duedate);

    @Test
    void getItemName()
    {
        assertEquals("Glorious", GloryMouse.getItemName()); // show that the method getItemName gives you the name of an equipment item
    }

    @Test
    void getItemModel()
    {
        assertEquals("O", GloryMouse.getItemModel()); // show that the method getItemModel gives you the model of an equipment item
    }

    @Test
    void getItemPurchaseDate()
    {
        assertEquals("21/03/2020", GloryMouse.getItemPurchaseDate()); // show that the method getItemPurchaseDate gives you the purchase date of an equipment item
    }

    @Test
    void getItemCategory()
    {
        assertEquals("Mouse", GloryMouse.getItemCategory()); // show that the method getItemCategory gives you the purchase date of an equipment item
    }

    @Test
    void getItemAvailability()
    {
        assertEquals("In Stock", GloryMouse.getItemAvailability()); // show that the method getItemAvailability gives you the availability of an equipment item
    }

    @Test
    void getCheckoutDate()
    {
        assertEquals(checkoutdate ,GloryMouse.getCheckoutDate()); // show that the method getCheckoutDate gives you the checkout date of an equipment item
    }

    @Test
    void setItemName()
    {
        GloryMouse.setItemName("Fantastic");
        assertEquals("Fantastic", GloryMouse.getItemName()); // show that the method setItemName will allow you to change the name of an equipment item
    }

    @Test
    void setItemModel()
    {
        GloryMouse.setItemModel("P");
        assertEquals("P", GloryMouse.getItemModel()); // show that the method setItemModel will allow you to change the model of an equipment item
    }

    @Test
    void setItemPurchaseDate()
    {
        GloryMouse.setItemPurchaseDate("02/02/2002");
        assertEquals("02/02/2002", GloryMouse.getItemPurchaseDate()); // show that the method setItemPurchaseDate will allow you to change the purchase date of an equipment item
    }

    @Test
    void setItemCategory()
    {
        GloryMouse.setItemCategory("Monitor");
        assertEquals("Monitor", GloryMouse.getItemCategory()); // show that the method setItemCategory will allow you to change the category of an equipment item
    }

    @Test
    void setItemAvailability()
    {
        GloryMouse.setItemAvailability("Checked out");
        assertEquals("Checked out", GloryMouse.getItemAvailability()); // show that the method setItemAvailability will allow you to change the availability of an equipment item
    }

    @Test
    void setCheckoutDate()
    {
        LocalDate newcheckoutdate = LocalDate.of(2008, 2, 2);
        GloryMouse.setCheckoutDate(newcheckoutdate);
        assertEquals(newcheckoutdate, GloryMouse.getCheckoutDate()); // show that the method setCheckoutDate will allow you to change the checkout date of an equipment item
    }

    @Test
    void setDueDate()
    {
        LocalDate newcheckoutdate = LocalDate.of(2008, 2, 2);
        GloryMouse.setCheckoutDate(newcheckoutdate);
        GloryMouse.setDueDate(); // calculates due date by adding 30 days onto the checkout date of the item
        assertEquals(LocalDate.of(2008, 3, 3),GloryMouse.getDueDate()); // show that the method setDueDate will allow you to change the due date of an equipment item
    }

    @Test
    void getDueDate()
    {
        assertEquals(LocalDate.of(2026, 3, 1) , GloryMouse.getDueDate()); // shows that the method getDueDate will allow you to get the due date of an equipment item
    }

    @Test
    void testToString() throws Exception
    {

        String text = tapSystemOut(() -> {
            System.out.println(GloryMouse.toString());
        });

        assertTrue(text.contains("Glorious{item_model: Oitem_purchase_date: 21/03/2020item_category Mouseitem_availability In Stock}"));
    }
}