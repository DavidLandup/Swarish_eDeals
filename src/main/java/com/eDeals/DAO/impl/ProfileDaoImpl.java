package com.eDeals.DAO.impl;

import com.eDeals.DAO.ProfileDao;
import com.eDeals.Model.Authorities;
import com.eDeals.Model.Profile;
import com.eDeals.Model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProfileDaoImpl implements ProfileDao {
    @Autowired
    SessionFactory sessionFactory;

    public  void addProfile(Profile profile) {
        Session session = sessionFactory.getCurrentSession();
        profile.setEnabled(true);
        session.saveOrUpdate(profile);

        User newUser = new User();
        newUser.setUsername(profile.getUsername());
        newUser.setPassword(profile.getPassword());
        newUser.setEnabled(true);
        newUser.setProfileId(profile.getProfileId());

        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(profile.getUsername());
        newAuthority.setAuthority("ROLE_USER");

        session.saveOrUpdate(profile);
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);


        session.flush();
    }

    public void editProfile(Profile profile) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(profile);
        session.flush();
    }
    public Profile getProfileById(int profileId) {

        Session session = sessionFactory.getCurrentSession();
        return (Profile) session.get(Profile.class, profileId);
    }
    public List<Profile> getAllProfiles() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Profile");
        List<Profile> profileList = query.list();

        return profileList;
    }
    public Profile getProfileByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Profile where username = ?");
        query.setString(0, username);

        return (Profile) query.uniqueResult();
    }
}
