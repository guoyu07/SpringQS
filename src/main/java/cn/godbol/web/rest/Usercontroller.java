package cn.godbol.web.rest;

import cn.godbol.common.controller.api.DefaultFindController;
import cn.godbol.common.controller.api.DefaultSaveController;
import cn.godbol.common.controller.api.SaveController;
import cn.godbol.common.query.QueryParam;
import cn.godbol.common.service.api.DefaultCrudService;
import cn.godbol.domain.User;
import cn.godbol.service.MyUserService;
import cn.godbol.service.dto.UserDTO;
import cn.godbol.service.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by li on 17-2-20.
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class Usercontroller implements DefaultFindController<User, Long, QueryParam>, DefaultSaveController<User, Long, UserDTO> {

    @Inject
    private UserMapper userMapper;

    @Inject
    private MyUserService myUserService;


//    @Override
//    public MyUserService getService() {
//        return this.myUserService;
//    }

    @Override
    @GetMapping
    public ResponseEntity findAll(QueryParam param) {
        return ResponseEntity.ok(((Page<User>)DefaultFindController.super.findAll(param).getBody())
                .map(userMapper::userToUserDTO));
    }

    @Override
    public DefaultCrudService<User, Long> getService() {
        return myUserService;
    }

    @Override
    public User DTOToEntity(UserDTO userDTO) {
        return userMapper.userDTOToUser(userDTO);
    }

    @Override
    public UserDTO entityToDTO(User user) {
        return userMapper.userToUserDTO(user);
    }

}
