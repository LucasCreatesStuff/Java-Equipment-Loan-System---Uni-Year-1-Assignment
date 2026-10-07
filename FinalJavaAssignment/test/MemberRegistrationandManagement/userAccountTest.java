package MemberRegistrationandManagement;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class userAccountTest {

    UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);


    @Test
    void get_accName()
    {
        assertEquals("James", student.get_accName()); // attempting to get the name of a valid student account
    }

    @Test
    void get_accPassword()
    {
        assertEquals("James123!", student.get_accPassword()); // attempting to get the password of a valid student account
    }

    @Test
    void get_accID()
    {
        assertEquals("Student12", student.get_accID()); // attempting to get the ID of a valid student account
    }

    @Test
    void set_accName()
    {
        student.set_accName("Bob");
        assertEquals("Bob", student.get_accName()); // checks if the student account 'student' now has the name bob associated with it, after we have used the set_accName method to change it
    }

    @Test
    void set_accPhoneNumber()
    {
        student.set_accPhoneNumber("765689437530");
        assertEquals("765689437530", student.get_accNumber()); // checks if the student account 'student' now has the phone number 765689437530 associated with it, after we have used the set_accPhoneNumber() method to change it
    }

    @Test
    void set_accPassword()
    {
        student.set_accPassword("Hammer5!");
        assertEquals("Hammer5!", student.get_accPassword()); // checks if the student account 'student' now has the password Hammer5! associated with it, after we have used the set_accPassword() method to change it
    }

    @Test
    void set_accID()
    {
        student.set_accID("Student75");
        assertEquals("Student75", student.get_accID()); // checks if the student account 'student' now has the ID Student75 associated with it, after we have used the set_accID() method to change it
    }

    @Test
    void loginStatusIsFalseWhenAnAccountIsNotLoggedInto()
    {
        assertFalse(student.getLoginStatus()); // checks that the method get login status returns false when called on an account that is not logged into, like student
    }

    @Test
    void loginStatusIsTrueWhenAnAccountIsLoggedInto()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", true); // account is logged into
        assertTrue(student.getLoginStatus()); // checks that the method get login status returns true when called on an account that has been logged into (we have just logged into the account 'student' now)
    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void canLoginToStudentAccountWhenEnteringValidInformation()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        provideInput("Student12" + System.lineSeparator() + "James123!" + System.lineSeparator());
        assertTrue(student.login());
    }

    @Test
    void cannotLoginToStudentAccountWhenEnteringInvalidStudentID()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        provideInput("Student1" + System.lineSeparator() + "James123!" + System.lineSeparator());
        assertFalse(student.login());
    }

    @Test
    void cannotLoginToStudentAccountWhenEnteringInvalidPassword()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        provideInput("Student12" + System.lineSeparator() + "James12!" + System.lineSeparator());
        assertFalse(student.login());
    }

    @Test
    void canLoginToStaffAccountWhenEnteringValidInformation()
    {
        UserAccount barry = new StaffAccount("Barry", "07765347218", "Barry3456!", "Staff60", false);
        provideInput("Staff60" + System.lineSeparator() + "Barry3456!" + System.lineSeparator());
        assertTrue(barry.login()); // check that we are able to login to a staff account when giving valid inputs
    }

    @Test
    void cannotLoginToStaffAccountWhenEnteringInvalidStaffID()
    {
        UserAccount barry = new StaffAccount("Barry", "07765347218", "Barry3456!", "Staff60", false);
        provideInput("Staff59" + System.lineSeparator() + "Barry3456!" + System.lineSeparator());
        assertFalse(barry.login());
    }

    @Test
    void cannotLoginToStaffAccountWhenEnteringInvalidPassword()
    {
        UserAccount barry = new StaffAccount("Barry", "07765347218", "Barry3456!", "Staff60", false);
        provideInput("Staff60" + System.lineSeparator() + "Barry345!" + System.lineSeparator());
        assertFalse(barry.login());
    }

    @Test
    void logout()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", true); // account is now logged into
        student.logout(); // logout of the account
        assertFalse(student.getLoginStatus()); // now we have logged out of the account, the login status should be false
    }
}