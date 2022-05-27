package com.windlabs.springcorelabs.scheduler;

import com.windlabs.springcorelabs.util.HostFinderUtil;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class HealthScheduler {

  private HostFinderUtil hostFinderUtil;

  @Autowired
  public HealthScheduler(HostFinderUtil hostFinderUtil) {
  this.hostFinderUtil = hostFinderUtil;
  }

  @Scheduled (fixedDelayString ="${health.interval}" )
  private void healthCheck() {

    System.out.println("Checking health");
    System.out.println(hostFinderUtil.getHostName());
    System.out.println(hostFinderUtil.getIp());

  }

}
