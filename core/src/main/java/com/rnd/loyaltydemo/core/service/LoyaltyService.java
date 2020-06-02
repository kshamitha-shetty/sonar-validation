package com.rnd.loyaltydemo.core.service;

import com.rnd.loyaltydemo.core.bo.*;
import com.rnd.loyaltydemo.core.config.ContextAwareConfig;

public interface LoyaltyService {

	AccessTokenResponse login(String username, String password, ContextAwareConfig config);
	ReferralCode getUserReffralCode(String profileId, String accessToken, ContextAwareConfig config);
	PointBalanceResponse getProfilePointBalance(final String profileId, final String accesToken,
            final ContextAwareConfig config);
	LoyaltyProfile getProfile(String accesToken, String profileId, ContextAwareConfig config);
	PointsSummaryResponse getProfilePointSummary(String loyaltyProfileID, String accesToken,
												  ContextAwareConfig config);
	ActivityByIdResponse getProfileOrderById(String transactionId, String profileId, String accessToken,
                                             ContextAwareConfig contextAwareConfig);
	ActivityByIdResponse getProfileTransactionsById(String transactionId, String profileId, String accessToken,
                                                    ContextAwareConfig contextAwareConfig);
}
