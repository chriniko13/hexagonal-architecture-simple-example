package com.chriniko.adapter;

import com.chriniko.application.LibraryInput;
import com.chriniko.doc.Adapter;

import java.util.Scanner;

@Adapter
public class CommandLineLibraryInput implements LibraryInput {

    private final Scanner scanner;

    public CommandLineLibraryInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getTitle() {
        return scanner.nextLine();
    }
}
