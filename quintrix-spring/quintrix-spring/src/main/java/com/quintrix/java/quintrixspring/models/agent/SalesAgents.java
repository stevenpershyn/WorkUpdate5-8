
package com.quintrix.java.quintrixspring.models.agent;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesAgents {

    @JsonProperty("agentList")
    private List<Agent> agentList = null;

    @JsonProperty("agentList")
    public List<Agent> getAgentList() {
        return agentList;
    }

    @JsonProperty("agentList")
    public void setAgentList(List<Agent> agentList) {
        this.agentList = agentList;
    }

}
