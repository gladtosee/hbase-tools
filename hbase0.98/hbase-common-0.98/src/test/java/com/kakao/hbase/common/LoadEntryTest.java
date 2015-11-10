/*
 * Copyright 2015 Kakao Corporation
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

package com.kakao.hbase.common;

import org.junit.Assert;
import org.junit.Test;

public class LoadEntryTest {
    @Test
    public void testDataLocalityToString() throws Exception {
        Assert.assertEquals("100.00%", LoadEntry.DataLocality.toString(1.00001));
        Assert.assertEquals("-0.00%", LoadEntry.DataLocality.toString(-0.000001));
        Assert.assertEquals("-0.01%", LoadEntry.DataLocality.toString(-0.00005));
        Assert.assertEquals("0.01%", LoadEntry.DataLocality.toString(0.00005));
        Assert.assertEquals("100.00%", LoadEntry.DataLocality.toString(0.999999));
    }

    @Test
    public void testDataLocalityToRateString() throws Exception {
        Assert.assertEquals("5.00%/s", LoadEntry.DataLocality.toRateString(0.05, 1000));
        Assert.assertEquals("2.50%/s", LoadEntry.DataLocality.toRateString(0.05, 2000));
        Assert.assertEquals("0.03%/s", LoadEntry.DataLocality.toRateString(0.0005, 2000));
    }
}
