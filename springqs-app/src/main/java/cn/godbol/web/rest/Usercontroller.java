package cn.godbol.web.rest;

import cn.godbol.dto.UserDTO;
import cn.godbol.jwt.domain.User;
import cn.godbol.query.QueryParam;
import cn.godbol.service.api.CrudService;
import cn.godbol.service.mapper.UserMapper;
import cn.godbol.web.rest.impl.DefaultCrudController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by li on 17-2-20.
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class Usercontroller implements DefaultCrudController<User, Long, QueryParam, UserDTO> {

    private static final String currentURI = "/user/";

    @Inject
    private UserMapper userMapper;



//    @Override
//    public MyUserService getService() {
//        return this.myUserService;
//    }



    @Override
    public User DTOToEntity(UserDTO userDTO) {
        return userMapper.userDTOToUser(userDTO);
    }

    @Override
    public UserDTO entityToDTO(User user) {
        return userMapper.userToUserDTO(user);
    }

    @Override
    public String getCurrentURI() {
        return this.currentURI;
    }

    @Override
    public CrudService<User, Long> getService() {
        return null;
    }
}