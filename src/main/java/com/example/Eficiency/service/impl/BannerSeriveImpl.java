package com.example.Eficiency.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.Eficiency.mapper.BannerMapper;
import com.example.Eficiency.model.BannerBO;
import com.example.Eficiency.service.BannerSerive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BannerSeriveImpl implements BannerSerive {
    @Autowired
    BannerMapper bannerMapper;

    @Override
    public List<BannerBO> list() {
        List<BannerBO> list = bannerMapper.selectList(new QueryWrapper<BannerBO>());
        log.info("banner list" + list);
        return list;
    }
}
