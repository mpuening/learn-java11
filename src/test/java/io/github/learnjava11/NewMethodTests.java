package io.github.learnjava11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class NewMethodTests {

	@Test
	public void testToArrayMethod() {
		Set<String> set = new TreeSet<String>(Set.of("A", "B", "C"));

		String[] array = set.toArray(String[]::new);
		assertEquals("A", array[0]);
		assertEquals("B", array[1]);
		assertEquals("C", array[2]);
	}

	@Test
	public void testReadFileIntoStringAndParse() throws IOException {
		String content = Files.readString(Path.of("src/test/resources/file.txt"));
		content.lines().forEach(line -> {
			assertTrue(line.startsWith("This is line"));
		});
	}
}
