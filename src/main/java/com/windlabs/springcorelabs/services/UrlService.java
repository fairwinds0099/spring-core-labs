package com.windlabs.springcorelabs.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

  @Value("${www.url}")
  private String url;

  @Autowired
  public UrlService() {}

  @Retryable (
      backoff = @Backoff(
          maxDelay = 10000l,
          multiplier = 2
      )
  )

  @Recover
  public void recoveringRetry() {
    System.out.println("attempted retry");
  }

  public  String readUrlContent() throws IOException {
    URL url = new URL(this.url);
    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
    System.out.println(connection.getResponseCode());
    System.out.println(connection.getResponseMessage());
    ObjectMapper mapper = new ObjectMapper();
    ObjectNode object = mapper.readValue(url, ObjectNode.class);

    return object.get("response").toPrettyString();
  }
}
