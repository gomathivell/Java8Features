package com.test.Java8Features;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Java8Features {

	public static void main(String[] args) throws IOException {

		//String.join
		String Joined = String.join("/", "user","local","bin");
		String JoinedOne = String.join(":", "user","local","bin");
		System.out.println(Joined);
		System.out.println(JoinedOne);
		
		
		//Write into file
		
		Path path = Paths.get("C:\\Gomathi\\WorkSpace\\HandsOn\\Java8Features\\test.txt");
		
		try (BufferedWriter write = Files.newBufferedWriter(path)) {
			write.write("Hellow World !!!");
		}
		
		//Second way of writing into file
		String content = "Hello World !! how do you do";
		Files.write(path, content.getBytes());
		
		//File read
		Path pathFile = Paths.get("C:\\Gomathi\\WorkSpace\\HandsOn\\Java8Features\\test.txt");
		
		try(Stream<String> lines = Files.lines(pathFile)) {
			lines.forEach(System.out::println);
			
			
		}
		
		
		
	}

}
