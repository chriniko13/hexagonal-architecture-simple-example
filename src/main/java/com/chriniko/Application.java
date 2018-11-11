package com.chriniko;

import com.chriniko.adapter.CommandLineLibraryInput;
import com.chriniko.adapter.InMemoryLibraryRepository;
import com.chriniko.application.LibraryInput;
import com.chriniko.application.LibraryRegistry;
import com.chriniko.application.LibraryRepository;

public class Application {

    public static void main(String[] args) {

        LibraryInput libraryInput = new CommandLineLibraryInput();
        LibraryRepository libraryRepository = new InMemoryLibraryRepository();

        LibraryRegistry libraryRegistry = new LibraryRegistry(libraryRepository, libraryInput);

        String result = libraryRegistry
                .searchByTitle()
                .map(t -> "Search Results: " + t)
                .orElse("No Search Results");

        System.out.println(result);

    }
}
