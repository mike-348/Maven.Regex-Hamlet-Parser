import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        //given
        String input = "The Tragedy of Hamlet, Prince of Denmark";
        String expected = "The Tragedy of Leon, Prince of Denmark";

        //when
        String actual = hamletParser.replaceHamletWithLeon(input);

        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //given
        String input = "Thou art a scholar; speak to it, Horatio.";
        String expected = "Thou art a scholar; speak to it, Tariq.";

        //when
        String actual = hamletParser.replaceHoratioWithTariq(input);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHamletToLeonUppercase() {
        //given
        String input = "Enter HAMLET";
        String expected = "Enter LEON";

        //when
        String actual = hamletParser.replaceHamletWithLeon(input);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToLeonUppercase() {
        //given
        String input = "Enter HORATIO, MARCELLUS, and BERNARDO";
        String expected = "Enter TARIQ, MARCELLUS, and BERNARDO";

        //when
        String actual = hamletParser.replaceHoratioWithTariq(input);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        //given
        String input = "Enter HORATIO, MARCELLUS, and BERNARDO";
        int expected = 2;

        //when
        int actual = hamletParser.findHoratio(input);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        //given
        String input = "The Tragedy of Hamlet, Prince of Denmark";
        int expected = 1;

        //when
        int actual = hamletParser.findHamlet(input);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReplaceAllHamlet() {
        //given
        String input = hamletText;
        int expected = -1;

        //when
        String alteredText = hamletParser.replaceHamletWithLeon(input);
        int actual = hamletParser.findHamlet(alteredText);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReplaceAllHoratio() {
        //given
        String input = hamletText;
        int expected = -1;

        //when
        String alteredText = hamletParser.replaceHoratioWithTariq(input);
        int actual = hamletParser.findHoratio(alteredText);

        //then
        Assert.assertEquals(expected, actual);
    }
}