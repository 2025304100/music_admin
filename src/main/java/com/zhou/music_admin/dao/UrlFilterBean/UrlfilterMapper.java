package com.zhou.music_admin.dao.UrlFilterBean;

import com.zhou.music_admin.entity.UrlFilterBean.UrlAuthorizationBean;
import com.zhou.music_admin.entity.UrlFilterBean.Urlfilter;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UrlfilterMapper extends Mapper<Urlfilter> {

    List<UrlAuthorizationBean> getAuthorization(String key);

    List<UrlAuthorizationBean> getUrlTitle();
}