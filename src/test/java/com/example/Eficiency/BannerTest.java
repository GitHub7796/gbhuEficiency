package com.example.Eficiency;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.Eficiency.mapper.BannerMapper;
import com.example.Eficiency.model.BannerBO;
import com.example.Eficiency.service.BannerSerive;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = EficiencyApplication.class)//显示声明启动类
@Slf4j
public class BannerTest {
    @Autowired
    private BannerSerive bannerSerive;

    @Autowired
    private BannerMapper bannerMapper;

    @Test
    public void test() {
        List<BannerBO> list = bannerSerive.list();
        log.info(list.toString());
    }

    @Test
    public void selectById() {
        BannerBO bannerBO = bannerMapper.selectById(1);
        log.info(bannerBO.toString());
    }

    @Test
    public void selectBatchIds() {
        List<BannerBO> list = bannerMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        log.info(list.toString());
    }

    @Test
    public void selectOne() {
        BannerBO bannerBO = bannerMapper.selectOne(
                new QueryWrapper<BannerBO>().eq("id", 1)
        );
        //.eq("id",1) 相当于sql where id=1
        log.info(bannerBO.toString());
    }

    @Test
    public void selectCount() {
        //null 表示查找所有
        //也可用QueryWrapper查找满足条件的记录数
        int raw = bannerMapper.selectCount(null);
        log.info(String.valueOf(raw));
    }


    @Test
    public void insert() {
        //null 表示查找所有
        //也可用QueryWrapper查找满足条件的记录数
        BannerBO bannerBO =BannerBO.builder()
                .img("xxx")
                .url("xxx")
                .deleted(1)
                .weightXXX(1)
                .build();

        int raw = bannerMapper.insert(bannerBO);
        log.info(String.valueOf(raw));
        log.info(bannerBO.toString());
    }

    @Test
    public void select() {
        QueryWrapper<BannerBO> queryWrapper = new QueryWrapper<>();
        /**
         * ==>  Preparing: SELECT id AS bannerId,img,url,weight AS weightXXX,version,deleted FROM banner WHERE (url LIKE ? AND img NOT LIKE ?)
         * ==> Parameters: %bbb%(String), %ccc%(String)
         */
//        queryWrapper.like("url", "bbb");
//        queryWrapper.notLike("img", "ccc");
        /**
         * ==>  Preparing: SELECT id AS bannerId,img,url,weight AS weightXXX,version,deleted FROM banner WHERE (url LIKE ? AND img LIKE ?)
         * ==> Parameters: %bbb(String), ccc%(String)
         */
//        queryWrapper.likeLeft("url", "bbb");
//        queryWrapper.likeRight("img", "ccc");
        /**
         * ==>  Preparing: SELECT id AS bannerId,img,url,weight AS weightXXX,version,deleted FROM banner WHERE (img IS NULL AND url IN (?,?)) ORDER BY id DESC
         * ==> Parameters: aaa(String), bbb(String)
         */
        queryWrapper.isNull("img");
        queryWrapper.in("url", Arrays.asList("aaa", "bbb"));
        queryWrapper.orderByDesc("id");
        bannerMapper.selectList(queryWrapper);
    }
    @Test
    public void pageSelect() {
        //第一页，每页3条
        Page<BannerBO> page = new Page<>(2, 5);
        //null 查询所有记录，可以通过queryWrapper先进行条件查找
        IPage<BannerBO> ipage = bannerMapper.selectPage(page, null);
        System.out.println("总条数"+ipage.getTotal());
        System.out.println("总页数"+ipage.getPages());
        //获取当前数据
        System.out.println(ipage.getRecords().toString());
    }

    @Test
    public void select1() {
        bannerMapper.list1();
    }

    @Test
    public void cas() {
        BannerBO bannerBO = BannerBO.builder()
                .bannerId(1)
                .version(1)
                .url("111")
                .build();
        bannerMapper.updateById(bannerBO);
    }
}
