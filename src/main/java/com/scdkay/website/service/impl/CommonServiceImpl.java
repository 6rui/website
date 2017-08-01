package com.scdkay.website.service.impl;

import com.scdkay.website.base.BaseService;
import com.scdkay.website.entity.FileEntity;
import com.scdkay.website.entity.ResultEntity;
import com.scdkay.website.repo.FileRepository;
import com.scdkay.website.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 公用业务层控制器实现类
 * Created by liurui on 2017/7/20.
 */
@Service
@Transactional
public class CommonServiceImpl extends BaseService implements CommonService {
    @Autowired
    private FileRepository fileRepository;

    @Override
    @Transactional
    public ResultEntity upload(Integer fileType, Integer isCover, HttpServletRequest request) {
        //存放文件路径的数组
        List<FileEntity> fileUrlList = new ArrayList<>();
        //获取当前的上下文对象
        ServletContext servletContext = request.getSession().getServletContext();
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(servletContext);
        //判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //取得request中的所有文件名
            Iterator<String> iterator = multiRequest.getFileNames();
            while (iterator.hasNext()) {
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iterator.next());
                if (file != null) {
                    //取得当前上传文件的文件名称
                    String fileName = file.getOriginalFilename();
                    LOGGER.info("获取到上传文件名称为：[" + fileName + "]");
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (!Objects.equals(fileName.trim(), "")) {
                        //定义上传路径
                        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HHmmss");
                        String[] strings = format.format(new Date()).split(" ");
                        String datePath = strings[0];
                        //重命名上传后的文件名
                        fileName = strings[1] + "_" + fileName;
                        String filePath = servletContext.getRealPath("/files/" + datePath);
                        LOGGER.info("文件上传的路径为：[" + filePath + "]");
                        String url = filePath + "/" + fileName;
                        url = url.replaceAll("\\\\", "/");
                        //新建本地空文件存放上传文件数据
                        File fileDir = new File(filePath);
                        if (!fileDir.exists()) {
                            if (!fileDir.mkdirs()) {
                                LOGGER.error("文件夹创建失败！");
                                continue;
                            }
                        }
                        File localFile = new File(filePath, fileName);
                        try {
                            file.transferTo(localFile);
                        } catch (IOException e) {
                            LOGGER.error("文件上传出错！", e);
                            continue;
                        }
                        FileEntity fileEntity = insertFileRecording(url, fileType, isCover);
                        fileUrlList.add(fileEntity);
                    }
                }
            }
        }
        return generateSucceedResult("文件上传成功", fileUrlList);
    }

    /**
     * 将上传信息插入文件表
     *
     * @param url      文件的url
     * @param fileType 文件用途的类型
     * @param isCover  是否为封面
     * @return 插入数据库为文件实体
     */
    private FileEntity insertFileRecording(String url, Integer fileType, Integer isCover) {
        FileEntity fileEntity = new FileEntity();
        if (null != isCover) {
            fileEntity.setIsCover(isCover);
        } else {
            fileEntity.setIsCover(0);
        }
        if (null != fileType) {
            fileEntity.setType(fileType);
        } else {
            fileEntity.setType(0); //默认设置为新闻类型图片
        }
        fileEntity.setUrl(url);
        fileRepository.save(fileEntity);
        return fileEntity;
    }
}
