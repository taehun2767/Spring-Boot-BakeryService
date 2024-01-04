package com.jm.jimnisbakery.domain.users.service;

import com.jm.jimnisbakery.domain.users.domain.User;
import com.jm.jimnisbakery.domain.users.dao.UserRepository;
import com.jm.jimnisbakery.global.common.ApiResult;
import com.jm.jimnisbakery.global.common.StatusType;
import com.jm.jimnisbakery.domain.users.dto.UserDto;
import com.jm.jimnisbakery.domain.users.dto.CreateUserRequest;
import com.jm.jimnisbakery.domain.users.dto.UpdateUserRequest;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public ApiResult<UserDto> createUser(CreateUserRequest req){
        User user = User.builder()
                .name(req.getName())
                .loginToken(req.getLoginToken())
                .email(req.getEmail())
                .snsId(req.getSnsId())
                .phoneNumber(req.getPhoneNumber())
                .address(req.getAddress())
                .build();

        User insertedUser = saveUser(user);
        if(insertedUser.getId() <= 0)
            return ApiResult.Failed(StatusType.FAIL);

        return ApiResult.Succeed(new UserDto(insertedUser));
    }

    //TODO 유저 생성
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public ApiResult<UserDto> getUserDetails(Long userId){
        User user = getUserById(userId);
        if(user == null)
            return ApiResult.Failed(StatusType.NOT_FOUND_USER);

        return ApiResult.Succeed(new UserDto(user));
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

    public ApiResult<UserDto> updateUser(UpdateUserRequest req){
        User user = getUserById(req.getUserId());
        if(user == null)
            return ApiResult.Failed(StatusType.NOT_FOUND_USER);

        if(req.getName() != null)
            user.setName(req.getName());
        if(req.getLoginToken() != null)
            user.setLoginToken(req.getLoginToken());
        if(req.getEmail() != null)
            user.setEmail(req.getEmail());
        if(req.getPhoneNumber() != null)
            user.setPhoneNumber(req.getPhoneNumber());
        if(req.getAddress() != null)
            user.setAddress(req.getAddress());

        User updatedUser = saveUser(user);
        if(updatedUser.getId() <= 0)
            return ApiResult.Failed(StatusType.FAIL);

        return ApiResult.Succeed(new UserDto(updatedUser));
    }
    public int deleteUser(Long userId){
        try{
            User user = getUserById(userId);
            if(user == null)
                return StatusType.NOT_FOUND_USER;
            userRepository.deleteById(userId);
            return StatusType.SUCCESS;
        }
        catch (Exception e){
            logger.error("delete user is failed" + e.getMessage(), e);
            return StatusType.FAIL;
        }
    }
}
