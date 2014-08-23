/*
 * Copyright 2014 The LolDevs team (https://github.com/loldevs)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.boreeas.riotapi.com.riotgames.platform.game;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.boreeas.riotapi.rtmp.serialization.Serialization;

import java.util.ArrayList;

/**
 * Created on 7/19/2014.
 */
@Getter
@Setter
@ToString
@Serialization(name = "com.riotgames.platform.game.PlayerParticipant")
public class PlayerParticipant extends GameParticipant {
    private int profileIconId;
    private int summonerLevel;
    private long accountId;
    private boolean clientInSynch;
    private long summonerId;
    // TODO inspect (generic type)
    private ArrayList lifetimeStatistics = new ArrayList<>();

    /*

    According to the client files, those fields don't exists anymore

    // TODO inspect
    private Object timeAddedToQueue;
    private int index;
    private int queueRating;
    private String botDifficulty;
    private long originalAccountNumber;
    private boolean minor;
    // TODO inspect
    private Object locale;
    private int lastSelectedSkinIndex;
    private String partnerId;
    private boolean teamOwner;
    private String originalPlatformId;
    // TODO inspect
    private Object teamParticipantId;
    private PointSummary pointSummary;
    */
}
