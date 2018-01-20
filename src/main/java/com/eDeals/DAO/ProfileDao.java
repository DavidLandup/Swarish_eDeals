package com.eDeals.DAO;


import com.eDeals.Model.Profile;

import java.util.List;

public interface ProfileDao {
    void addProfile(Profile profile);
    void editProfile(Profile profile);
    Profile getProfileById(int profileId);
    List<Profile> getAllProfiles();
    Profile getProfileByUsername(String username);
}
