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

package net.boreeas.riotapi.rtmp.serialization.amf3;

import net.boreeas.riotapi.rtmp.serialization.AmfSerializer;
import net.boreeas.riotapi.rtmp.serialization.RangeException;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created on 5/3/2014.
 */
public enum Amf3IntegerSerializer implements AmfSerializer<Integer> {
    INSTANCE;

    @Override
    public void serialize(Integer val, DataOutputStream out) throws IOException {
        if (val > 536870911  || val < -268435456) {
            throw new RangeException(val);
        }

        int continueMarker = 1 << 7;
        int mask = 0x7f;
        val &= 0x1fffffff; // clear top 3 (unused) bits

        if (val < 0x80) {
            out.write(val);
        } else if (val < 0x4000) {
            out.write((val >> 7 & mask) | continueMarker);
            out.write(val & mask);
        } else if (val < 0x200000) {
            out.write((val >> 14 & mask) | continueMarker);
            out.write((val >>  7 & mask) | continueMarker);
            out.write(val & mask);
        } else {
            // if the number is this big, the last byte uses all 8 bits
            // so we shift one bit more for each previous byte
            out.write((val >> 22 & mask) | continueMarker);
            out.write((val >> 15 & mask) | continueMarker);
            out.write((val >>  8 & mask) | continueMarker);
            out.write(val & 0xff);
        }
    }
}
