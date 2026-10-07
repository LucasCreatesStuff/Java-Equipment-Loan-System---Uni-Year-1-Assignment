package CatalogueManagement;


public class DeleteEquipmentItem
{
    public static void delete(String name) // method that allows you to delete an equipment item from the system
    {
        EquipmentItem item = ItemStorage.getObj(name); // store reference to the object with the associated name, which is the argument when the getObj method is being called here
        if (item != null) // if there is an item stored inside the item variable...
        {
            ItemStorage.removeMapPair(name); // remove it from the storage
            System.out.println("Item deleted successfully.");
        }
        else // if there is no item stored inside the item variable...
        {
            System.out.println("This item does not exist in the system, so it cannot be deleted.");
        }
    }
}