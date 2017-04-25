package lk.harshana.config;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduleTask {

	private static final Logger log = LoggerFactory.getLogger(ScheduleTask.class);
	
	@Scheduled(fixedRate = 5000)
	public void runScheduleTask() {
		
		RestTemplate rest = new RestTemplate();
		log.info("LOG : " + new Date() + rest.getForObject("http://localhost:8080/greeting", String.class));
	}
}
