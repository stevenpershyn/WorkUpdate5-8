package com.quintrix.java.quintrixspring.restservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.quintrix.java.quintrixspring.models.agent.Agent;

@Component
public class AgentServiceImpl implements AgentService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${agentService.getURL}")
	String agentServiceGetUrl;
	
	@Override
	public List<Agent> getAgentList() {
		List<Agent> agentsList = null;
		ResponseEntity<List<Agent>> agentsListResponseEntity= 
			restTemplate.exchange(agentServiceGetUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Agent>>() {});
		
		if (agentsListResponseEntity.getStatusCode() == HttpStatus.OK) {
			agentsList = agentsListResponseEntity.getBody();
			
		}
		
		return agentsList;
	}
}
