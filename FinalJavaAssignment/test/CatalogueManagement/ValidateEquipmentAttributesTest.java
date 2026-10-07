package CatalogueManagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateEquipmentAttributesTest {

    @Test
    void itemNameCannotContainNumbers()
    {
        assertFalse(ValidateEquipmentAttributes.itemNameValidation("Item12345")); // ensure that the new equipment item name cannot contain any numbers
    }

    @Test
    void itemNameCannotContainSpecialCharacters()
    {
        assertFalse(ValidateEquipmentAttributes.itemNameValidation("Item!!!!")); // ensure that the new equipment item name cannot contain any special characters
    }

    @Test
    void itemNameMustBeLongerThanTwoCharacters()
    {
        assertFalse(ValidateEquipmentAttributes.itemNameValidation("w")); // ensure that the new equipment item name must be longer than two characters
    }

    @Test
    void validItemName()
    {
        assertTrue(ValidateEquipmentAttributes.itemNameValidation("Glorious")); // ensure that a valid equipment item name, which does not break any of the rules mentioned, is accepted
    }

    @Test
    void itemModelCannotContainAnySpecialCharacters()
    {
        assertFalse(ValidateEquipmentAttributes.itemModelValidation("O!!!!!")); // ensure that the model cannot contain any special characters
    }

    @Test
    void validItemModel()
    {
        assertTrue(ValidateEquipmentAttributes.itemModelValidation("O")); // ensure that a valid model is accepted
    }

    @Test
    void dateThatCannotExistIsRejected()
    {
        assertFalse(ValidateEquipmentAttributes.itemPurchaseDateValidation("35/02/2007")); // ensure a date which cannot exist will not be accepted
    }

    @Test
    void dateInTheWrongFormattingIsRejected()
    {
        assertFalse(ValidateEquipmentAttributes.itemPurchaseDateValidation("12-02-2007")); // ensure a date which is in the wrong formatting will not be accepted
    }

    @Test

    void validDateIsAccepted()
    {
        assertTrue(ValidateEquipmentAttributes.itemPurchaseDateValidation("28/06/2007")); // ensure that a date which does exist and is in the correct format is accepted
    }

    @Test
    void invalidCategoryIsRejected()
    {
        assertFalse(ValidateEquipmentAttributes.itemCategoryValidation("Fizzy Drink Can")); // show that a category which does not exist will not be accepted
    }

    @Test
    void validCategoryIsAccepted()
    {
        assertTrue(ValidateEquipmentAttributes.itemCategoryValidation("Mouse")); // show that a valid category will be accepted
    }

    @Test
    void invalidItemAvailabilityIsRejected()
    {
        assertFalse(ValidateEquipmentAttributes.itemAvailabilityValidation(5)); // show that an invalid (anything other than 1 or 2) will be rejected
    }

    @Test
    void validItemAvailabilityIsAccepted()
    {
        assertTrue(ValidateEquipmentAttributes.itemAvailabilityValidation(2)); // show that a valid input of one will be accepted
        assertTrue(ValidateEquipmentAttributes.itemAvailabilityValidation(1)); // show that a valid input of one will be accepted
    }
}