package com.pagenavigatordemo;

import com.webforj.App;
import com.webforj.annotation.AppProfile;
import com.webforj.annotation.Routify;
import com.webforj.annotation.StyleSheet;

@Routify(packages = "com.pagenavigatordemo.views")
@StyleSheet("ws://app.css")
@AppProfile(name = "PageNavigatorDemo", shortName = "PageNavigatorDemo")
public class Application extends App {
}
