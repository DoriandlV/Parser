package com;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Parser {

  public List<String> parse(String filePath) throws IOException{

      List<String> result;

      Stream<Path> walk = Files.walk(Paths.get(filePath));

      result = walk.filter(p -> !Files.isDirectory(p))
              .map(p -> p.toString().toLowerCase())
              .filter(f -> f.endsWith("json"))
              .collect(Collectors.toList());
            System.out.println(result);

      return result;
  }
}