import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OlxCodingInterviewTest {

    @Test
    public void run() {

        char[][] kb = {{'1','2','3'},{'4','5','6'},{'7','8','9'},{'*','0','#'} };

        List<String> possiblePin = OlxCodingInterview.run(kb, "135");
        System.out.println(possiblePin);
        System.out.println(possiblePin.size());
    }
}