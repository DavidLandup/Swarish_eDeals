package com.eDeals.Service.impl;

import com.eDeals.DAO.ProfileDao;
import com.eDeals.Model.Profile;
import com.eDeals.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileDao profileDao;

    public void addProfile(Profile profile) {
        profileDao.addProfile(profile);
    }

    public void editProfile(Profile profile) {
        profileDao.editProfile(profile);
    }

    public Profile getProfileById(int profileId) {
        return profileDao.getProfileById(profileId);
    }

    public List<Profile> getAllProfiles() {
        return profileDao.getAllProfiles();
    }

    public Profile getProfileByUsername(String username) {
        return profileDao.getProfileByUsername(username);
    }

}
