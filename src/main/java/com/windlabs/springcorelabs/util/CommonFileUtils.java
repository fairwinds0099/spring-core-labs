package com.windlabs.springcorelabs.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Component;
import org.apache.commons.io.FileUtils;

@Component
public class CommonFileUtils {

  public void writeInFile(String fileName, String text) throws IOException {
    File file = new File(fileName);
    FileUtils.writeStringToFile(file, text, StandardCharsets.US_ASCII);
  }
}
