package com.example.Eficiency.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

/**
 * `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
 * `img` varchar(524) DEFAULT NULL COMMENT '图片',
 * `url` varchar(524) DEFAULT NULL COMMENT '跳转地址',
 * `weight` int(11) DEFAULT NULL COMMENT '权重',
 * `version` int(11) DEFAULT '1',
 * `deleted` int(11) DEFAULT '0' COMMENT '0是未删除，1是已经删除',
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("banner")//对应相关的表名
@Builder
public class BannerBO {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer bannerId;
    private String img;
    private String url;
    @TableField(value = "weight")
    private Integer weightXXX;
    @Version
    private Integer version;
    @TableLogic
    private Integer deleted;
    private Data data;
}
