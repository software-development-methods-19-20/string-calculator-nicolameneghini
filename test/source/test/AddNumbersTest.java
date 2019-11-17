package test;

import dssc.calculator.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class AddNumbersTest {

    @Test
    void emptyString(){
        assertThat(StringCalculator.add(""), is(0));
    }

    @Test
    void oneNumber(){
        assertThat(StringCalculator.add("1"), is(1));
    }

    @Test
    void twoNumbers(){
        assertThat(StringCalculator.add("1,2"), is(3));
    }

    @Test
    void nineNumbers(){
        assertThat(StringCalculator.add("1,2,3,4,5,6,7,8,9"), is(45));
    }

    @Test
    void newLines(){ assertThat(StringCalculator.add("1\n2,10"), is(13));}

    @Test
    void newDelimeters(){ assertThat(StringCalculator.add("//;\\n1;2"), is(3));}

    @Test
    void noNegativeAccepted(){
        try{
            StringCalculator.add("-1,2,3");
            fail("Exception expected");
        } catch (RuntimeException ex){

        }
    }


    @Test
    void filterGreatherThan1001(){ assertThat(StringCalculator.add("//;\\n1;1001"), is(1));}

    @Test
    void newDelimeters1(){ assertThat(StringCalculator.add("//[:::]\\n1:::20:::3"), is(24));}

    @Test
    void newDelimeters2(){ assertThat(StringCalculator.add("//[:][°]\\n1:2°3"), is(6));}

}
