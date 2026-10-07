package MemberRegistrationandManagement;

import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.*;

class DeleteUserAccountTest {

    @Test
    void cannotDeleteAccountThatDoesNotExist() throws Exception
    {
        String text = tapSystemOut(() -> {
                DeleteUserAccount.deleteAccount("James");
            });

        assertTrue(text.contains("This account does not exist in the system, therefore you cannot delete it."));
    }

    @Test
    void youCanDeleteUserAccountIfYouAreLoggedIntoIt()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", true);
        UserStorage.addPairToMap(student);
        System.out.println(UserStorage.userAccounts.toString()); // proving that the student has been successfully added to the hashmap

        DeleteUserAccount.deleteAccount("James"); // deleting the account
        assertEquals("{}" ,UserStorage.userAccounts.toString()); // confirming that we have deleted the account successfully, by showing that it is no longer in the user storage
    }
}