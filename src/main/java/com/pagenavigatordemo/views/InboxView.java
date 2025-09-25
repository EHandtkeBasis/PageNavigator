package com.pagenavigatordemo.views;

import com.pagenavigatordemo.components.Explore;
import com.pagenavigatordemo.views.ContentLayout.SideMenuProvider;
import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/Inbox", outlet = ContentLayout.class)
@FrameTitle("Inbox")
public class InboxView extends Composite<FlexLayout> implements SideMenuProvider {
  private FlexLayout self = getBoundComponent();

  public InboxView() {
    self.setHeight("100%");
    self.setAlignment(FlexAlignment.CENTER);
    self.add(new Explore("Inbox"));
  }

  @Override
  public java.util.List<String> getSideMenuItems() {
    return java.util.Arrays.asList("Today", "Yesterday", "Earlier");
  }
}
