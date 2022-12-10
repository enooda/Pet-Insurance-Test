package tests;

import base.TestBase;
import models.Cat;
import models.Dog;
import org.junit.Test;
import java.io.IOException;

public class PetInsuranceTest extends TestBase {

    @Test
    public void snowballTest() throws IOException {
        Cat SnowBall = new Cat("cat", "SnowBall", "F", "Bengal", "350",
                "04", "06", "2021", "N", "Y", "N", "Y");

        fillCatInfo(SnowBall);
        contactAmelia();
        fillLegalForm();
    }

    @Test
    public void laikaTest() throws IOException {
        Dog Laika = new Dog("dog", "Laika", "F", "Pedigree", "Alaskan Husky",
                "350", "04", "06", "2021", "N", "Y",
                "N", "Y", "Y", "N", "Y");

        fillDogInfo(Laika);
        contactCharlie();
        fillLegalForm();
    }

    @Test
    public void scoobyDooTest() throws IOException {
        Dog ScoobyDoo = new Dog("dog", "Scooby Doo", "M", "Pedigree",
                "Great Dane", "950", "18", "02", "2015", "Y",
                "N", "Y", "N", "N", "N", "N");

        fillDogInfo(ScoobyDoo);
        contactShaggy();
        fillLegalForm();
    }
}


