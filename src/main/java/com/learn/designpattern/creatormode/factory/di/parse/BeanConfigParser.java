package com.learn.designpattern.creatormode.factory.di.parse;

import java.io.InputStream;
import java.util.List;

/**
 * 配置文件解析接口
 *
 * @author lihzz
 * @version 1.0
 * @date 2022/9/26 23:39
 */
public interface BeanConfigParser {
    List parse(InputStream inputStream);

    List parse(String configContent);
}
