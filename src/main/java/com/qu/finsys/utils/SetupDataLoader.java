package com.qu.finsys.utils;

import com.qu.finsys.entities.Privilege;
import com.qu.finsys.entities.Role;
import com.qu.finsys.entities.User;
import com.qu.finsys.generalLedger.entities.GlCurrency;
import com.qu.finsys.generalLedger.repositories.GlCurrencyRatesRepository;
import com.qu.finsys.generalLedger.repositories.GlCurrencyRepository;
import com.qu.finsys.repositories.PrivilegeRepository;
import com.qu.finsys.repositories.RoleRepository;
import com.qu.finsys.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.*;

@Component
@RequiredArgsConstructor
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    private final GlCurrencyRepository currencyRepository;
    private final GlCurrencyRatesRepository currencyRatesRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {



        GlCurrency currencyIls = new GlCurrency("شيكل", "ILS",  "ils", "اغورة", "", false, 0.0, 0.0, true);
        GlCurrency currencyJod = new GlCurrency("دينار", "JOD",  "jod", "فلس", "", true, 0.0, 0.0, true);
        GlCurrency currencyUsd = new GlCurrency("دولار", "USD",  "usd", "", "", false, 0.0, 0.0, true);
        GlCurrency currencyEuro = new GlCurrency("يورو", "EURO",  "euro", "", "", false, 0.0, 0.0, true);

        currencyRepository.save(currencyIls);
        currencyRepository.save(currencyJod);
        currencyRepository.save(currencyUsd);
        currencyRepository.save(currencyEuro);

       // if (alreadySetup)
         //   return;
        Privilege readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");

        if(!userRepository.findByEmail("test@test.com").isPresent()){
            User user = new User();
            user.setFirstName("Test");
            user.setLastName("Test");
            user.setPassword(passwordEncoder.encode("test"));
            user.setEmail("test@test.com");
            user.setRoles(Collections.singleton(adminRole));
            user.setEnabled(true);
            userRepository.save(user);
        }


        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
           // role.setPrivileges((Set<Privilege>) privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
