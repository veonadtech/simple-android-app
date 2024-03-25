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
package org.prebid.veondemo.activities.ads.inapp

import android.os.Bundle
import android.widget.Button
import org.prebid.mobile.AdSize
import org.prebid.mobile.api.rendering.BannerView
import org.prebid.veondemo.R

class InAppDisplayBanner320x50Activity : org.prebid.veondemo.activities.BaseAdActivity() {

    companion object {
        const val CONFIG_ID = "prebid-ita-banner-320-50"
        const val WIDTH = 350
        const val HEIGHT = 200
    }

    private var adView: BannerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ShowBanner = findViewById(R.id.show_banner) as Button

        ShowBanner.setOnClickListener {
            createAd()
        }
    }

    private fun createAd() {
        adView = BannerView(
            this,
            CONFIG_ID,
            AdSize(WIDTH, HEIGHT)
        )

        adWrapperView.addView(adView)
        adView?.loadAd()
    }


    override fun onDestroy() {
        super.onDestroy()
        adView?.destroy()
    }

}
