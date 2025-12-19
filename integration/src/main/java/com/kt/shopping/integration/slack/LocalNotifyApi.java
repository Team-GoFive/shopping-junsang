package com.kt.shopping.integration.slack;

import com.kt.common.profile.LocalProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@LocalProfile
public class LocalNotifyApi implements NotifyApi {
	@Override
	public void notify(String message) {
		log.info(message);
	}
}
