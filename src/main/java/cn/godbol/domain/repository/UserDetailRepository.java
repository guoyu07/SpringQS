package cn.godbol.domain.repository;

import cn.godbol.domain.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Li on 2016/10/15.
 */
@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
}
