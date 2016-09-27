package P01_Brackets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BracketTesterTest {

    BracketTester bracketTester;
    String 	laTexBulletList;

    @Before
    public void SetUp(){
        bracketTester = new BracketTester();

    }

    @Test
    public void shouldRecognizeGreaterLessThenBrackets(){
        assertTrue(bracketTester.isCorrectlyParenthesised("<>"));
    }
    @Test
    public void shouldFailOnlyLessThanBrackets(){
        assertFalse(bracketTester.isCorrectlyParenthesised("<"));;
    }
    @Test
    public void shouldFailOnlyGreaterThanBrackets(){
        assertFalse(bracketTester.isCorrectlyParenthesised(">"));
    }

    @Test
    public void shouldRecognizeSquareBrackets(){
        assertTrue(bracketTester.isCorrectlyParenthesised("[]"));
    }
    @Test
    public void shouldFailOnlyOpeningSquareBrackets(){
        assertFalse(bracketTester.isCorrectlyParenthesised("["));
    }
    @Test
    public void shouldFailOnlyClosingSquareBrackets(){
        assertFalse(bracketTester.isCorrectlyParenthesised("]"));
    }

    @Test
    public void shouldRecognizeCurvedBrackets(){
        assertTrue(bracketTester.isCorrectlyParenthesised("()"));
    }
    @Test
    public void shouldFailOnlyOpeningCurvedBrackets(){
        assertFalse(bracketTester.isCorrectlyParenthesised("("));
    }
    @Test
    public void shouldFailOnlyClosingCurvedBrackets(){
        assertFalse(bracketTester.isCorrectlyParenthesised(")"));
    }

    @Test
    public void shouldRecognizeCurlyBrackets(){
        assertTrue(bracketTester.isCorrectlyParenthesised("{}"));
    }
    @Test
    public void shouldFailOnlyOpeningCurlyBrackets(){
        assertFalse(bracketTester.isCorrectlyParenthesised("{"));
    }
    @Test
    public void shouldFailOnlyClosingCurlyBrackets(){
        assertFalse(bracketTester.isCorrectlyParenthesised("}"));
    }

    @Test
    public void shouldAcceptEmptyStringWithoutBrackets(){
        assertTrue(bracketTester.isCorrectlyParenthesised(new String()));
    }

    @Test
    public void shouldAcceptStringWithoutBrackets(){
        assertTrue(bracketTester.isCorrectlyParenthesised("There are no Brackets!"));
    }

    @Test
    public void shouldFailBecuaseOfWrongGreaterLessThanBracketOrder(){
        assertFalse(bracketTester.isCorrectlyParenthesised(">´'`\\_(ò_Ó)_//´'`<"));
    }

    @Test
    public void shouldAcceptBracketCombination(){

        String laTexBulletList = "\\begin{itemize}" +
                "\\item The first item" +
                "\\item The \\Roman{enumi} item" +
                "\\item The third etc \\ldots" +
                "\\end{itemize}";

        assertTrue(bracketTester.isCorrectlyParenthesised("[<(3 + 3) • 35> + 3] • {3 +2}"));
        assertTrue(bracketTester.isCorrectlyParenthesised(laTexBulletList));
    }
}
