package com.tandon.java;

import java.io.BufferedReader;
import java.util.*;

public class FileReader {

	public List<String> read(String filePath) {
		List<String> lines = new ArrayList();

		try {
			java.io.FileReader reader = new java.io.FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String aLine;
			while( (aLine =  bufferedReader.readLine()) != null) {
				lines.add(aLine);
			}
		} catch (Exception ex) {
			ex.printStackTrace();;
		}

		return lines;
	}

	public static void main(String[] args) {
		FileReader fileReader = new FileReader();
		String filePath = "/home/berkha/Desktop/dictionary.txt";
		List<String> lines = fileReader.read(filePath);

		for(String line: lines) {
			System.out.println(String.format("line >> (%s)",line));
		}

	}

}
