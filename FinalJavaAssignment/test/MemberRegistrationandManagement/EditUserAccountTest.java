package MemberRegistrationandManagement;
import org.junit.jupiter.api.Test;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

import java.io.ByteArrayInputStream;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class EditUserAccountTest {


    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void youCannotSetTheNameOfAnAccountThatDoesNotExist() throws Exception
    {
        provideInput("Bob");
        String text = tapSystemOut(() -> {
            EditUserAccount.setName("Jeff");
        });
        assertTrue(text.contains("This account does not exist in our system. Therefore, there is no associated name for you to edit."));
    }

    @Test
    void youCannotSetTheNameOfAnAccountToBeItsCurrentName()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        UserStorage.addPairToMap(student);

        provideInput("James");
        EditUserAccount.setName("James");

        assertTrue(Objects.equals("James", student.get_accName())); // confirm that the name could not be changed
    }

    @Test
    void youCannotSetTheNameOfAnAccountEvenIfItIsValidIfYouAreNotLoggedIntoTheAccount()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        UserStorage.addPairToMap(student);

        provideInput("Matilda");
        EditUserAccount.setName("James");

        assertTrue(Objects.equals("James", student.get_accName())); // confirm that the name could not be changed
    }


    @Test
    void youCanSetTheNameOfAnAccountIfItIsValidAndYouAreLoggedIntoTheAccount()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", true);
        UserStorage.addPairToMap(student);

        provideInput("Matilda");
        EditUserAccount.setName("James");

        assertTrue(Objects.equals("Matilda", student.get_accName())); // confirm that the name has been changed successfully
    }

    @Test
    void youCannotSetThePhoneNumberOfAnAccountThatDoesNotExist() throws Exception
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        provideInput("09987543155");
        String text = tapSystemOut(() -> {
            EditUserAccount.setPhoneNumber("Jeff");
        });
        assertTrue(text.contains("This account does not exist in our system. Therefore, there is no associated phone number for you to edit."));
    }

    @Test
    void youCannotSetThePhoneNumberOfAnAccountToBeItsCurrentPhoneNumber()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        UserStorage.addPairToMap(student);

        provideInput("07765347218");
        EditUserAccount.setPhoneNumber("James");

        assertTrue(Objects.equals(student.get_accNumber(), "07765347218")); // shows that the phone number has not changed
    }

    @Test
    void youCannotSetThePhoneNumberOfAnAccountIfItIsInvalid()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        UserStorage.addPairToMap(student);

        provideInput("0776534721877");
        EditUserAccount.setPhoneNumber("James");

        assertTrue(Objects.equals(student.get_accNumber(), "07765347218")); // shows that the phone number has not been changed
    }

    @Test
    void youCannotSetThePhoneNumberOfAnAccountThatExistsEvenIfItIsValidWhenYouAreNotLoggedIntoTheAccount()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        UserStorage.addPairToMap(student);

        provideInput("23668935421");
        EditUserAccount.setPhoneNumber("James");

        assertTrue(Objects.equals(student.get_accNumber(), "07765347218")); // shows that the phone number has not been changed
    }


    @Test
    void youCanSetThePhoneNumberOfAnAccountThatExistsIfItIsValidAndYouAreLoggedIntoTheAccount()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", true);
        UserStorage.addPairToMap(student);
        provideInput("23668935421");
        EditUserAccount.setPhoneNumber("James");

        assertTrue(Objects.equals(student.get_accNumber(), "23668935421")); // shows that the phone number has been successfully changed
    }

    @Test
    void youCannotSetThePasswordOfAnAccountThatDoesNotExist() throws Exception
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        provideInput("Bucket543!");
        String text = tapSystemOut(() -> {
            EditUserAccount.setPassword("Jeff");
        });
        assertTrue(text.contains("This account does not exist in our system. Therefore, there is no associated password for you to edit."));
    }

    @Test
    void youCannotSetThePasswordOfAnAccountToBeItsCurrentPassword()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        UserStorage.addPairToMap(student);

        provideInput("James123!");
        EditUserAccount.setPassword("James");

        assertTrue(Objects.equals(student.get_accPassword(), "James123!")); // shows that the password has not changed
    }

    @Test
    void youCannotSetThePasswordOfAnAccountIfItIsInvalid()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        UserStorage.addPairToMap(student);

        provideInput("Buck");
        EditUserAccount.setPassword("James");

        assertTrue(Objects.equals(student.get_accPassword(), "James123!")); // shows that the password has not been changed
    }

    @Test
    void youCannotSetThePasswordOfAnAccountThatExistsEvenIfItIsValidIfYouAreNotLoggedIntoTheAccount()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        UserStorage.addPairToMap(student);

        provideInput("Bucket543!");
        EditUserAccount.setPassword("James");

        assertTrue(Objects.equals(student.get_accPassword(), "James123!")); // shows that the password could not be changed
    }

    @Test
    void youCanSetThePasswordOfAnAccountThatExistsIfItIsValidAndYouAreLoggedIntoTheAccount()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", true);
        UserStorage.addPairToMap(student);

        provideInput("Bucket543!");
        EditUserAccount.setPassword("James");

        assertTrue(Objects.equals(student.get_accPassword(), "Bucket543!")); // shows that the password has been successfully changed
    }

    @Test
    void youCannotSetTheIDOfAnAccountThatDoesNotExist() throws Exception
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        provideInput("Student13");
        String text = tapSystemOut(() -> {
            EditUserAccount.setID("Jeff");
        });
        assertTrue(text.contains("This account does not exist in our system. Therefore, there is no associated ID for you to edit.")); // shows that the account does not exist in the system and the user is unable to change its ID
    }

    @Test
    void youCannotSetTheIDOfAnAccountToBeItsCurrentID()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        UserStorage.addPairToMap(student);

        provideInput("Student12");
        EditUserAccount.setID("James");

        assertTrue(Objects.equals(student.get_accID(), "Student12")); // shows that the ID has not changed
    }

    @Test
    void youCannotSetTheIDOfAnAccountIfItIsInvalid()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        UserStorage.addPairToMap(student);

        provideInput("-243");
        EditUserAccount.setID("James");

        assertTrue(Objects.equals(student.get_accID(), "Student12")); // shows that the ID has not been changed
    }

    @Test
    void youCannotSetTheIDOfAnAccountThatExistsEvenIfItIsValidIfYouAreNotLoggedIntoTheAccount()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", false);
        UserStorage.addPairToMap(student);

        provideInput("Student60");
        EditUserAccount.setID("James");

        assertTrue(Objects.equals(student.get_accID(), "Student12")); // shows that the ID could not be changed
    }

    @Test
    void youCanSetTheIDOfAnAccountThatExistsIfItIsValidAndYouAreLoggedIntoTheAccount()
    {
        UserAccount student = new StudentAccount("James", "07765347218", "James123!", "Student12", true);
        UserStorage.addPairToMap(student);

        provideInput("Student60");
        EditUserAccount.setID("James");

        assertTrue(Objects.equals(student.get_accID(), "Student60")); // shows that the ID has been successfully changed
    }

}