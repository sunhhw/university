package com.applets.university.trade.service.impl;

import com.applets.university.trade.entity.Image;
import com.applets.university.trade.mapper.ImageMapper;
import com.applets.university.trade.service.IImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shw
 * @since 2021-08-08
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements IImageService {

}
