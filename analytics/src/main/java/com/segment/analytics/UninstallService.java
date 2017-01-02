package com.segment.analytics;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.segment.analytics.integrations.Logger;

public class UninstallService extends FirebaseMessagingService {
  protected Analytics getAnalytics() {
    return Analytics.with(this);
  }

  @Override public void onMessageReceived(RemoteMessage remoteMessage) {
    super.onMessageReceived(remoteMessage);

    Analytics analytics = getAnalytics();

    Logger logger = analytics.getLogger();

    // TODO: Handle FCM messages here.
    // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
    logger.debug("From: %s", remoteMessage.getFrom());

    // Check if message contains a data payload.
    if (remoteMessage.getData().size() > 0) {
      logger.debug("Message data payload: ", remoteMessage.getData());
    }

    // Check if message contains a notification payload.
    if (remoteMessage.getNotification() != null) {
      logger.debug("Message data payload: ", remoteMessage.getNotification().getBody());
    }
  }
}
