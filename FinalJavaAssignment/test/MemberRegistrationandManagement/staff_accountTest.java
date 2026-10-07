package MemberRegistrationandManagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class staff_accountTest {

    UserAccount barry = new StaffAccount("Barry", "07765347218", "Barry3456!", "Staff60", false);

    // already tested staff login method in the user account test class (dynamic polymorphism)

    @Test
    void get_accID()
    {
        assertEquals("Staff60", barry.get_accID()); // check that we are able to get the id of a staff account
    }

    @Test
    void set_accID()
    {
        barry.set_accID("Staff34"); // change the ID of account 'barry' from 'Staff60' to 'staff34'
        assertEquals("Staff34", barry.get_accID()); // check that the ID has been changed successfully
    }
}