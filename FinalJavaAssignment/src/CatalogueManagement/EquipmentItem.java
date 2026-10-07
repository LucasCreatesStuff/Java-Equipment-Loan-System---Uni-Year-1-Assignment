package CatalogueManagement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EquipmentItem {
    private String itemName;
    private String itemModel;
    private String itemPurchaseDate;
    private String itemCategory;
    private String itemAvailability;
    private LocalDate checkoutDate;
    private LocalDate dueDate;

    public EquipmentItem(String itemName, String itemModel, String itemPurchaseDate, String itemCategory, String itemAvailability)
    {
        this.itemName = itemName;
        this.itemModel = itemModel;
        this.itemPurchaseDate = itemPurchaseDate;
        this.itemCategory = itemCategory;
        this.itemAvailability = itemAvailability;
    }

    public EquipmentItem(String itemName, String itemModel, String itemPurchaseDate, String itemCategory, String itemAvailability, LocalDate CheckoutDate, LocalDate DueDate) // extra constructor for testing
    {
        this.itemName = itemName;
        this.itemModel = itemModel;
        this.itemPurchaseDate = itemPurchaseDate;
        this.itemCategory = itemCategory;
        this.itemAvailability = itemAvailability;
        this.checkoutDate = CheckoutDate;
        this.dueDate = DueDate;
    }

    public String getItemName() // getter method to get the name of an item
    {

        return itemName;
    }

    public String getItemModel() // getter method to get the model of an item
    {

        return itemModel;
    }

    public String getItemPurchaseDate() // getter method to get the purchase date of an item
    {

        return itemPurchaseDate;
    }

    public String getItemCategory() // getter method to get the category of an item
    {

        return itemCategory;
    }

    public String getItemAvailability()  // getter method to get the availability of an item
    {

        return itemAvailability;
    }

    public LocalDate getCheckoutDate() // getter method to get the checkout date of an item
    {
        return checkoutDate;
    }

    public void setItemName(String alt_name) // basic setter method to set the name of an item
    {
        itemName = alt_name;
    }

    public void setItemModel(String alt_model) // basic setter method to set the model of an item
    {
        itemModel = alt_model;
    }

    public void setItemPurchaseDate(String alt_purchaseDate) // basic setter method to set the purchase date of an item
    {
        itemPurchaseDate = alt_purchaseDate;
    }

    public void setItemCategory(String alt_category) // basic setter method to set the category of an item
    {
        itemCategory = alt_category;
    }

    public void setItemAvailability(String alt_availability) // basic setter method to set the availability of an item
    {
        itemAvailability = alt_availability;
    }

    public void setCheckoutDate(LocalDate date) // basic setter method to set the checkout date of an item
    {
        checkoutDate = date;
    }

    public void setDueDate() // basic setter method to set the due date of an item
    {
        dueDate = checkoutDate.plusDays(30); // everyone is able to borrow an item for a maximum of 30 days, before they have to return it
    }

    public LocalDate getDueDate() // getter method to get the due date of an item
    {
        return dueDate;
    }

    public String toString() // method which allows us to print out an equipment item in a friendlier format for the user
    {
        return itemName + "{item_model: " + itemModel + "item_purchase_date: " + itemPurchaseDate
                + "item_category " + itemCategory + "item_availability " + itemAvailability + "}";
    }
}

