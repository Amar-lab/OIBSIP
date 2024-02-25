package com.zohocrm.Services;

import java.util.List;

import com.zohocrm.Entities.Lead;

public interface LeadService {

public	void saveLead(Lead lead);

public Lead getLeadById(long id);

public void deleteById(long id);

public List<Lead> getAllLeads();

}
