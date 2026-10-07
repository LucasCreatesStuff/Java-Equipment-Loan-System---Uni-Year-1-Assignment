package MemberRegistrationandManagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserStorageTest {

    UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);

    @Test
    void addPairToMap()
    {
        UserStorage.addPairToMap(student);

        assertEquals("{James=James{phoneNumber: 07765347218 password: James123!ID: Student12}}", UserStorage.userAccounts.toString()); // confirm that this method adds a pair to the system storage by printing the hashmap user accounts via the toString method

    }

    @Test
    void getObj()
    {
        UserStorage.addPairToMap(student); // adding valid student account to the hashmap
        assertEquals(student , UserStorage.getObj(student.get_accName())); // testing that we are able to use this method to get the object of the account
    }

    @Test
    void removeMapPair()
    {
        UserStorage.addPairToMap(student);
        System.out.println(UserStorage.userAccounts.toString()); // proving that the student has been successfully added to the hashmap

        UserStorage.removeMapPair("James"); // removing the pair we just added
        assertEquals("{}" ,UserStorage.userAccounts.toString()); // confirming that we have been able to remove the pair successfully

    }
}