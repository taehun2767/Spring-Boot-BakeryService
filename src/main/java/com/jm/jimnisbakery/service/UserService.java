package com.jm.jimnisbakery.service;

import com.jm.jimnisbakery.domain.users.User;
import com.jm.jimnisbakery.domain.users.UserRepository;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //TODO 유저 생성
    public User saveUser(User user){
        return userRepository.save(user);
    }
    //TODO 유저 세부사항 가져오기
    public User getUserById(Long userId){
        return userRepository.findById(userId).orElse(null);
    }
    //TODO 유저 주소 정보 가져오기
    public String getUserAddressById(Long userId){
        Optional<User> user =  userRepository.findById(userId);
        if(user.isPresent() == false)
            return null;

        return user.get().getAddress();
    }

    //TODO 비밀 번호 변경
    public User ChangeUserLoginToken(User user, String loginToken){
        //로그인 토큰으로 변환하는 로직 필요
        return user.changeLoginToken(loginToken);
    }

    //TODO 주소 변경
    public User changeUserAddress(User user, String address){
        return user.changeAddress(address);
    }

    //TODO 전화번호 변경
    public User changeUserPhoneNumber(User user, String phoneNumber){
        return user.changePhoneNumber(phoneNumber);
    }
}
