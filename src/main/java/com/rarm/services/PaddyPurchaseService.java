package com.rarm.services;

import java.util.List;

import com.rarm.model.PaddyPurchase;

public interface PaddyPurchaseService {

	PaddyPurchase save(PaddyPurchase paddyPurchase);

	List<PaddyPurchase> findAllPaddyPurchase();

}
