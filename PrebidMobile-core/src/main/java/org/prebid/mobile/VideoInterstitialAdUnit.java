/*
 *    Copyright 2018-2019 Prebid.org, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.prebid.mobile;

import androidx.annotation.NonNull;

import org.prebid.mobile.api.data.AdFormat;
import org.prebid.mobile.rendering.models.AdPosition;
import org.prebid.mobile.rendering.models.PlacementType;

import java.util.EnumSet;

/**
 * @deprecated Use {@link InterstitialAdUnit} constructor with adUnitFormats parameter:
 * {@code EnumSet.of(AdUnitFormat.VIDEO);}
 */
@Deprecated
public class VideoInterstitialAdUnit extends VideoBaseAdUnit {

    public VideoInterstitialAdUnit(@NonNull String configId) {
        super(configId, EnumSet.of(AdFormat.VAST));
        configuration.setAdPosition(AdPosition.FULLSCREEN);
        configuration.setPlacementType(PlacementType.INTERSTITIAL);
    }

}