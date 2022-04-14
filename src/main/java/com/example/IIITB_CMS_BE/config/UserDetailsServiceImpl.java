package com.example.IIITB_CMS_BE.config;

import com.example.IIITB_CMS_BE.beans.EmpDetails;
import com.example.IIITB_CMS_BE.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmpRepo empRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmpDetails empDetails=empRepo.findByName(username);
        if(empDetails==null){
            throw new UsernameNotFoundException("No User Found!!");
        }
        CustomUserDetails customUserDetails=new CustomUserDetails(empDetails);
        return customUserDetails;
    }
}
