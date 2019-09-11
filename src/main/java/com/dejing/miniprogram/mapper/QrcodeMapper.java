package com.dejing.miniprogram.mapper;

import com.dejing.miniprogram.generator.Qrcode;
import com.dejing.miniprogram.generator.QrcodeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

//@Component
//@Mapper
public interface QrcodeMapper {
    long countByExample(QrcodeExample example);

    int deleteByExample(QrcodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Qrcode record);

    int insertSelective(Qrcode record);

    List<Qrcode> selectByExample(QrcodeExample example);

    Qrcode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Qrcode record, @Param("example") QrcodeExample example);

    int updateByExample(@Param("record") Qrcode record, @Param("example") QrcodeExample example);

    int updateByPrimaryKeySelective(Qrcode record);

    int updateByPrimaryKey(Qrcode record);
}