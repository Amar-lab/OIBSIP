package com.zohocrm.Services;

import java.util.List;

import com.zohocrm.Entities.Billing;

public interface BillingService {

public	void saveBill(Billing bill);

public List<Billing> getAllBills();

}
