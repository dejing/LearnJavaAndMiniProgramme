package com.dejing.miniprogram.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dejing.miniprogram.generator.Qrcode;
import com.dejing.miniprogram.generator.User;
import com.dejing.miniprogram.mapper.QrcodeMapper;
import com.dejing.miniprogram.mapper.UserMapper;
import com.dejing.miniprogram.utils.GlobalResult;
import com.dejing.miniprogram.utils.WechatUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@RestController
public class UserController {

  @Resource
  private UserMapper userMapper;

  @Resource
  private QrcodeMapper qrCodeMapper;

  /** 微信用户登录详情 */
  @PostMapping("wx/login")
  @ResponseBody
  public GlobalResult user_login(
      @RequestParam(value = "code", required = false) String code,
      @RequestParam(value = "rawData", required = false) String rawData,
      @RequestParam(value = "signature", required = false) String signature,
      @RequestParam(value = "encrypteData", required = false) String encrypteData,
      @RequestParam(value = "iv", required = false) String iv) {
    if (code == null) {
      GlobalResult result = GlobalResult.build(500, "Code is null", null);
      return result;
    }

    // 用户非敏感信息：rawData
    // 签名：signature
    JSONObject rawDataJson = JSON.parseObject(rawData);
    // 1.接收小程序发送的code
    // 2.开发者服务器 登录凭证校验接口 appi + appsecret + code
    JSONObject SessionKeyOpenId = WechatUtil.getSessionKeyOrOpenId(code);
    // 3.接收微信接口服务 获取返回的参数
    String openid = SessionKeyOpenId.getString("openid");
    String sessionKey = SessionKeyOpenId.getString("session_key");

    // 4.校验签名 小程序发送的签名signature与服务器端生成的签名signature2 = sha1(rawData + sessionKey)
    String signature2 = DigestUtils.sha1Hex(rawData + sessionKey);
    if (!signature.equals(signature2)) {
      return GlobalResult.build(500, "签名校验失败", null);
    }
    // 5.根据返回的User实体类，判断用户是否是新用户，是的话，将用户信息存到数据库；不是的话，更新最新登录时间
    User user = this.userMapper.selectByPrimaryKey(openid);
    // uuid生成唯一key，用于维护微信小程序用户与服务端的会话
    String skey = UUID.randomUUID().toString();
    if (user == null) {
      // 用户信息入库
      String nickName = rawDataJson.getString("nickName");
      String avatarUrl = rawDataJson.getString("avatarUrl");
      String gender = rawDataJson.getString("gender");
      String city = rawDataJson.getString("city");
      String country = rawDataJson.getString("country");
      String province = rawDataJson.getString("province");

      user = new User();
      user.setOpenId(openid);
      user.setSkey(skey);
      user.setCreateTime(new Date());
      user.setLastVisitTime(new Date());
      user.setSessionKey(sessionKey);
      user.setCity(city);
      user.setProvince(province);
      user.setCountry(country);
      user.setAvatarUrl(avatarUrl);
      user.setGender((byte) Integer.parseInt(gender));
      user.setNickName(nickName);

      this.userMapper.insert(user);
    } else {
      // 已存在，更新用户登录时间
      user.setLastVisitTime(new Date());
      // 重新设置会话skey
      user.setSkey(skey);
      this.userMapper.updateByPrimaryKey(user);
    }
    // encrypteData比rowData多了appid和openid
    // JSONObject userInfo = WechatUtil.getUserInfo(encrypteData, sessionKey, iv);
    // 6. 把新的skey返回给小程序
    GlobalResult result = GlobalResult.build(200, null, skey);
    return result;
  }

  @GetMapping("wx/index")
  public GlobalResult index() {
    String skey = UUID.randomUUID().toString();
    GlobalResult result = GlobalResult.build(200, skey, skey);
    return result;
  }

  @PostMapping("wx/QRData")
  public GlobalResult QRDdata(
      @RequestParam(value = "code", required = true) String code,
      @RequestParam(value = "date", required = true) String date) {
    if (code == null) {
      GlobalResult result = GlobalResult.build(200, null, null);
      return result;
    }
    String strCode = code;
    String[] lst = strCode.split(",");

    // String invoicecode, Long id, String firstunknown, String invoicetype,
    // String invoicenumber, Float amount, String dateissued, String invoiceverifycode,
    // String lastunknown, Date inserttime
    if (lst.length < 8) {
      GlobalResult result = GlobalResult.build(200, "QRCode code is Error", null);
      return result;
    }
    Qrcode qrCode = new Qrcode();
    qrCode.setFirstunknown(lst[0]);
    qrCode.setInvoicetype(lst[1]);
    qrCode.setInvoicecode(lst[2]);
    qrCode.setInvoicenumber(lst[3]);
    qrCode.setAmount(Float.parseFloat(lst[4]));
    qrCode.setDateissued(lst[5]);
    qrCode.setInvoiceverifycode(lst[6]);
    qrCode.setLastunknown(lst[7]);

//    qrCode.setId(3L);
//    qrCode.setInserttime(
//            new Timestamp(
//                    (new Date()).getTime()
//            )
//    );

    int iRet = qrCodeMapper.insert(qrCode);

    GlobalResult result = GlobalResult.build(200, String.format("id:%d", qrCode.getId() ), null);
    return result;
  }
}
