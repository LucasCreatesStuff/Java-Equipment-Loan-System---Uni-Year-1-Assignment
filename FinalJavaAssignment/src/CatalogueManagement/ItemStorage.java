package CatalogueManagement;

import java.util.HashMap;

public class ItemStorage
{

    protected static HashMap<String, EquipmentItem> Items = new HashMap<>(); // hashmap to store all the Equipment Items and link them to what they are named so the user can easily access them again later

    public static void addPairToMap(EquipmentItem item) // method which allows the user to add an item to the system storage
    {
        Items.put(item.getItemName(), item); //add itemname, item mapping to the storage
    }

    public static void removeMapPair(String itemName) // method which allows the user to remove an item from the system storage
    {
        Items.remove(itemName); // remove item
    }

    public static EquipmentItem getObj(String name) // method which gets the object associated with a name input, from the system storage
    {
        return Items.get(name);
    }

    public static void displayStoredItems() // method to display all stored items
    {
        System.out.printf("\n %5s ┃ %5s ┃ %5s ┃ %5s ┃ %5s", "Name", "Model", "PurchaseDate", "Category", "Availability");
        for (EquipmentItem item : Items.values())
        {
            System.out.printf("\n %5s ┃ %5s ┃ %5s        ┃ %5s    ┃ %5s", item.getItemName(), item.getItemModel(), item.getItemPurchaseDate(), item.getItemCategory(), item.getItemAvailability());                                                         // NEED TO FIGURE OUT HOW TO PRINT TABLE OUT HERE
        }
    }
}