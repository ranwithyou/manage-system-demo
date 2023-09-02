package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author deng
 * @since 2023-08-18
 */

public interface UserMapper extends BaseMapper<User> {

    Page<User> findPage(Page<User> page, String username, String email, String address);
}

