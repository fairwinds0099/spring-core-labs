package com.windlabs.springcorelabs.scheduler;

import com.windlabs.springcorelabs.services.UrlService;
import com.windlabs.springcorelabs.util.CommonFileUtils;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class MainScheduledExecutor {

  private UrlService urlService;
  private CommonFileUtils commonFileUtils;

  @Autowired
  public MainScheduledExecutor(UrlService urlService, CommonFileUtils commonFileUtils){
  this.urlService = urlService;
  this.commonFileUtils = commonFileUtils;
  }

  @Scheduled (fixedDelayString ="${health.interval}" )
  public void mainScheduler() throws IOException {
    String retrieved = urlService.readUrlContent();
    commonFileUtils.writeInFile("src/main/resources/targetFile", retrieved);
  }

}


