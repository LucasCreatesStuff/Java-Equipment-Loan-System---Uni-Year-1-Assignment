package CatalogueManagement.EquipmentLoanSystem;

import CatalogueManagement.*;
import CatalogueManagement.BorrowingAndReturning.BorrowEquipmentItem;
import CatalogueManagement.BorrowingAndReturning.ReturnEquipmentItem;
import MemberRegistrationandManagement.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EquipmentLoanSystem
{

    public void Start()
    {
        boolean welcomeAdminOptionsPrinted = false; // flag to tell if all the options that the admin is able to take have been printed out
        boolean welcomeUserOptionsPrinted = false; // flag to tell if all the options that the user could take have been printed out
        int choice; // declare int choice
        AdminAccount admin = new AdminAccount("Admin", "06547 987990", "AdminPass", "123", false); // creates a predetermined admin account upon system startup
        UserAccount currentAccount = null; // tracks the account that the user is currently logged into

        UserStorage.addPairToMap(admin); // adds the admin account to the account storage

        while (true) // infinite while loop allowing this system to run continuously
        {
            if (currentAccount == null)  // if the user is not logged into the account, then we print out the message below:
            {
                System.out.println("\nHello! Before you are able to use our system - please either create an account, or login to an existing one.");
                System.out.println("Please select one of the following options:");
                System.out.println("To login to an existing account, enter 1.");
                System.out.println("To create a staff account, enter 2.");
                System.out.println("To create a student account, enter 3.");
            }

            Scanner scanbot = new Scanner(System.in); // create scanner so we are able to take input from the user
            choice = scanbot.nextInt(); // take a choice as integer input from the user

            if (choice == 1) // allow the user to login to an account
            {
                scanbot.nextLine(); // consumes the newline after hitting enter on option 1, so that the scanbot.nextLine() intended to be executed first is not skipped
                System.out.println("What is the name of the account that you would like to login to?");
                try {
                    String login_name = scanbot.nextLine(); // take login name as String input from the user
                    UserAccount account = UserStorage.getObj(login_name); // store the reference for the object that has the input name associated with it
                    if (!account.getLoginStatus()) // we can only be logged into one account at a time, so we first check if the account the user wants to login to is actually logged into
                    {
                        if (currentAccount != null) // if the user is already logged into an account...
                        {
                            System.out.println("Please be aware, that once you login to another account you will automatically be logged out of this one.");
                            if (UserStorage.getObj(login_name).login())  // try to login and if successful...
                            {
                                currentAccount.logout(); // logout of the account that the user is currently logged into
                                currentAccount = account; // set current account to the account that the user has logged into
                            }
                        }
                        else if (UserStorage.getObj(login_name).login())  // if the user is not logged into an account currently, allow them to try to login
                        {
                            currentAccount = account; // if the login is successful we set the current account variable to the account just logged into
                        }
                    }
                    else  // if the user is logged into the account already...
                    {
                        System.out.println("You are already logged into this account.");
                    }
                }
                catch (NullPointerException e) // this exception occurs if the account does not exist
                {
                    System.out.println("This account does not exist - you cannot login to it.");
                }
            }

            if (choice == 2) // allow the user to create a staff account
            {
                scanbot.nextLine(); // consume the newline created by hitting enter on the 2nd option, so that the first scanbot.nextLine (after 'What is your name?') functions as intended and is not skipped
                // ask the user for information needed to create a staff account below - each input is validated:
                System.out.println("What is your name?");
                String name = scanbot.nextLine();
                if (ValidateAccountAttributes.nameValidation(name))
                {
                    System.out.println("What is your phone number?");
                    String phoneNumber = scanbot.nextLine();
                    if (ValidateAccountAttributes.phoneNumberValidation(phoneNumber))
                    {
                        System.out.println("What would you like to set your password to?");
                        String password = scanbot.nextLine();
                        if (ValidateAccountAttributes.passwordValidation(password))
                        {
                            System.out.println("What is your staffID?");
                            String staffID = scanbot.nextLine();
                            if (ValidateAccountAttributes.validateID(staffID)) // if all of the inputs have been entered and are valid...
                            {
                                StaffAccount newstaff = new StaffAccount(name, phoneNumber, password, staffID, false); // create the staff account using the information entered and set loggedIn to false, since the user has not yet logged into this account - it has only been created
                                System.out.println("Staff account successfully created.");

                                UserStorage.addPairToMap(newstaff); // add it to the system
                            }
                        }
                    }
                }
            }

            if (choice == 3) // allow the user to create a student account
            {
                scanbot.nextLine(); // to consume the newline created by hitting enter on the 3rd option, so that the first scanbot.nextLine (after 'What is your name?') functions as intended and is not skipped
                // ask the user for information needed to create a student account below - each input is validated:
                System.out.println("What is your name?");
                String name = scanbot.nextLine();
                if (ValidateAccountAttributes.nameValidation(name))
                {
                    System.out.println("What is your phone number?");
                    String phoneNumber = scanbot.nextLine();
                    if (ValidateAccountAttributes.phoneNumberValidation(phoneNumber))
                    {
                        System.out.println("What would you like to set your password to?");
                        String password = scanbot.nextLine();
                        if (ValidateAccountAttributes.passwordValidation(password))
                        {
                            System.out.println("What is your studentID?");
                            String studentID = scanbot.nextLine();
                            if (ValidateAccountAttributes.validateID(studentID))  // if all of the inputs have been entered and are valid...
                            {
                                StudentAccount newstudent = new StudentAccount(name, phoneNumber, password, studentID, false); // create the student account using the information entered and set loggedIn to false, since the user has not yet logged into this acocunt - it has only been created
                                System.out.println("Student account successfully created.");
                                UserStorage.addPairToMap(newstudent); // add it to the system
                            }
                        }
                    }
                }
            }

            if (admin.getLoginStatus()) // if the user is currently logged into the admin account, they are also able to call options 4,5,6,7,8,9 and 10
            {
                if (!welcomeAdminOptionsPrinted) // if all of the options that the admin is able to choose from have not been printed out yet, then we print them out
                {
                    System.out.println("\nWelcome! You are now able to choose from the following options:"
                            + "\nTo create an item and add it to the system, enter 4."
                            + "\nTo delete an item from the system, enter 5."
                            + "\nTo change the name of an item, enter 6."
                            + "\nTo change the model of an item, enter 7."
                            + "\nTo change the purchase date of an item, enter 8."
                            + "\nTo change the category of an item, enter 9."
                            + "\nTo change the availability of an item, enter 10."
                            + "\nTo display all of the items that are stored in the system, enter 11."
                            + "\nTo borrow an item, enter 12."
                            + "\nTo return an item, enter 13."
                            + "\nTo delete your user account, enter 14."
                            + "\nTo edit the name associated with your account, enter 15."
                            + "\nTo edit the phone number associated with your account, enter 16."
                            + "\nTo edit the password associated with your account, enter 17."
                            + "\nTo edit the ID associated with your account, enter 18."
                            + "\nTo logout of your account, enter 19."
                            + "\nTo see the options available to you again, enter 20.");
                    welcomeAdminOptionsPrinted = true; // since all the options that the admin is able to take have been printed out, we now set the flag welcomeAdminOptionsPrinted to true
                    // this means they will not be printed again, unless the admin wants to see them again - in that case they are able to enter '20' as their choice
                }

                if (choice == 4) // allow the lab admin to create and automatically add an item to the system
                {

                    scanbot.nextLine(); // consumes the newline character after hitting enter on option 4, so that this one is skipped and the first scanbot.nextLine() is executed as intended
                    System.out.println("What is the name of the equipment item?");
                    String itemName = scanbot.nextLine();
                    if (ValidateEquipmentAttributes.itemNameValidation(itemName))
                    {
                        System.out.println("What is the model of the equipment item?");
                        String itemModel = scanbot.nextLine();
                        if (ValidateEquipmentAttributes.itemModelValidation(itemModel))
                        {
                            System.out.println("When was this equipment item purchased? Please provide the date in the following format: dd/MM/yyyy");
                            String itemPurchaseDate = scanbot.nextLine();
                            if (ValidateEquipmentAttributes.itemPurchaseDateValidation(itemPurchaseDate))
                            {
                                System.out.println("What is the category of this equipment item?");
                                String itemCategory = scanbot.nextLine();
                                if (ValidateEquipmentAttributes.itemCategoryValidation(itemCategory))
                                {
                                    System.out.println("What is the availability of this item? For in stock, enter 1. For checked out, enter 2.");
                                    try
                                    {
                                        int itemAvailabilitynumber = scanbot.nextInt();
                                        if (ValidateEquipmentAttributes.itemAvailabilityValidation(itemAvailabilitynumber)) // if all the inputs have been entered and are valid...
                                        {
                                            if (itemAvailabilitynumber == 1) // if the user has input 1 into the system when asked what the availability of the item is...
                                            {
                                                String itemAvailability = "In Stock";
                                                // then if all of the validation checks have passed we will create the item
                                                EquipmentItem newitem = new EquipmentItem(itemName, itemModel, itemPurchaseDate, itemCategory, itemAvailability);
                                                // and then we will automatically add it to the storage
                                                ItemStorage.addPairToMap(newitem); // then we are able to reference the object by its name
                                                System.out.println("That item has successfully been created and added to the system.");
                                            }
                                            else // otherwise, the user must have entered 2. This is because the itemavailability must be valid to reach this point and the only other valid number aside from one, is two.
                                            {
                                                String itemAvailability = "Checked out";
                                                // then if all of the validation checks have passed we will create the item
                                                EquipmentItem newitem = new EquipmentItem(itemName, itemModel, itemPurchaseDate, itemCategory, itemAvailability);
                                                // and then we will automatically add it to the storage
                                                ItemStorage.addPairToMap(newitem); // then we are able to reference the object by its name
                                                System.out.println("That item has successfully been created and added to the system.");
                                    }
                                        }
                                    }
                                    catch(InputMismatchException e) // catches if the user attempts to enter anything but a number into item availability
                                    {
                                        System.out.println("You must enter a number, either 1 or 2 - nothing else.");
                                    }
                                }
                            }
                        }
                    }
                }

                if (choice == 5) // allow the lab admin to delete an item from the system
                {
                    scanbot.nextLine(); // consumes the newline character after hitting enter on option 5, so that the next scanbot.nextLine() does not take it in
                    System.out.println("What item would you like to delete from the system?");
                    String name = scanbot.nextLine();
                    DeleteEquipmentItem.delete(name); // deletes the item that is associated with the name the user entered as input
                }

                if (choice == 6) // allows the lab admin to change the name of an item
                {
                    scanbot.nextLine(); // consumes the newline character after hitting enter on option 6, so that the next scanbot.nextLine() does not take it in
                    System.out.println("What item would you like to change the name of?");
                    String name = scanbot.nextLine();
                    EditEquipmentItem.setItemName(name); // calls the set item name method on the item associated with the name that the user entered as input
                }

                if (choice == 7) // allows the lab admin to change the model of an item
                {
                    scanbot.nextLine(); // consumes the newline character after hitting enter on option 7, so that the next scanbot.nextLine() does not take it in
                    System.out.println("What item would you like to change the model of?");
                    String name = scanbot.nextLine();
                    EditEquipmentItem.setItemModel(name); // calls the set item model method on the item associated with the name that the user entered as input
                }

                if (choice == 8) // allows the lab admin to change the purchase date of an item
                {
                    scanbot.nextLine(); // consumes the newline character after hitting enter on option 8, so that the next scanbot.nextLine() does not take it in
                    System.out.println("What item would you like to change the purchase date of?");
                    String name = scanbot.nextLine();
                    EditEquipmentItem.setItemPurchaseDate(name); // calls the set item purchase date method on the item associated with the name that the user entered as input
                }

                if (choice == 9) // allows the lab admin to change the category of an item
                {
                    scanbot.nextLine(); // consumes the newline character after hitting enter on option 9, so that the next scanbot.nextLine() does not take it in
                    System.out.println("What item would you like to change the category of?");
                    String name = scanbot.nextLine();
                    EditEquipmentItem.setItemCategory(name); // calls the set item category method on the item associated with the name that the user entered as input
                }

                if (choice == 10) // allows the lab admin to change the availability of an item
                {
                    scanbot.nextLine(); // consumes the newline character after hitting enter on option 10, so that the next scanbot.nextLine() does not take it in
                    System.out.println("What item would you like to change the availability of?");
                    String name = scanbot.nextLine();
                    EditEquipmentItem.setItemAvailability(name); // calls the set item availability method on the item assocaited with the name that the user entered as input
                }
            }

            if (currentAccount != null) // if the user is currently logged into any account
            {
                if (!welcomeUserOptionsPrinted && currentAccount != admin) // if the options that any user that a user other than the admin is able to take have not been printed, and the user is not currently logged into the admin account...
                {
                    System.out.println("Welcome! You are now able to choose from the following options:"
                            + "\nTo display all of the items that are stored in the system, enter 11."
                            + "\nTo borrow an item, enter 12."
                            + "\nTo return an item, enter 13."
                            + "\nTo delete your user account, enter 14."
                            + "\nTo edit the name associated with your account, enter 15."
                            + "\nTo edit the phone number associated with your account, enter 16."
                            + "\nTo edit the password associated with your account, enter 17."
                            + "\nTo edit the ID associated with your account, enter 18."
                            + "\nTo logout of your account, enter 19."
                            + "\nTo see the options available to you again, enter 20.");

                            welcomeUserOptionsPrinted = true; // the options that any user other than the admin is able to take have now been printed, so we set the flag welcomeUserOptionsPrinted to true
                }

                if (choice == 11) // display all of the items that are stored in the system
                {
                    ItemStorage.displayStoredItems();
                }

                if (choice == 12) // allow the user to borrow an item
                {
                    scanbot.nextLine(); // consumes the newline character after hitting enter on option 12, so that the next scanbot.nextLine() does not take it in
                    System.out.println("What item would you like to borrow?");
                    String name = scanbot.nextLine();
                    BorrowEquipmentItem.checkoutItem(name); // calls the checkout item method from the borrow equipment item class, on the item associated with the name that the user has entered as input
                }

                if (choice == 13) // allow the user to return an item
                {
                    scanbot.nextLine(); // consumes the newline character after hitting enter on option 13, so that the next scanbot.nextLine() does not take it in
                    System.out.println("What item would you like to return?");
                    String name = scanbot.nextLine();
                    ReturnEquipmentItem.returnItem(name); // calls the return item method from the return equipment item class, on the item associated with the name that the user has entered as input
                }

                if (choice == 14) // allow the user to delete an account
                {
                    scanbot.nextLine(); // consumes the newline character after hitting enter on option 14, so that the next scanbot.nextLine() does not take it in
                    System.out.println("What is the name of the account which you would like to delete from the system?");
                    String name = scanbot.nextLine();
                    DeleteUserAccount.deleteAccount(name); // calls the delete account method from the delete user account class, on the item associated with the name that the user has entered as input
                }

                if (choice == 15) // allow the user to edit the name of an account
                {
                    scanbot.nextLine(); // consumes the newline character after hitting enter on option 15, so that the next scanbot.nextLine() does not take it in
                    System.out.println("What is the name of the account that you would like to change the name of?");
                    String name = scanbot.nextLine();
                    EditUserAccount.setName(name); // calls the set name method from the edit user account class, on the user account associated with the name that the user has entered as input
                }

                if (choice == 16) // allow the user to edit the phone number associated with an account
                {
                    scanbot.nextLine(); // consumes the newline character after hitting enter on option 16, so that the next scanbot.nextLine() does not take it in
                    System.out.println("What is the name of the account that you would like to change associated phone number of?");
                    String name = scanbot.nextLine();
                    EditUserAccount.setPhoneNumber(name); // calls the set phone number method from the edit user account class, on the user account associated with the name that the user has entered as input
                }

                if (choice == 17) // allows the user to edit a password associated with an account
                {
                    scanbot.nextLine(); // consumes the newline character after hitting enter on option 17, so that the next scanbot.nextLine() does not take it in
                    System.out.println("What is the name of the account that you would like to edit the password of?");
                    String name = scanbot.nextLine();
                    EditUserAccount.setPassword(name); // calls the set password method from the edit user account class, on the user account associated with the name that the user has entered as input
                }

                if (choice == 18) // allows the user to edit the ID associated with an account
                {
                    scanbot.nextLine(); // consumes the newline character after hitting enter on option 18, so that the next scanbot.nextLine() does not take it in
                    System.out.println("What is the name of the account that you would like to change the associated ID of?");
                    String name = scanbot.nextLine();
                    EditUserAccount.setID(name); // calls the setID method from the edit user account class, on the user account associated with the name that the user has entered as input
                }

                if (choice == 19) // allows the user to logout of an account
                {
                    currentAccount.logout(); // logs the user out of the account that they are currently logged into
                    currentAccount = null; // since the user has now been logged out and is not logged into any account, we set the value of the currentAccount variable to null
                    System.out.println("You have logged out successfully.");
                }

                if (choice == 20) // prints out all the options a user could take
                {
                    if (admin.getLoginStatus()) // if the user is logged into the admin account, we print these options...
                    {
                        System.out.println("\nThese are the following options that you are able to choose from:"
                                + "\nTo create an item and add it to the system, enter 4."
                                + "\nTo delete an item from the system, enter 5."
                                + "\nTo change the name of an item, enter 6."
                                + "\nTo change the model of an item, enter 7."
                                + "\nTo change the purchase date of an item, enter 8."
                                + "\nTo change the category of an item, enter 9."
                                + "\nTo change the availability of an item, enter 10."
                                + "\nTo display all of the items that are stored in the system, enter 11."
                                + "\nTo borrow an item, enter 12."
                                + "\nTo return an item, enter 13."
                                + "\nTo delete your user account, enter 14."
                                + "\nTo edit the name associated with your account, enter 15."
                                + "\nTo edit the phone number associated with your account, enter 16."
                                + "\nTo edit the password associated with your account, enter 17."
                                + "\nTo edit the ID associated with your account, enter 18."
                                + "\nTo logout of your account, enter 19."
                                + "\nTo see the options available to you again, enter 20.");
                    }
                    else // otherwise, we print these ones...
                    {
                        System.out.println("These are the following options that you are able to choose from:"
                                + "\nTo display all of the items that are stored in the system, enter 11."
                                + "\nTo borrow an item, enter 12."
                                + "\nTo return an item, enter 13."
                                + "\nTo delete your user account, enter 14."
                                + "\nTo edit the name associated with your account, enter 15."
                                + "\nTo edit the phone number associated with your account, enter 16."
                                + "\nTo edit the password associated with your account, enter 17."
                                + "\nTo edit the ID associated with your account, enter 18."
                                + "\nTo logout of your account, enter 19."
                                + "\nTo see the options available to you again, enter 20.");
                    }
                }

            }
        }
    }
}
