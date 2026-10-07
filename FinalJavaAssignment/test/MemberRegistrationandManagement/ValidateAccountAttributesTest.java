package MemberRegistrationandManagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateAccountAttributesTest {

    @Test
    void nameCannotBeLessThanTwoCharactersLong()
    {
        assertFalse(ValidateAccountAttributes.nameValidation("w"));
    }

    @Test
    void nameCannotContainAnyNumbers()
    {
        assertFalse(ValidateAccountAttributes.nameValidation("Lucas12"));
    }

    @Test
    void nameCannotContainAnySpecialCharacters()
    {
        assertFalse(ValidateAccountAttributes.nameValidation("Lucas!"));
    }

    @Test
    void ValidName()
    {
        assertTrue(ValidateAccountAttributes.nameValidation("Wu"));
    }

    @Test
    void phoneNumberCannotBeLessThanElevenDigitsLong()
    {
        assertFalse(ValidateAccountAttributes.phoneNumberValidation("0778310577"));
    }

    @Test
    void phoneNumberCannotBeLongerThanElevenDigits()
    {
        assertFalse(ValidateAccountAttributes.phoneNumberValidation("077831057742"));
    }

    @Test
    void phoneNumberCannotContainAnyCharacters()
    {
        assertFalse(ValidateAccountAttributes.phoneNumberValidation("baba"));
    }

    @Test
    void phoneNumberCannotContainAnySpecialCharacters()
    {
        assertFalse(ValidateAccountAttributes.phoneNumberValidation("07783105774!!!!"));
    }

    @Test
    void validPhoneNumber()
    {
        assertTrue(ValidateAccountAttributes.phoneNumberValidation("07783105774"));
    }

    @Test
    void passwordMustBeAtLeastEightCharactersLong()
    {
        assertFalse(ValidateAccountAttributes.passwordValidation("bucket"));
    }

    @Test
    void passwordMustContainAtLeastOneUpperCaseCharacter()
    {
        assertFalse(ValidateAccountAttributes.passwordValidation("bucket543!"));
    }

    @Test
    void passwordMustContainAtLeastOneLowerCaseCharacter()
    {
        assertFalse(ValidateAccountAttributes.passwordValidation("BUCKET543!"));
    }

    @Test
    void passwordMustContainAtLeastOneDigit()
    {
        assertFalse(ValidateAccountAttributes.passwordValidation("Bucketbuck!"));
    }

    @Test
    void passwordMustContainAtLeastOneSpecialCharacter()
    {
        assertFalse(ValidateAccountAttributes.passwordValidation("Bucketbuck1"));
    }


    @Test
    void validPassword()
    {
        assertTrue(ValidateAccountAttributes.passwordValidation("BucketBucket123!"));
    }

    @Test
    void IDCannotContainAnySpecialCharacters()
    {
        assertFalse(ValidateAccountAttributes.validateID("-1234"));
        assertFalse(ValidateAccountAttributes.validateID("123456!!!"));
    }

    @Test
    void validID()
    {
        assertTrue(ValidateAccountAttributes.validateID("Student56"));
    }
}