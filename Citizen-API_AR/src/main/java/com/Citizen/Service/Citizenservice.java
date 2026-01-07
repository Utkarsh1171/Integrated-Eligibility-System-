package com.Citizen.Service;

import java.util.List;

import com.Citizen.Controller.CitizenApplicationController;
import com.Citizen.Dto.CitizenDto;
import com.Citizen.Entity.CitizenApplication;

public interface Citizenservice {
	public boolean createApplication(CitizenDto citizenDto);
	public CitizenApplication getApp(Integer appNum);
	public List<CitizenApplication> getApps();
	public CitizenApplication getAppWithCitizenId(Integer citizenId);
}
