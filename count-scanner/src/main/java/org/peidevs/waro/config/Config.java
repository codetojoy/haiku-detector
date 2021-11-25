package org.peidevs.waro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class Config {
    // -----------------------------------
    // configure these as desired
    private static final int NUM_CARDS = 12;
    private static final int MAX_CARD = NUM_CARDS;
    private static final int NUM_GAMES = 1;
    private static final boolean IS_VERBOSE = true;

    @Bean public int numCards() { return NUM_CARDS; }
    @Bean public int numGames() { return NUM_GAMES; }
    @Bean public boolean isVerbose() { return IS_VERBOSE; }

    protected static final String BEAN_NUM_PLAYERS = "numPlayers";
    protected static final String BEAN_NUM_CARDS = "numCards";
    protected static final String BEAN_NUM_GAMES = "numGames";
    protected static final String BEAN_IS_VERBOSE = "isVerbose";
    protected static final String BEAN_PLAYERS = "players";
}
