package net.boreeas.riotapi.rest;

import lombok.Getter;

import java.util.List;

/**
 * Created on 4/14/2014.
 */
@Getter
public class TeamStatSummary {
    private String fullId;
    private List<TeamStatDetails> teamStatDetails;
}
