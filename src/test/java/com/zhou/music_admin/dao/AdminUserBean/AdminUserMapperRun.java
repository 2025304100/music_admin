package com.zhou.music_admin.dao.AdminUserBean;

import com.zhou.music_admin.entity.adminUserBean.AdminUser;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.common.Mapper;

import java.util.StringJoiner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AdminUserMapperRun{
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(",", "roles[root,", "]");
        stringJoiner.add("user");
        stringJoiner.add("edd");
        System.out.println(" StringJoiner stringJoiner = new StringJoiner(\",\", \"roles[root,\", \"]\");\n" +
                "        stringJoiner.add(\"user\");\n" +
                "        stringJoiner.add(\"edd\");的结果如下");
        System.out.println(stringJoiner);
    }

}