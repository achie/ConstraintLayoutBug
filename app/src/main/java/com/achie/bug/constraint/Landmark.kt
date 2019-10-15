package com.achie.bug.constraint

data class Landmark(val title: String,
                    val subtitle: String = "SUBTITLE: Some random text that goes over a line on a phone screen",
                    val description: String = "DESCRIPTION: a n y of the displayed image in this item that goes over a few lines. This is just some random text. When a device goes from just working to actually making life easier, Android is behind it. It’s the reason your GPS avoids traffic, your watch can text and your Assistant can answer questions. It’s the operating system inside 2.5 billion active devices. Everything from 5G phones to stunning tablets, Android powers them all.",
                    val imageResId: Int)