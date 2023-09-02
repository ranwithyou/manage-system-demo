package com.example.demo.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import com.sun.corba.se.spi.resolver.Resolver;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.Result;

import com.example.demo.service.ICourseService;
import com.example.demo.entity.Course;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author deng
 * @since 2023-08-27
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private ICourseService courseService;
    @Resource
    private IUserService userService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Course course) {
        courseService.saveOrUpdate(course);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        courseService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        courseService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(courseService.list());
    }

    @PostMapping("/studentCourse/{courseId}/{studentId}")
    public Result studentCourse(@PathVariable Integer courseId, @PathVariable Integer studentId) {
        courseService.setStudentCourse(courseId, studentId);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(courseService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam String  name) {
//        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");
//        return Result.success(courseService.page(new Page<>(pageNum, pageSize), queryWrapper));
        Page<Course> page = courseService.findPage(new Page<>(pageNum, pageSize), name);
        return Result.success(page);
    }

}

