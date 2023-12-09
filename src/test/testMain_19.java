package test;

import main.Main;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import sportfacility.*;
import user.Admin;

public class testMain_19 {
	// private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final InputStream originalIn = System.in;

	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String dateNtime = now.format(formatter);

	Admin admin = Admin.getInstance();

	public void setOutput(ByteArrayInputStream testIn, ByteArrayOutputStream outContent) {
		// Set up the output stream to capture the output
		System.setOut(new PrintStream(outContent));
		// Set up the input stream to simulate user input
		System.setIn(testIn);
	}

	public void getOutput() {
		// Restore the original output and input streams
		System.setOut(originalOut);
		System.setIn(originalIn);
	}

@Test
public void testMain_18() throws Exception {
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	setOutput(new ByteArrayInputStream(
			"2\nadmin\nAstralTrapez0idB0dy\n1\n1\n1\n2\n1\n3\n1\n4\n1\n5\n0\n1\nalice\nPassword123\n1\n1\n07-12-2023\n19\nCC\n3\n1\n0\n0\n0\n"
					.getBytes()),
			outContent);
	Main.main(new String[] {}); // Run the main method which should now use the simulated input

	String expectedOutput = ""

	// + ""
	;
	// Trim the captured output to avoid issues with trailing newlines
	String actualOutput = outContent.toString(); // .trim();

	// Replace all system-dependent newlines with \n for consistent comparison
	// actualOutput = actualOutput.replace(System.lineSeparator(), "\n");
	getOutput();
	expectedOutput = expectedOutput.replaceAll("\\s+", " ").trim();
	actualOutput = actualOutput.replaceAll("\\s+", " ").trim();

}

}
