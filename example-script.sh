#!/usr/bin/java --source 11
public class ExampleScript {
	public static void main(String[] args) {
		for (int i=0; i < args.length; i++) {
			System.out.println(String.format("ARG %d: %s", i+1, args[i]));
		}
		if (args.length == 0) {
			System.out.println("No args given.");
		}
	}
}