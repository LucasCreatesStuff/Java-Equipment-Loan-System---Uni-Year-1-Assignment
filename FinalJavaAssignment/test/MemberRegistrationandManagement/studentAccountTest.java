package MemberRegistrationandManagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class studentAccountTest {

    UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);

    // already tested student login method in the user account test class (dynamic polymorphism)

    @Test
    void get_accID()
    {
        assertEquals("Student12", student.get_accID()); // testing that we are able to correctly get the ID of this account
    }

    @Test
    void set_accID()
    {
        student.set_accID("Student26");
        assertEquals("Student26", student.get_accID()); // check to make sure that once we have used the set_accID method to set the ID associated with this account, it has successfully changed the ID to what we input
    }
}