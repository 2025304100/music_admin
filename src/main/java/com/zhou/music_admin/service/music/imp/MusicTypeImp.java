package com.zhou.music_admin.service.music.imp;

import com.zhou.music_admin.entity.mtypeBean.Mtype;
import com.zhou.music_admin.service.Resource;
import com.zhou.music_admin.service.ServletMapper;
import com.zhou.music_admin.service.music.MusicType;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 防空检测交给aop后置返回通知
 */
@Service
public class MusicTypeImp extends ServletMapper implements MusicType {
    @Override
    public List<Mtype> getAllMtype() {
        List<Mtype> mtypes = mtypeMapper.selectAll();
        return mtypes;
    }

    @Override
    public Mtype getOneMtype(Integer id) {
        Example example = new Example(Mtype.class);
        example.createCriteria().andEqualTo("id",id);
        Mtype mtype = mtypeMapper.selectOneByExample(example);
        return mtype;
    }

    @Override
    public Integer updateMtype(Mtype oldType,Mtype mtype) {
        if (oldType.toString().equals(mtype.toString())){
            return -2;
        }
        int i = mtypeMapper.updateByPrimaryKey(mtype);
        return i;
    }

    @Override
    public Integer insertMtype( Mtype mtype) {
        int i = mtypeMapper.insert(mtype);
        return i;
    }

    @Override
    public Integer deteleMtype(Integer key) {
        int i = mtypeMapper.deleteByPrimaryKey(key);
        return i;
    }
}
