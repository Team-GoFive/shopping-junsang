package com.kt.shopping.integration.slack;

import com.kt.common.profile.DevProfile;
import org.springframework.stereotype.Component;

@Component
@DevProfile
public class DevNotifyApi implements NotifyApi {
	@Override
	public void notify(String message) {
		// 디스코드로 보내는 어떤 구현체
	}
}
