package com.segment.analytics;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class InstanceIdService extends FirebaseInstanceIdService {
  protected Analytics getAnalytics() {
    return Analytics.with(this);
  }

  @Override public void onTokenRefresh() {
    super.onTokenRefresh();

    getAnalytics().registerPushToken();
  }
}
