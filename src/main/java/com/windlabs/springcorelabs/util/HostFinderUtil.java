package com.windlabs.springcorelabs.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class HostFinderUtil {

  InetAddress env= null;
  public HostFinderUtil(){}

  public String getHostName() {
    return this.env.getHostName();
  }

  public String getIp() {
    return env.getHostAddress();
  }

  @PostConstruct
  public void init() {
    try {
      this.env = InetAddress.getLocalHost();
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }
}
