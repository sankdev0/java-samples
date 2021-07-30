package com.sankdev.errorprocessing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResourcesProgram {

	public static void main(String[] args) {

		try {
			writeFile(new BufferedWriter(new FileWriter("Easy TryWithResourses")), "This is easy since Java 9");
		} catch (IOException exc) {
			System.out.println(exc);
		}
	}
	
	public static void writeFile(BufferedWriter writer, String text) {
		// new feature - no need to declare a final variable writer
		try(writer) {
			writer.write(text);
		} catch (IOException exc) {
			System.out.println(exc);
		}
	}

}
