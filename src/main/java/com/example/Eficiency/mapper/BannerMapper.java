package com.example.Eficiency.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.Eficiency.model.BannerBO;

import java.util.List;

public interface BannerMapper extends BaseMapper<BannerBO> {

    List<BannerBO> list1();
}
