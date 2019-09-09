//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    var guserinfo=null;
 
    // 登录
    wx.login({
      success: res => {
        var code = res.code;
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        if (res.code) {
          // 必须是在用户已经授权的情况下调用
          wx.getUserInfo({
            success: function (res) {
              guserinfo = res;
              /*
              var userInfo = res.userInfo
              var nickName = userInfo.nickName
              var avatarUrl = userInfo.avatarUrl
              var gender = userInfo.gender //性别 0：未知、1：男、2：女
              var province = userInfo.province
              var city = userInfo.city
              var country = userInfo.country
              //*/

              //发起网络请求
              wx.request({
                url: 'http://127.0.0.1:8080/wx/login',
                data: {
                  code: code,
                  rawData: guserinfo.rawData,
                  encryptedData: guserinfo.encryptedData,
                  iv: guserinfo.iv,
                  signature: guserinfo.signature
                },
                method: 'POST',
                //不加header这条，Post数据服务器收不到内容
                header: { 'content-type': 'application/x-www-form-urlencoded' },
                success: res =>{
                  Console.log(JSON.stringify(res));
                },
                fail: res => {
                  Console.log(res.data);
                }
              })
            },
            fail: res => {
              Console.log(res.data);
            }
          })

          
        }else {
          Console.log('登录失败！' + res.errMsg)
        }
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authlSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            },
            fail: res =>{
              Console.log('getUserInfo Fail'+JSON.stringify(res));
            }
          })
        }
        else{
          Console.log('No Auth');
        }
      }
    })
  },
  globalData: {
    userInfo: null
  }
})